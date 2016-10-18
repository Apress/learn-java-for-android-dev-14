public class InnerLeakDemo
{
   public static void main(String[] args)
   {
      class Outer
      {
         String s = "outer string";

         class Inner
         {
            String s = "inner string";

            void print()
            {
               System.out.println(s);
               System.out.println(Outer.this.s);
            }
         }
      }
      Outer o = new Outer();
      Outer.Inner oi = o.new Inner();
      oi.print();
   }
}