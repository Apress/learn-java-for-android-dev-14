public class MultiPrint
{
   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         System.err.println("usage: java MultiPrint text count");
         return;
      }
      String text = args[0];
      int count = Integer.parseInt(args[1]);
      for (int i = 0; i < count; i++)
         System.out.println(text);
   }
}