import java.util.Random;

public class Guess
{
   public static void main(String[] args) throws java.io.IOException
   {
      Random r = new Random();
      int hiddenValue = 'a' + r.nextInt(26);

      while (true)
      {
         int guess = 0;
         while (guess < 'a' || guess > 'z')
         {
            System.out.print("Guess between a and z inclusive: ");
            guess = System.in.read();
            System.out.println();

            // Flush carriage return or carriage return/newline combination
            // so that each character isn't automatically read during the
            // next System.in.read() method call.

            int x = 0;
            while (x != '\n')
               x = System.in.read();
         }
         if (guess < hiddenValue)
            System.out.println("too low");
         else
         if (guess > hiddenValue)
            System.out.println("too high");
         else
         {
            System.out.println("you got it");
            break;
         }
      }
   }
}