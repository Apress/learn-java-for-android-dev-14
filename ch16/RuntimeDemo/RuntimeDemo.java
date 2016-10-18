public class RuntimeDemo
{
   public static void main(String[] args)
   {
      Runtime rt = Runtime.getRuntime();
      System.out.println("Available processors: " + rt.availableProcessors());
      System.out.println("Free memory: "+ rt.freeMemory());
      System.out.println("Maximum memory: " + rt.maxMemory());
      System.out.println("Total memory: " + rt.totalMemory());
   }
}