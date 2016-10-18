import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class SimpleFilter implements Filter
{
   @Override
   public boolean isLoggable(LogRecord record)
   {
      return (record.getSourceMethodName().equals("main")) ? true : false;
   }
}