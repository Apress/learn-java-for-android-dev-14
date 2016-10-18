public class UseDrawable
{
   public static void main(String[] args)
   {
      Drawable[] drawables = new Drawable[] { new Point(10, 20),
                                              new Circle(10, 20, 30) };
      for (int i = 0; i < drawables.length; i++)
         drawables[i].draw(Drawable.RED);
   }
}