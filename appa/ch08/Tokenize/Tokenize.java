import java.util.StringTokenizer;

public class Tokenize
{
   public static void main(String[] args)
   {
      String date = "03-12-2014 03:05:20";
      StringTokenizer st = new StringTokenizer(date, "- :");
      System.out.println("Month = " + st.nextToken());
      System.out.println("Day = " + st.nextToken());
      System.out.println("Year = " + st.nextToken());
      System.out.println("Hour = " + st.nextToken());
      System.out.println("Minute = " + st.nextToken());
      System.out.println("Second = " + st.nextToken());
   }
}