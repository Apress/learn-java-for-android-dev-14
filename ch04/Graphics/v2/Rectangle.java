class Rectangle extends Shape
{
   private Point origin, extents;

   Rectangle(int x, int y, int width, int height)
   {
      origin = new Point(x, y);
      extents = new Point(width, height);
   }

   int getX()
   {
      return origin.getX();
   }

   int getY()
   {
      return origin.getY();
   }

   int getWidth()
   {
      return extents.getX();
   }

   int getHeight()
   {
      return extents.getY();
   }

   @Override
   public String toString()
   {
      return origin.toString() + " - " + extents.toString();
   }

   @Override
   void draw()
   {
      System.out.println("Rectangle drawn at " + origin.toString() +
                         " with extents " + extents.toString());
   }
}