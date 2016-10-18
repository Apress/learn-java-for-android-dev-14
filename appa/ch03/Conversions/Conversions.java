public class Conversions
{
   static double c2f(double degrees)
   {
      return degrees * 9.0 / 5.0 + 32;
   }

   static double f2c(double degrees)
   {
      return (degrees - 32) * 5.0 / 9.0;
   }

   public static void main(String[] args)
   {
      System.out.println("Fahrenheit equivalent of 100 degrees Celsius is " +
                         Conversions.c2f(100));
      System.out.println("Celsius equivalent of 98.6 degrees Fahrenheit is " +
                         Conversions.f2c(98.6));
      System.out.println("Celsius equivalent of 32 degrees Fahrenheit is " +
                         f2c(32));
   }
}