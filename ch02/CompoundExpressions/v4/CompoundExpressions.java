public class CompoundExpressions
{
   public static void main(String[] args)
   {
      short s = (short) 1.65 + 3;
      System.out.println(s);

      char c = 'A';
      byte b = (byte) c;
      System.out.println(b);

      b = 100;
      System.out.println(b);

      s = 'A';
      System.out.println(s);

      s = (short) '\uac00';
      System.out.println(s);
   }
}