import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCreate
{
   public static void main(String[] args) throws IOException
   {
      if (args.length < 2)
      {
         System.err.println("usage: java ZipCreate ZIPfile infile1 "+
                            "infile2 ...");
         return;
      }
      ZipOutputStream zos = null;
      try
      {
         zos = new ZipOutputStream(new FileOutputStream(args[0]));
         byte[] buf = new byte[1024];
         for (String filename: args)
         {
            if (filename.equals(args[0]))
               continue;
            FileInputStream fis = null;
            try
            {
               fis = new FileInputStream(filename);
               zos.putNextEntry(new ZipEntry(filename));
               int len;
               while ((len = fis.read(buf)) > 0)
                  zos.write(buf, 0, len);
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
            zos.closeEntry();
         }
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error: " + ioe.getMessage());
      }
      finally
      {
         if (zos != null)
            try
            {
               zos.close();
            }
            catch (IOException ioe)
            {
               assert false; // shouldn't happen in this context
            }
      }
   }
}