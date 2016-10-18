import java.util.Scanner;

public class ScannerDemo 
{
   public static void main(String[] args) 
   {
      Scanner scanner = new Scanner(System.in);
      while (true) 
      {
         System.out.printf("%nMenu Options%n%n");
         System.out.println("1: Frequency Count");
         System.out.printf("2: Quit%n%n");
         System.out.print("Enter your selection (1 or 2): ");
         int selection = scanner.nextInt();
         scanner.nextLine();
         if (selection == 1) 
         {
            System.out.printf("%nEnter sentence: ");
            String sentence = scanner.nextLine();
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            int count = 0;
            for (int i = 0; i < sentence.length(); i++)
               if (sentence.charAt(i) == sentence.charAt(index))
                  count++;
            System.out.printf("Count of [%c] in [%s]: %d%n", 
                              sentence.charAt(index), sentence, count);
         }
         else 
         if (selection == 2)
            break;
      }
      scanner.close();
   }
}