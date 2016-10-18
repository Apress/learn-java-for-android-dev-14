import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class MakeRunnableJAR
{
   public static void main(String[] args) throws IOException
   {
      if (args.length < 2)
      {
         System.err.println("usage: java MakeRunnableJAR JARfile " + 
                            "classfile1 classfile2 ...");
         return;
      }
      JarOutputStream jos = null;
      try
      {
         Manifest mf = new Manifest();
         Attributes attr = mf.getMainAttributes();
         attr.put(Attributes.Name.MANIFEST_VERSION, "1.0");
         attr.put(Attributes.Name.MAIN_CLASS, 
                  args[1].substring(0, args[1].indexOf('.')));
         jos = new JarOutputStream(new FileOutputStream(args[0]), mf);
         byte[] buf = new byte[1024];
         for (String filename: args)
         {
            if (filename.equals(args[0]))
               continue;
            FileInputStream fis = null;
            try
            {
               fis = new FileInputStream(filename);
               jos.putNextEntry(new JarEntry(filename));
               int len;
               while ((len = fis.read(buf)) > 0)
                  jos.write(buf, 0, len);
            }
            catch (IOException ioe)
            {
               System.err.println("I/O error: " + ioe.getMessage());
            }
            finally
            {
               if (fis != null)
                  try
                  {
                     fis.close();
                  }
                  catch (IOException ioe)
                  {
                     assert false; // shouldn't happen in this context
                  }
            }
            jos.closeEntry();
         }
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error: " + ioe.getMessage());
      }
      finally
      {
         if (jos != null)
            try
            {
               jos.close();
            }
            catch (IOException ioe)
            {
               assert false; // shouldn't happen in this context
            }
      }
   }
}