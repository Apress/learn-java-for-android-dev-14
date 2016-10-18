interface A
{
   int X = 1;
   void foo();
}

interface B
{
   int X = 1;
   int foo();
}

class Collision implements A, B
{
   @Override
   public void foo();

   @Override
   public int foo() { return X; }
}
