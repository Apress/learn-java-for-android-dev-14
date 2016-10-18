import java.lang.reflect.Array;

public class ArrayDemo
{
   public static void main(String[] args)
   {
      String[] argsCopy = (String[]) Array.newInstance(String.class, args.length);
      for (int i = 0; i < args.length; i++)
         Array.set(argsCopy, i, args[i]);
      for (int i = 0; i < args.length; i++)
         System.out.println(Array.get(argsCopy, i));
   }
}