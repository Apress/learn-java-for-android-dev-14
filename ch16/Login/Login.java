import java.io.Console;
import java.io.IOError;

public class Login
{
   public static void main(String[] args)
   {
      Console console = System.console();
      if (console == null)
      {
         System.err.println("no console device is present");
         return;
      }
      try
      {
         String username = console.readLine("Username:");
         char[] pwd = console.readPassword("Password:");
         // Do something useful with the username and password. For something
         // to do, this application just prints out these values.
         System.out.println("Username = " + username);
         System.out.println("Password = " + new String(pwd));
         // Prepare username String for garbage collection. More importantly,
         // destroy the password.
         username = "";
         for (int i = 0; i < pwd.length; i++)
            pwd[i] = 0;
      }
      catch (IOError ioe)
      {
         console.printf("I/O error: %s\n", ioe.getMessage());
      }
   }
}