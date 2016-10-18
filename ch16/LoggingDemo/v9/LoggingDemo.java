import java.io.IOException;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingDemo
{
   public static void main(String[] args) throws IOException
   {
      Logger logger = Logger.getLogger("LoggingDemo");
      FileHandler fh = new FileHandler("log");
      fh.setFormatter(new SimpleFormatter());
      logger.addHandler(fh);
      for (int i = 0; i < 5; i++)
         logger.log(Level.INFO, i+"");
   }
}