class Bird
{
   void describe()
   {
      // code that outputs a description of a bird's appearance and behaviors
   }
}

class Horse
{
   void describe()
   {
      // code that outputs a description of a horse's appearance and behaviors
   }
}

public class FlyingHorse extends Bird, Horse
{
   public static void main(String[] args)
   {
      FlyingHorse pegasus = new FlyingHorse();
      pegasus.describe();
   }
}