
package se.informator.t2731.derby;

import java.sql.*;


public class DataBaseReader {

	public static void main(String[] args) {

		Connection conn = null;
		try {
		     conn = DriverManager.getConnection("jdbc:derby:phonedb");
		     Statement stmt = conn.createStatement();
		     
		     ResultSet rs = stmt.executeQuery("SELECT db_counter, db_name, db_address, db_number FROM PhoneBook");
		     while (rs.next()) {
		     	System.out.println(rs.getInt("db_counter") 
		     			+ ", "+rs.getString("db_name") 
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("done");
	}
}
