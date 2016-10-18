import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo
{
   static Logger logger = Logger.getLogger("LoggingDemo");

   public static void main(String[] args)
   {
      logger.setLevel(Level.FINER);
      Handler[] handlers = Logger.getLogger("").getHandlers();
      for (Handler handler: handlers)
         handler.setLevel(Level.FINER);
      System.out.println(factorial(5));
   }

   static int factorial(int n)
   {
      logger.entering("LoggingDemo", "factorial");
      if (n == 0 || n == 1)
      {
         logger.exiting("LoggingDemo", "factorial");
         return 1;
      }
      else
      {
         logger.exiting("LoggingDemo", "factorial");
         return n*factorial(n-1);
      }
   }
}