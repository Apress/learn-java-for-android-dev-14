class Employee
{
   final int ID;

   static int counter;

   Employee()
   {
      ID = counter++;
   }
}