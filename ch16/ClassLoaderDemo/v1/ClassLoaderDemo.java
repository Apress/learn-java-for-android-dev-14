public class ClassLoaderDemo
{
   public static void main(String[] args)
   {
      System.out.println(Thread.currentThread().getContextClassLoader());
      System.out.println(ClassLoader.getSystemClassLoader());
   }
}