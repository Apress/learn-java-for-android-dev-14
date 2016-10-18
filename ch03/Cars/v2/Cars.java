public class Cars
{
   public static void main(String[] args)
   {
      Car myCar = new Car();
      myCar.make = "Toyota";
      myCar.model = "Camry";
      myCar.numDoors = 4;
      System.out.println("Make = " + myCar.make);
      System.out.println("Model = " + myCar.model);
      System.out.println("Number of doors = " + myCar.numDoors);
   }
}