class Vehicle
{
   private String make;
   private String model;
   private int year;

   Vehicle(String make, String model, int year)
   {
      this.make = make;
      this.model = model;
      this.year = year;
   }

   void describe()
   {
      System.out.println(year + " " + make + " " + model);
   }
}

public class Car extends Vehicle
{
   private int numWheels;

   Car(String make, String model, int year, int numWheels)
   {
      super(make, model, year);
   }

   void describe()
   {
      System.out.print("This car is a "); // Print without newline – see Chapter 1.
      super.describe();
   }

   public static void main(String[] args)
   {
      Car car = new Car("Ford", "Fiesta", 2009, 4);
      car.describe();
   }
}