public class CompoundExpressions
{
   public static void main(String[] args)
   {
      int age = 65;
      boolean stillWorking = true;
      System.out.println(age > 64 && stillWorking);
      age--;
      System.out.println(age > 64 && stillWorking);
      int value = 30;
      System.out.println(value < 20 || value > 40);
      value = 10;
      System.out.println(value < 20 || value > 40);
      int numEmployees = 6;
      age = 65;
      System.out.println(age > 64 && ++numEmployees > 5);
      System.out.println("numEmployees = " + numEmployees);
      age = 63;
      System.out.println(age > 64 && ++numEmployees > 5);
      System.out.println("numEmployees = " + numEmployees);
      boolean b = true;
      int i = b ? 1 : 0; // 1 assigns to i
      System.out.println("i = " + i);
      b = false;
      i = b ? 1 : 0; // 0 assigns to i
      System.out.println("i = " + i);
   }
}