public class ConcreteStrategy2 implements Strategy 
{
   @Override
   public void execute(String msg) 
   {
      for (int i = 0; i < 3; i++)
         System.out.printf("executing strategy #2: msg = %s%n", msg);
   }    
}