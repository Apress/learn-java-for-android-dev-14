import java.util.Enumeration;
import java.util.StringTokenizer;

public class Tokenizer
{
   public static void main(String[] args)
   {
      StringTokenizer st = new StringTokenizer("this is a test");
      while (st.hasMoreTokens())
         System.out.println(st.nextToken());
      System.out.println();

      st = new StringTokenizer("this is a test");
      Enumeration e = (Enumeration) st;
      while (e.hasMoreElements())
         System.out.println(e.nextElement());
      System.out.println();

      String[] values = "this is a test".split("\\s");
      for (int i = 0; i < values.length; i++)
         System.out.println(values[i]);
   }
}