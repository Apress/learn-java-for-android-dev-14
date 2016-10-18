import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo
{
   public static void main(String[] args)
   {
      String url = "jdbc:derby:employee;create=true";
      Connection con = null;
      try
      {
         con = DriverManager.getConnection(url);
         dump(con.getMetaData());
      }
      catch (SQLException sqlex)
      {
         while (sqlex != null)
         {
            System.err.println("SQL error : " + sqlex.getMessage());
            System.err.println("SQL state : " + sqlex.getSQLState());
            System.err.println("Error code: " + sqlex.getErrorCode());
            System.err.println("Cause: " + sqlex.getCause());
            sqlex = sqlex.getNextException();
         }
      }
      finally
      {
         if (con != null)
            try
            {
               con.close();
            }
            catch (SQLException sqle)
            {
               sqle.printStackTrace();
            }
      }
   }

   static void dump(DatabaseMetaData dbmd) throws SQLException
   {
      System.out.println("DB Major Version = " + dbmd.getDatabaseMajorVersion());
      System.out.println("DB Minor Version = " + dbmd.getDatabaseMinorVersion());
      System.out.println("DB Product = " + dbmd.getDatabaseProductName());
      System.out.println("Driver Name = " + dbmd.getDriverName());
      System.out.println("Numeric function names for escape clause = " +
                         dbmd.getNumericFunctions());
      System.out.println("String function names for escape clause = " +
                         dbmd.getStringFunctions());
      System.out.println("System function names for escape clause = " +
                         dbmd.getSystemFunctions());
      System.out.println("Time/date function names for escape clause = " +
                         dbmd.getTimeDateFunctions());
      System.out.println("Catalog term: " + dbmd.getCatalogTerm());
      System.out.println("Schema term: " + dbmd.getSchemaTerm());
      System.out.println();
      System.out.println("Catalogs");
      System.out.println("--------");
      ResultSet rsCat = dbmd.getCatalogs();
      while (rsCat.next())
         System.out.println(rsCat.getString("TABLE_CAT"));
      System.out.println();
      System.out.println("Schemas");
      System.out.println("-------");
      ResultSet rsSchem = dbmd.getSchemas();
      while (rsSchem.next())
         System.out.println(rsSchem.getString("TABLE_SCHEM"));
      System.out.println();
      System.out.println("Schema/Table");
      System.out.println("------------");
      rsSchem = dbmd.getSchemas();
      while (rsSchem.next())
      {
         String schem = rsSchem.getString("TABLE_SCHEM");
         ResultSet rsTab = dbmd.getTables(null, schem, "%", null);
         while (rsTab.next())
            System.out.println(schem + " " + rsTab.getString("TABLE_NAME"));
      }
   }
}