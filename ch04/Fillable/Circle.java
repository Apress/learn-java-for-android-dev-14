class Circle extends Point implements Drawable, Fillable
{
   private int radius;

   Circle(int x, int y, int radius)
   {
      super(x, y);
      this.radius = radius;
   }

   int getRadius()
   {
      return radius;
   }

   @Override
   public String toString()
   {
      return "" + radius;
   }

   @Override
   public void draw(int color)
   {
      System.out.println("Circle drawn at " + super.toString() +
                         " with radius " + toString() + " in color " + color);
   }

   @Override
   public void fill(int color)
   {
      System.out.println("Circle filled at " + super.toString() +
                         " with radius " + toString() + " in color " + color);
   }
}