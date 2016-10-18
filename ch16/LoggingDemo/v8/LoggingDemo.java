import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo
{
   public static void main(String[] args) throws IOException
   {
      Logger logger = Logger.getLogger("LoggingDemo");
      logger.addHandler(new FileHandler("log"));
      for (int i = 0; i < 5; i++)
         logger.log(Level.INFO, i+"");
   }
}