class EnclosingClass
{
   private int i;

   private void m()
   {
      System.out.println(i);
   }

   class EnclosedClass
   {
      void accessEnclosingClass()
      {
         i = 1;
         m();
      }
   }
}