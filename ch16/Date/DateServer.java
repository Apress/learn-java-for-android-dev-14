import java.io.Console;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

import java.text.MessageFormat;

import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DateServer
{
   public final static int PORT = 5000;
   private ServerSocket ss;

   public DateServer(int port) throws IOException
   {
      ss = new ServerSocket(port);
   }

   public void runServer()
   {
      // This server application is console-based, as opposed to GUI-based.
      Console console = System.console();
      if (console == null)
      {
         System.err.println("unable to obtain system console");
         return;
      }
      // This would be a good place to log in the system administrator. For
      // simplicity, I've omitted this section.
      // Start a thread for handling client requests.
      Handler h = new Handler(ss);
      h.start();
      // Receive input from system administrator; respond to exit and clear
      // commands.
      while (true)
      {
         String cmd = console.readLine(">");
         if (cmd == null)
            continue;
         if (cmd.equals("exit"))
            System.exit(0);
         if (cmd.equals("clear"))
            h.clearRBCache();
      }
   }

   public static void main(String[] args) throws IOException
   {
      new DateServer(PORT).runServer();
   }
}

class Handler extends Thread
{
   private ServerSocket ss;
   private volatile boolean doClear;

   Handler(ServerSocket ss)
   {
      this.ss = ss;
   }

   void clearRBCache()
   {
      doClear = true;
   }

   @Override
   public void run()
   {
      ResourceBundle rb = null;
      while (true)
      {
         try
         {
            // Wait for a connection.
            Socket s = ss.accept();
            // Obtain the client's locale object.
            ObjectInputStream ois;
            ois = new ObjectInputStream(s.getInputStream());
            Locale l = (Locale) ois.readObject();
            // Prepare to output message back to client.
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            // Clear ResourceBundle's cache upon request.
            if (doClear && rb != null)
            {
               rb.clearCache();
               doClear = false;
            }
            // Obtain a resource bundle for the specified locale. If resource
            // bundle cannot be found, the client is still waiting for
            // something, so send a ?.
            try
            {
               rb = ResourceBundle.getBundle("datemsg", l);
            }
            catch (MissingResourceException mre)
            {
               pw.println("?");
               pw.close();
               continue;
            }
            // Prepare a MessageFormat to format a locale-specific template
            // containing a reference to a locale-specific date.
            MessageFormat mf;
            mf = new MessageFormat(rb.getString("datetemplate"), l);
            Object[] args = { new Date() };
            // Format locale-specific message and send to client.
            pw.println(mf.format(args));
            // It's important to close the PrintWriter so that message is
            // flushed to the client socket's output stream.
            pw.close();
         }
         catch (Exception e)
         {
            System.err.println(e);
         }
      }
   }
}