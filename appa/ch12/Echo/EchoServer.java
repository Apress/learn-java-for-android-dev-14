import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
   public static void main(String[] args)
   {
      System.out.println("Starting echo server...");
      ServerSocket ss = null;
      try
      {
         ss = new ServerSocket(9999);
         File file = new File("kill");
         while (!file.exists())
         {
            Socket s = ss.accept(); // waiting for client request
            try
            {
               InputStream is = s.getInputStream();
               InputStreamReader isr = new InputStreamReader(is);
               BufferedReader br = new BufferedReader(isr);
               String msg = br.readLine();
               System.out.println(msg);
               OutputStream os = s.getOutputStream();
               OutputStreamWriter osw = new OutputStreamWriter(os);
               PrintWriter pw = new PrintWriter(osw);
               pw.println(msg);
               pw.flush();
            }
            catch (IOException ioe)
            {
               System.err.println("I/O error: " + ioe.getMessage());
            }
            finally
            {
               try 
               { 
                  s.close(); 
               } 
               catch (IOException ioe) 
               {
                  assert false; // shouldn't happen in this context
               }
            }
         }
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error: " + ioe.getMessage());
      }
      finally
      {
         if (ss != null)
            try
            {
               ss.close();
            }
            catch (IOException ioe)
            {
               assert false; // shouldn't happen in this context
            }
      }
   }
}