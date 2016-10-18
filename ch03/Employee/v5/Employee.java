public class Employee
{
   private String name;

   public Employee(String name)
   {
      setName(name);
   }

   public void setName(String empName)
   {
      name = empName; // Assign the empName argument to the name field.
   }

   public String getName()
   {
      return name;
   }
}