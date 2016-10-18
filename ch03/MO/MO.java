public class MO
{
   int add(int a, int b)
   {
      System.out.println("add(int, int) called");
      return a + b;
   }

   int add(int a, int b, int c)
   {
      System.out.println("add(int, int, int) called");
      return a + b + c;
   }

   double add(double a, double b)
   {
      System.out.println("add(double, double) called");
      return a + b;
   }

   public static void main(String[] args)
   {
      MO mo = new MO();
      int result = mo.add(10, 20);
      System.out.println("Result = " + result);
      result = mo.add(10, 20, 30);
      System.out.println("Result = " + result);
      double result2 = mo.add(5.0, 8.0);
      System.out.println("Result2 = " + result2);
   }
}