public class Cars
{
   public static void main(String[] args)
   {
      System.out.println(Car.counter);
      Car myCar = new Car();
      System.out.println(Car.counter);
      Car yourCar = new Car();
      System.out.println(Car.counter);
   }
}