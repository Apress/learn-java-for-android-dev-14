import java.lang.reflect.Method;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo
{
   final static String CD = System.getProperty("user.dir");
   final static String _URL1_ = "file:///" + CD + "/x/";
   final static String _URL2_ = "file:///" + CD + "/y/";

   public static void main(String[] args)
   {
      try
      {
         URL[] urls = new URL[] { new URL(_URL1_) };
         URLClassLoader urlc1 = new URLClassLoader(urls);
         Class<?> clazz1 = Class.forName("Version", true, urlc1);
         run(clazz1);
         urls = new URL[] { new URL(_URL2_) };
         URLClassLoader urlc2 = new URLClassLoader(urls);
         Class<?> clazz2 = Class.forName("Version", true, urlc2);
         run(clazz2);
         Thread.currentThread().setContextClassLoader(urlc1);
         run(Thread.currentThread().getContextClassLoader().loadClass("Version"));
         Thread.currentThread().
            setContextClassLoader(ClassLoader.getSystemClassLoader());
         run(Thread.currentThread().getContextClassLoader().loadClass("Version"));
      }
      catch (ClassNotFoundException cnfe)
      {
         System.err.println("Class not found");
      }
      catch (MalformedURLException murle)
      {
         System.err.println("URL is malformed");
      }
   }

   static void run(Class<?> clazz)
   {
      try
      {
         Method main = clazz.getMethod("main", new Class[] { String[].class });
         Object[] args = new Object[] { new String[0] };
         main.invoke(null, args);
      }
      catch (Exception e)
      {
         System.err.println(e.getMessage());
      }
   }
}