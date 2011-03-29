package test;

import java.sql.*;

//import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;
import javax.naming.*;

public class JDBCVersion {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException, NamingException{
		// TODO Auto-generated method stub
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException cnfe) {
        System.out.println("Error loading driver: " + cnfe);
    }
    try {
  		OracleDataSource ods = new OracleDataSource();
	  	ods.setServiceName("hades11g.hades.fhnw.ch");
    //		ods.setDatabaseName("hades11g");
    // we use servicename!
		  ods.setServerName("hades.imvs.technik.fhnw.ch");
		  ods.setDriverType("thin");
		  ods.setPortNumber(1521);
		  ods.setUser("xxx");
		  ods.setPassword("***");
		
		  System.out.println("Database Name: " + ods.getDatabaseName());
		  System.out.println("Data Source Name: " + ods.getDataSourceName());
		  System.out.println("Description: " + ods.getDescription());
		  System.out.println("Network Protocol: " + ods.getNetworkProtocol());
		  System.out.println("Port Number: " + ods.getPortNumber());
		  System.out.println("Server Name: " + ods.getServerName());
		  System.out.println("User: " + ods.getUser());
		  System.out.println("Driver Type: " + ods.getDriverType());
		  System.out.println("Service Name: " + ods.getServiceName());
		  Connection conn = ods.getConnection();
		
		// Create Oracle DatabaseMetaData object
		  DatabaseMetaData meta = conn.getMetaData();
		// gets driver info:
		  System.out.println("JDBC driver version is " + meta.getDriverVersion());
		  System.out.println("AutoCommit " + conn.getAutoCommit());
		  System.out.println("Catalog " + conn.getCatalog());
		  System.out.println("Isolation " + conn.getTransactionIsolation());
		  System.out.println("Product " +  meta.getDatabaseProductName() + meta.getDatabaseProductVersion());
		  
      Statement stmt = conn.createStatement ();
      ResultSet rset = stmt.executeQuery ("select * from mitglieder");
      ResultSetMetaData rsmd = rset.getMetaData();
      int c = rsmd.getColumnCount();
      for (int i = 1; i <= c; i++) {
      	System.out.print (rsmd.getColumnName(i) + ", ");
      	System.out.print (rsmd.getColumnTypeName(i) + ", ");
      	System.out.println (rsmd.isNullable(i));
      }
      while (rset.next ()) {
        System.out.print (rset.getString(1));
        System.out.print (rset.getString (2));
        System.out.print (rset.getString (3));
        System.out.print (rset.getString (4));
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
