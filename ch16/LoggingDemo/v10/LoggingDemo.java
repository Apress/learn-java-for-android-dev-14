import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo
{
   public static void main(String[] args)
   {
      Logger logger = Logger.getLogger("LoggingDemo");
      for (int i = 0; i < 5; i++)
         logger.log(Level.FINE, i+"");
   }
}