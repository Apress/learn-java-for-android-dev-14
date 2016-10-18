import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class ParseDemo
{
   public static void main(String[] args) throws ParseException
   {
      if (args.length != 1)
      {
         System.err.println("usage: java ParseDemo yyyy-MM-dd HH:mm:ss z");
         return;
      }
      SimpleDateFormat sdf;
      sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
      System.out.println(sdf.parse(args[0]));
   }
}