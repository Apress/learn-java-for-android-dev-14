public class EVDump
{
   public static void main(String[] args)
   {
      System.out.println(System.getenv()); // System.out.println() calls toString()
                                           // on its object argument and outputs this 
                                           // string
   }
}