public class CompoundExpressions
{
   public static void main(String[] args)
   {
      System.out.println(60 + 3 * 6);
      System.out.println(2 * ((60 + 3) * 6));
      System.out.println(9 * 4 / 3);
      int x, y, z;
      x = y = z = 100;
      System.out.println(x);
      System.out.println(y);
      System.out.println(z);

      int i = 0x12345678;
      byte b = (byte) (i & 255);
      System.out.println(b);
      System.out.println("b == 0x78: " + (b == 0x78));
      b = (byte) ((i >> 8) & 255);
      System.out.println(b);
      System.out.println("b == 0x56: " + (b == 0x56));
      b = (byte) ((i >> 16) & 255);
      System.out.println(b);
      System.out.println("b == 0x34: " + (b == 0x34));
      b = (byte) ((i >> 24) & 255);
      System.out.println(b);
      System.out.println("b == 0x12: " + (b == 0x12));
  }
}