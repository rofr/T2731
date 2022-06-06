
package se.informator.t2731.db;

import java.sql.*;

public class DataBaseUpdater {

	public static void main(String[] args) {
	    
		String sql = "UPDATE PhoneBook SET db_address = ? WHERE db_name = ?";
	    
		Connection conn = null;
		try {
		     conn = DriverManager.getConnection("jdbc:derby:phonedb");
			 System.out.println("db connection established!");
		     
		     PreparedStatement pstmt = conn.prepareStatement(sql);
		     pstmt.setString(1, "Krutvägen 11");
		     pstmt.setString(2, "Emma");
		     
		     int n = pstmt.executeUpdate();
		     if(n == 1){
		    	 System.out.println("Update performed!");
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
