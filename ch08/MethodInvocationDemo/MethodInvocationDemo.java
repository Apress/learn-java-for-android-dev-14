import java.lang.reflect.Method;

class X
{
   public void objectMethod(String arg)
   {
      System.out.println("Instance method: " + arg);
   }

   public static void classMethod()
   {
      System.out.println("Class method");
   }
}

public class MethodInvocationDemo
{
   public static void main(String[] args)
   {
      try
      {
         Class<?> clazz = Class.forName("X");
         X x = (X) clazz.newInstance();
         Class[] argTypes = { String.class };
         Method method = clazz.getMethod("objectMethod", argTypes);
         Object[] data = { "Hello" };
         method.invoke(x, data); // Output: Instance method: Hello
         method = clazz.getMethod("classMethod", (Class<?>[]) null);
         method.invoke(null, (Object[]) null); // Output: Class method
      }
      catch (Exception e)
      {
         System.err.println(e);
      }
   }
}