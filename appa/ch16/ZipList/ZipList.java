import java.io.FileInputStream;
import java.io.IOException;

import java.util.Date;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipList
{
   public static void main(String[] args) throws IOException
   {
      if (args.length != 1)
      {
         System.err.println("usage: java ZipList zipfile");
         return;
      }
      ZipInputStream zis = null;
      try
      {
         zis = new ZipInputStream(new FileInputStream(args[0]));
         ZipEntry ze;
         while ((ze = zis.getNextEntry()) != null)
         {
            System.out.println(ze.getName());
            System.out.println("   Compressed Size: " + ze.getCompressedSize());
            System.out.println("   Uncompressed Size: " + ze.getSize());
            if (ze.getTime() != -1)
               System.out.println("   Modification Time: " + new Date(ze.getTime()));
            System.out.println();
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