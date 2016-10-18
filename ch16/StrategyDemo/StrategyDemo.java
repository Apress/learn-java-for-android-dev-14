public class StrategyDemo
{
   public static void main(String[] args) 
   {
      Context context = new Context(new ConcreteStrategy1());
      context.executeStrategy("Hello");
      context.setStrategy(new ConcreteStrategy2());
      context.executeStrategy("World");
   }
}