public class Compass
{
   public static void main(String[] args)
   {
      int direction = 1;
      switch (direction)
      {
         case  0: System.out.println("You are travelling north."); break;
         case  1: System.out.println("You are travelling east."); break;
         case  2: System.out.println("You are travelling south."); break;
         case  3: System.out.println("You are travelling west."); break;
         default: System.out.println("You are lost.");
      }
   }
}