import java.util.Scanner;

public class ValidateInput
{
   public static void main(String[] args)
   {
      // Scan standard input.
      Scanner scannerInput = new Scanner(System.in);

      // Keep track of current line number.
      int lineNo = 0;

      // Scan this input on a line-by-line basis.
      while (scannerInput.hasNextLine()) 
      {
         // Obtain current line.
         String curLine = scannerInput.nextLine();

         // Output line.
         System.out.printf("%d: %s%n", ++lineNo, curLine);

         // Obtain a scanner to scan the current line.
         Scanner scannerLine = new Scanner(curLine);

         // Verify that the line has a name field.
         if (scannerLine.hasNext()) 
            System.out.printf("Name: %s%n", scannerLine.next());
         else 
         { 
            System.out.printf("%d: name field missing%n%n", lineNo); 
            continue;
         }
 
         // Verify that the line has a second age field, of type integer.
         if (scannerLine.hasNextInt()) 
            System.out.printf("Age: %d%n", scannerLine.nextInt());
         else 
         {
            System.out.printf("%d: age field missing%n%n", lineNo);
            continue;
         }

         System.out.println();

         // Close current line scanner.
         scannerLine.close();
      }

      // Close standard input scanner.
      scannerInput.close();
   } 
}