class A
{
}

class B extends A
{
   void m()
   {
   }
}

public class DowncastDemo
{
   public static void main(String[] args)
   {
      A a = new A();
      B b = (B) a;
      b.m();
   }
}