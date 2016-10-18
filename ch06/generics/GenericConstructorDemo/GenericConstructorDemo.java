public class GenericConstructorDemo
{
   <T> GenericConstructorDemo(T type)
   {
      System.out.println(type);
   }

   public static void main(String[] args)
   {
      GenericConstructorDemo gcd = new GenericConstructorDemo("ABC");
      gcd = new GenericConstructorDemo(new Integer(100));
   }
}