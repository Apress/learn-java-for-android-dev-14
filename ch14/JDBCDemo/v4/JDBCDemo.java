import java.sql.CallableStatement;
import java.sql.Connection;
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
            String sql = "CREATE PROCEDURE FIRE(IN ID INTEGER)" +
                         "   PARAMETER STYLE JAVA" +
                         "   LANGUAGE JAVA" +
                         "   DYNAMIC RESULT SETS 0" +
                         "   EXTERNAL NAME 'JDBCDemo.fire'";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE EMPLOYEES(ID INTEGER, NAME VARCHAR(30), " +
                  "FIRED BOOLEAN)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEES VALUES(1, 'John Doe', false)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEES VALUES(2, 'Sally Smith', false)";
            stmt.executeUpdate(sql);
            dump(stmt.executeQuery("SELECT * FROM EMPLOYEES"));
            CallableStatement cstmt = null;
            try
            {
               cstmt = con.prepareCall("{ call FIRE(?)}");
               cstmt.setInt(1, 2);
               cstmt.execute();
               dump(stmt.executeQuery("SELECT * FROM EMPLOYEES"));
               stmt.executeUpdate("DROP TABLE EMPLOYEES");
               stmt.executeUpdate("DROP PROCEDURE FIRE");
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
               if (cstmt != null)
                  try
                  {
                     cstmt.close();
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

   static void dump(ResultSet rs) throws SQLException
   {
      StringBuilder sb = new StringBuilder();
      while (rs.next())
      {
         sb.append(rs.getInt("ID"));
         sb.append(' ');
         sb.append(rs.getString("NAME"));
         sb.append(' ');
         sb.append(rs.getBoolean("FIRED"));
         System.out.println(sb);
         sb.setLength(0);
      }
      System.out.println();
   }

   public static void fire(int id) throws SQLException
   {
      Connection con = DriverManager.getConnection("jdbc:default:connection");
      String sql = "UPDATE EMPLOYEES SET FIRED=TRUE WHERE ID=" + id;
      Statement stmt = null;
      try
      {
         stmt = con.createStatement();
         stmt.executeUpdate(sql);
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
}