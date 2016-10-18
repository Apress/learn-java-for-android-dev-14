import java.io.File;
import java.io.InputStream;
import java.io.IOException;

public class ClassLoaderDemo
{
   final static String IMAGE = "mars.jpg";

   public static void main(String[] args)
   {
      System.out.println(ClassLoaderDemo.class.getClassLoader());
      InputStream is = ClassLoaderDemo.class.getResourceAsStream(IMAGE);
      if (is == null)
      {
         System.err.printf("%s not found%n", IMAGE);
         return;
      }
      try
      {
         byte[] image = new byte[getLength(is)];
         is = ClassLoaderDemo.class.getResourceAsStream(IMAGE);
         int _byte, i = 0;
         while ((_byte = is.read()) != -1)
            image[i++] = (byte) _byte;
         for (i = 0; i < 16; i++)
            System.out.printf("%02X ", image[i]);
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error: " + ioe.getMessage());
      }
   }

   static int getLength(InputStream is) throws IOException
   {
      byte[] buffer = new byte[1024];
      int length = 0;
      int bytesRead;
      while ((bytesRead = is.read(buffer)) > 0) 
         length += bytesRead;
      return length;
   }
}