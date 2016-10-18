public class ConcreteStrategy1 implements Strategy 
{
   @Override
   public void execute(String msg) 
   {
      System.out.printf("executing strategy #1: msg = %s%n", msg);
   }    
}