public class Context 
{
   private Strategy strategy;
 
   public Context(Strategy strategy) 
   {
      setStrategy(strategy);
   }
 
   public void executeStrategy(String msg) 
   {
      strategy.execute(msg);
   }

   public void setStrategy(Strategy strategy)
   {
      this.strategy = strategy;
   }
}