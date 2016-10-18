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
         Statement stmt = null;
         try
         {
            stmt = con.createStatement();
            String sql;
            if (!isExist(con, "EMPLOYEES"))
            {
               System.out.println("EMPLOYEES doesn't exist");
               sql = "CREATE TABLE EMPLOYEES(ID INTEGER, NAME VARCHAR(30))";
               stmt.executeUpdate(sql);
            }
            else
               System.out.println("EMPLOYEES already exists");
            sql = "INSERT INTO EMPLOYEES VALUES(1, 'John Doe')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEES VALUES(2, 'Sally Smith')";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
            while (rs.next())
               System.out.println(rs.getInt("ID") + " " + rs.getString("NAME"));
            stmt.executeUpdate("DROP TABLE EMPLOYEES");
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
            if (stmt != null)
               try
               {
                  stmt.close();
               }
               catch (SQLException sqle)
               {
                  sqle.printStackTrace();
               }
         }
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

   static boolean isExist(Connection con, String tableName) throws SQLException
   {
      DatabaseMetaData dbmd = con.getMetaData();
      ResultSet rs = dbmd.getTables(null, "APP", tableName, null);
      return rs.next();
   }
}