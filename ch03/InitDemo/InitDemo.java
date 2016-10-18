public class InitDemo
{
   static double double1;
   double double2;
   static int int1;
   int int2;
   static String string1;
   String string2;

   static
   {
      System.out.println("[class] double1 = " + double1);
      System.out.println("[class] int1 = " + int1);
      System.out.println("[class] string1 = " + string1);
      System.out.println();
   }

   {
      System.out.println("[instance] double2 = " + double2);
      System.out.println("[instance] int2 = " + int2);
      System.out.println("[instance] string2 = " + string2);
      System.out.println();
   }

   static
   {
      double1 = 1.0;
      int1 = 1000000000;
      string1 = "abc";
   }

   {
      double2 = 1.0;
      int2 = 1000000000;
      string2 = "abc";
   }

   InitDemo()
   {
      System.out.println("InitDemo() called");
      System.out.println();
   }

   static double double3 = 10.0;
   double double4 = 10.0;

   static
   {
      System.out.println("[class] double3 = " + double3);
      System.out.println();
   }

   {
      System.out.println("[instance] double4 = " + double3);
      System.out.println();
   }

   public static void main(String[] args)
   {
      System.out.println ("main() started");
      System.out.println();
      System.out.println("[class] double1 = " + double1);
      System.out.println("[class] double3 = " + double3);
      System.out.println("[class] int1 = " + int1);
      System.out.println("[class] string1 = " + string1);
      System.out.println();
      for (int i = 0; i < 2; i++)
      {
         System.out.println("About to create InitDemo object");
         System.out.println();
         InitDemo id = new InitDemo();
         System.out.println("id created");
         System.out.println();
         System.out.println("[instance] id.double2 = " + id.double2);
         System.out.println("[instance] id.double4 = " + id.double4);
         System.out.println("[instance] id.int2 = " + id.int2);
         System.out.println("[instance] id.string2 = " + id.string2);
         System.out.println();
      }
   }
}