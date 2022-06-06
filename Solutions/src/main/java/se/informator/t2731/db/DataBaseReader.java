
package se.informator.t2731.db;

import java.sql.*;

public class DataBaseReader {

	public static void main(String[] args) {
		
	    String sql = "SELECT db_name, db_address, db_number FROM PhoneBook";
		
	    Connection conn = null;
		try {
		     conn = DriverManager.getConnection("jdbc:derby:phonedb");
			 System.out.println("db connection established!");
				
		     Statement stmt = conn.createStatement();

		     ResultSet rs = stmt.executeQuery(sql);
		     while (rs.next()) {
		     	System.out.println(rs.getString("db_name") 
		     			+ ", " + rs.getString("db_address") 
		     			+ ", " + rs.getString("db_number"));
		     }
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally {
			try {
				conn.close();
				System.out.println("db closed down!");				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
