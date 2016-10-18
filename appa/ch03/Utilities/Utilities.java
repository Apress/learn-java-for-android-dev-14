public class Utilities
{
   static int factorial1(int n)
   {
      int product = 1;
      for (int i = 2; i <= n; i++)
         product *= i;
      return product;
   }

   static int factorial2(int n)
   {
      if (n == 0 || n == 1)
         return 1; // base problem
      else
         return n * factorial2(n - 1);
   }

   static double sum(double... values)
   {
      int total = 0;
      for (int i = 0; i < values.length; i++)
         total += values[i];
      return total;
   }

   public static void main(String[] args)
   {
      System.out.println(factorial1(4));
      System.out.println(factorial2(4));
      System.out.println(factorial2(0));
      System.out.println(factorial2(1));
      System.out.println(sum(10.0, 20.0));
      System.out.println(sum(30.0, 40.0, 50.0));
   }
}