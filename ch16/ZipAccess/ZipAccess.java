import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipAccess
{
   public static void main(String[] args) throws IOException
   {
      if (args.length != 1)
      {
         System.err.println("usage: java ZipAccess zipfile");
         return;
      }
      ZipInputStream zis = null;
      try
      {
         zis = new ZipInputStream(new FileInputStream(args[0]));
         byte[] buffer = new byte[4096];
         ZipEntry ze;
         while ((ze = zis.getNextEntry()) != null)
         {
            System.out.println("Extracting: " + ze);
            FileOutputStream fos = null;
            try
            {
               fos = new FileOutputStream(ze.getName());
               int numBytes;
               while ((numBytes = zis.read(buffer, 0, buffer.length)) != -1)
                  fos.write(buffer, 0, numBytes);
            }
            catch (IOException ioe)
            {
               System.err.println("I/O error: " + ioe.getMessage());
            }
            finally
            {
               if (fos != null)
                  try
                  {
                     fos.close();
                  }
                  catch (IOException ioe)
                  {
                     assert false; // shouldn't happen in this context
                  }
            }
            zis.closeEntry();
         }
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error: " + ioe.getMessage());
      }
      finally
      {
         if (zis != null)
            try
            {
               zis.close();
            }
            catch (IOException ioe)
            {
               assert false; // shouldn't happen in this context
            }
      }
   }
}