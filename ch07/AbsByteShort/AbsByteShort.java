public class AbsByteShort
{
   static byte abs(byte b)
   {
      return (b < 0) ? (byte) -b : b;
   }

   static short abs(short s)
   {
      return (s < 0) ? (short) -s : s;
   }

   public static void main(String[] args)
   {
      byte b = -2;
      System.out.println(abs(b)); // Output: 2
      short s = -3;
      System.out.println(abs(s)); // Output: 3
   }
}