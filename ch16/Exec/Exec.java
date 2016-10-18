import java.io.InputStream;
import java.io.IOException;

public class Exec
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java Exec program");
         return;
      }
      try
      {
         Process p = Runtime.getRuntime().exec(args[0]);
         // Obtaining process standard output.
         InputStream is = p.getInputStream();
         int _byte;
         while ((_byte = is.read()) != -1)
            System.out.print((char) _byte);
         // Obtaining process standard error.
         is = p.getErrorStream();
         while ((_byte = is.read()) != -1)
            System.out.print((char) _byte);
         System.out.println("Exit status: " + p.waitFor());
      }
      catch (InterruptedException ie)
      {
         assert false; // should never happen
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error: " + ioe.getMessage());
      }   
   }
}