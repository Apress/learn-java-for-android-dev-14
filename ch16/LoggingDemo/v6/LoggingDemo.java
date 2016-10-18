import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java LoggingDemo filespec");
         return;
      }
      Logger logger = Logger.getLogger("LoggingDemo");
      FileInputStream fis = null;
      try
      {
         fis = new FileInputStream(args[0]);
      }
      catch (FileNotFoundException fnfe)
      {
         logger.log(Level.INFO, "file not found", fnfe);
      }
      finally
      {
         if (fis != null)
            try
            {
               fis.close();
            }
            catch (IOException ioe)
            {
            }
      }
   }
}