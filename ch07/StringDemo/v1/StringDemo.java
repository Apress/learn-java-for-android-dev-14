public class StringDemo
{
   public static void main(String[] args)
   {
      System.out.println("abc".length());
      System.out.println("abc" instanceof String);
      System.out.println("abc" == "a" + "bc");
      System.out.println("abc" == new String("abc"));
      System.out.println("abc" == new String("abc").intern());
   }
}