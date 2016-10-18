public class EchoText
{
   public static void main(String[] args)
   {
      boolean isRedirect = false;
      if (args.length != 0)
         isRedirect = true;
      int ch;
      try
      {
         while ((ch = System.in.read()) != ((isRedirect) ? -1 : '\n'))
            System.out.print((char) ch);
      }
      catch (java.io.IOException ioe)
      {
         System.err.println("I/O error");
      }
      System.out.println();
   }
}