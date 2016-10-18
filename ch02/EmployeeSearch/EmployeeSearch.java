public class EmployeeSearch
{
   public static void main(String[] args)
   {
      int[] employeeIDs = { 123, 854, 567, 912, 224 };
      int employeeSearchID = 912;
      boolean found = false;
      for (int i = 0; i < employeeIDs.length; i++)
         if (employeeSearchID == employeeIDs[i])
         {
            found = true;
            break;
         }
      System.out.println((found) ? "employee " + employeeSearchID + " exists"
                                 : "no employee ID matches " + employeeSearchID);
   }
}