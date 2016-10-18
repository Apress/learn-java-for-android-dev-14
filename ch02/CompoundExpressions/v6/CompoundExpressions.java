public class CompoundExpressions
{
   public static void main(String[] args)
   {
      System.out.println(!false);
      int age = 65;
      boolean stillWorking = true;
      System.out.println(age > 64 & stillWorking);
      System.out.println();
      
      boolean result = true & true;
      System.out.println("true & true: " + result);
      result = true & false;
      System.out.println("true & false: " + result);
      result = false & true;
      System.out.println("false & true: " + result);
      result = false & false;
      System.out.println("false & false: " + result);
      System.out.println();

      result = true | true;
      System.out.println("true | true: " + result);
      result = true | false;
      System.out.println("true | false: " + result);
      result = false | true;
      System.out.println("false | true: " + result);
      result = false | false;
      System.out.println("false | false: " + result);
      System.out.println();

      result = true ^ true;
      System.out.println("true ^ true: " + result);
      result = true ^ false;
      System.out.println("true ^ false: " + result);
      result = false ^ true;
      System.out.println("false ^ true: " + result);
      result = false ^ false;
      System.out.println("false ^ false: " + result);
      System.out.println();

      int numEmployees = 1;
      age = 65;
      System.out.println(age > 64 & ++numEmployees > 2);
      System.out.println(numEmployees);
   }
}