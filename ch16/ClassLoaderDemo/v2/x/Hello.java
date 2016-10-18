public class Hello
{
   static
   {
      System.out.println("Welcome to Hello");
   }

   static int x = 1;

   public static void main(String[] args)
   {
      System.out.println("Hello");
      System.out.println("Number of arguments = " + args.length);
      System.out.println("x = " + x);
   }
}