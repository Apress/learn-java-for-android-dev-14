public class Graphics
{
   public static void main(String[] args)
   {
      Shape[] shapes = new Shape[] { new Point(10, 20), new Circle(10, 20, 30),
                                     new Rectangle(20, 30, 15, 25) };
      for (int i = 0; i < shapes.length; i++)
         shapes[i].draw();
   }
}