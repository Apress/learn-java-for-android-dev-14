public class PrivateAccess
{
   private int x;

   PrivateAccess(int x)
   {
      this.x = x;
   }

   boolean equalTo(PrivateAccess pa)
   {
      return pa.x == x;
   }

   public static void main(String[] args)
   {
      PrivateAccess pa1 = new PrivateAccess(10);
      PrivateAccess pa2 = new PrivateAccess(20);
      PrivateAccess pa3 = new PrivateAccess(10);
      System.out.println("pa1 equal to pa2: " + pa1.equalTo(pa2));
      System.out.println("pa2 equal to pa3: " + pa2.equalTo(pa3));
      System.out.println("pa1 equal to pa3: " + pa1.equalTo(pa3));
      System.out.println(pa2.x);
   }
}