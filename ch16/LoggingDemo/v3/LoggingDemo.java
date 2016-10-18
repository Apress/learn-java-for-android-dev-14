import java.util.Locale;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo
{
   public static void main(String[] args)
   {
      Locale.setDefault(Locale.FRANCE);
      Logger logger = Logger.getLogger("LoggingDemo");
      logger.logrb(Level.INFO, "LoggingDemo", "main", "msg", "hello");
   }
}