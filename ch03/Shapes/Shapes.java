class Circle
{
   Circle()
   {
      System.out.println("Circle() called");
   }

   public static void main(String[] args)
   {
      new Circle();
   }
}

class Rectangle
{
   Rectangle()
   {
      System.out.println("Rectangle() called");
   }

   public static void main(String[] args)
   {
      new Rectangle();
   }
}

public class Shapes
{
   public static void main(String[] args)
   {
      Circle c = new Circle();
      Rectangle r = new Rectangle();
   }
}