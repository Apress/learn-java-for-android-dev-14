import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo
{
   public static void main(String[] args)
   {
      Logger logger = Logger.getLogger("LoggingDemo");
      logger.setFilter(new SimpleFilter());
      logger.log(Level.INFO, "Message 1");
      logger.log(Level.INFO, "Message 2");
      foo(logger);
      System.out.println();
      logger.setFilter(null);
      foo(logger);
   }

   static void foo(Logger logger)
   {
      logger.log(Level.INFO, "Message 3");
   }
}