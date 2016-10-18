import java.lang.reflect.Field;

class X
{
   public int i = 10;
   public static final double PI = 3.14;
}

public class FieldAccessDemo
{
   public static void main(String[] args)
   {
      try
      {
         Class<?> clazz = Class.forName("X");
         X x = (X) clazz.newInstance();
         Field f = clazz.getField("i");
         System.out.println(f.getInt(x)); // Output: 10
         f.setInt(x, 20);
         System.out.println(f.getInt(x)); // Output: 20
         f = clazz.getField("PI");
         System.out.println(f.getDouble(null)); // Output: 3.14
         f.setDouble(x, 20);
         System.out.println(f.getDouble(null)); // Never executed
      }
      catch (Exception e)
      {
         System.err.println(e);
      }
   }
}