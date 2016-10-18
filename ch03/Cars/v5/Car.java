class Car
{
   String make;
   String model;
   int numDoors;

   Car(String make, String model)
   {
      this(make, model, 4);
   }

   Car(String make, String model, int nDoors)
   {
      this.make = make;
      this.model = model;
      numDoors = nDoors;
   }

   void printDetails()
   {
      System.out.println("Make = " + make);
      System.out.println("Model = " + model);
      System.out.println("Number of doors = " + numDoors);
      System.out.println();
   }
}