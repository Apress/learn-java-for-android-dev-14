public class SimpleExpressions
{
   public static void main(String[] args)
   {
      int counter = 30;
      int counter2 = counter;
      System.out.println(counter);

      short s = 20;
      System.out.println(s);
      int i = s;
      System.out.println(i);

      // short s2 = 40000; // possible loss of precision error

      int i2 = -1;
      double d = i2;
      System.out.println(d);
   }
}