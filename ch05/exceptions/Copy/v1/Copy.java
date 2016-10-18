import java.io.IOException;

public class Copy
{
   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         System.err.println("usage: java Copy srcFile dstFile");
         return;
      }

      int fileHandleSrc = 0;
      int fileHandleDst = 1;
      try
      {
         fileHandleSrc = open(args[0]);
         fileHandleDst = create(args[1]);
         copy(fileHandleSrc, fileHandleDst);
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error: " + ioe.getMessage());
         return;
      }
      finally
      {
         close(fileHandleSrc);
         close(fileHandleDst);
      }
   }

   static int open(String filename)
   {
      return 1; // Assume that filename is mapped to integer.
   }

   static int create(String filename)
   {
      return 2; // Assume that filename is mapped to integer.
   }

   static void close(int fileHandle)
   {
      System.out.println("closing file: " + fileHandle);
   }

   static void copy(int fileHandleSrc, int fileHandleDst) throws IOException
   {
      System.out.println("copying file " + fileHandleSrc + " to file " +
                         fileHandleDst);
      if (Math.random() < 0.5)
         throw new IOException("unable to copy file");
   }
}