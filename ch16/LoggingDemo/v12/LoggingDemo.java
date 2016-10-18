import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.ErrorManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class LoggingDemo
{
   public static void main(String[] args) throws IOException
   {
      Logger logger = Logger.getLogger("LoggingDemo");
      FileOutputStream fos = new FileOutputStream("log");
      StreamHandler sh = new StreamHandler(fos, new SimpleFormatter());
      sh.setErrorManager(new MyErrorManager());
      logger.addHandler(sh);
      for (int i = 0; i < 5; i++)
      {
         logger.log(Level.INFO, i+"");
         if (i == 0)
            fos.close();
      }
   }
}

class MyErrorManager extends ErrorManager
{
   @Override
   public void error(String msg, Exception ex, int code)
   {
      System.err.println("===============================================");
      super.error(msg, ex, code);
      System.err.println("===============================================");
   }
}