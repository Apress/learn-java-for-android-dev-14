public class Graphics
{
   public static void main(String[] args)
   {
      Point[] points = new Point[] { new Point(10, 20), new Circle(10, 20, 30) };
      for (int i = 0; i < points.length; i++)
         points[i].draw();
   }
}