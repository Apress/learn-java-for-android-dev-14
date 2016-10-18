public class Employee
{
   private String firstName;
   private String lastName;

   public Employee(String name)
   {
      setName(name);
   }

   public Employee(String firstName, String lastName)
   {
      setName(firstName + " " + lastName);
   }

   public void setName(String name)
   {
      // Assume that the first and last names are separated by a
      // single space character. indexOf() locates a character in a 
      // string; substring() returns a portion of a string.
      setFirstName(name.substring(0, name.indexOf(' ')));
      setLastName(name.substring(name.indexOf(' ') + 1));
   }

   public String getName()
   {
      return getFirstName() + " " + getLastName();
   }

   public void setFirstName(String empFirstName)
   {
      firstName = empFirstName;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setLastName(String empLastName)
   {
      lastName = empLastName;
   }

   public String getLastName()
   {
      return lastName;
   }
}