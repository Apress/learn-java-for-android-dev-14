public class Cars
{
   public static void main(String[] args)
   {
      Car myCar = new Car("Toyota", "Camry");
      System.out.println("Make = " + myCar.make);
      System.out.println("Model = " + myCar.model);
      System.out.println("Number of doors = " + myCar.numDoors);
      System.out.println();
      Car yourCar = new Car("Mazda", "RX-8", 2);
      System.out.println("Make = " + yourCar.make);
      System.out.println("Model = " + yourCar.model);
      System.out.println("Number of doors = " + yourCar.numDoors);
   }
}