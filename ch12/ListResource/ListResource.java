import java.io.InputStream;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

public class ListResource
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java ListResource url");
         return;
      }
      try
      {
         URL url = new URL(args[0]);
         InputStream is = url.openStream();
         try
         {
            int ch;
            while ((ch = is.read()) != -1)
               System.out.print((char) ch);
         }
         catch (IOException ioe)
         {
            is.close();
         }
      }
      catch (MalformedURLException murle)
      {
         System.err.println("invalid URL");
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error: " + ioe.getMessage());
      }
   }
}