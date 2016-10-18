public class PromptForC
{
   public static void main(String[] args) throws java.io.IOException
   {
      int ch;
      do
      {
         System.out.println("Press C or c to continue.");
         ch = System.in.read();
      }
      while (ch != 'C' && ch != 'c');
   }
}