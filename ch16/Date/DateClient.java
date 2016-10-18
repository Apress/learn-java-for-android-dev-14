import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

import java.net.Socket;

import java.util.Locale;

public class DateClient
{
   final static int PORT = 5000;

   public static void main(String[] args)
   {
      try
      {
         // Establish a connection to the date server. For simplicity, the
         // server is assumed to run on the same machine as the client. The
         // PORT constants of both server and client must be the same.
         Socket s = new Socket("localhost", PORT);
         // Send the default locale to the date server.
         ObjectOutputStream oos;
         oos = new ObjectOutputStream(s.getOutputStream());
         oos.writeObject(Locale.getDefault());
         // Obtain and output the server's response.
         InputStreamReader isr;
         isr = new InputStreamReader(s.getInputStream());
         BufferedReader br = new BufferedReader(isr);
         System.out.println(br.readLine());
      }
      catch (Exception e)
      {
         System.err.println(e);
      }
   }
}