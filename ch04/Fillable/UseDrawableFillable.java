public class UseDrawableFillable
{
   public static void main(String[] args)
   {
      Drawable[] drawables = new Drawable[] { new Point(10, 20),
                                              new Circle(10, 20, 30) };
      for (int i = 0; i < drawables.length; i++)
         drawables[i].draw(Drawable.RED);
      Fillable[] fillables = new Fillable[drawables.length];
      for (int i = 0; i < drawables.length; i++)
      {
         fillables[i] = (Fillable) drawables[i];
         fillables[i].fill(Fillable.GREEN);
      }
   }
}