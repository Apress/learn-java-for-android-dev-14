class Point implements Drawable, Fillable
{
   private int x, y;

   Point(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   int getX()
   {
      return x;
   }

   int getY()
   {
      return y;
   }

   @Override
   public String toString()
   {
      return "(" + x + ", " + y + ")";
   }

   @Override
   public void draw(int color)
   {
      System.out.println("Point drawn at " + toString() + " in color " + color);
   }

   @Override
   public void fill(int color)
   {
      System.out.println("Point filled at " + toString() + " in color " + color);
   }
}