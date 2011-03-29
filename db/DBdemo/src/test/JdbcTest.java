/*
 * Created on 07.04.2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.sql.*;
/**
 * @author Bernhard C. Wyss
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JdbcTest {

    public static void main(String[] args) throws SQLException{
        // Load the Oracle JDBC driver
        try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
        }
        try {
        	String host = "hades.imvs.technik.fhnw.ch";
        	String port = "1521";
        	String dbname = "hades11g";
        	String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbname;
        	// Connect to the database
          Connection conn = DriverManager.getConnection (url, "xxx", "***");

          // Create a statement
          Statement stmt = conn.createStatement ();
          ResultSet rset = stmt.executeQuery ("select * from registrierungen");
          ResultSetMetaData rsmeta = rset.getMetaData(); 
          int numCols = rsmeta.getColumnCount();
          System.out.println(numCols);
          for (int i = 1; i <= numCols; i++){
          	System.out.print(rsmeta.getColumnName(i));
          	System.out.print("  ");
          }
          System.out.println();
          while (rset.next ()) {
            for (int i = 1; i <= numCols; i++){
            	System.out.print(rset.getString(i));
            	System.out.print("  ");
            }
            System.out.println();
          }

          // close the resultSet
          rset.close();

          // Close the statement
          stmt.close();

          // Close the connection
          conn.close();
        } catch (SQLException exc){
        	System.out.println(exc.getMessage());
        }
    }
}
