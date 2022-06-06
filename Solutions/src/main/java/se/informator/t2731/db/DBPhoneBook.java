package se.informator.t2731.db;

import java.util.Set;
import java.util.HashSet;
import java.sql.*;

public class DBPhoneBook implements PhoneBook {

    protected Connection conn;

    public DBPhoneBook(String dbName) {     	
    	try {
    		conn = DriverManager.getConnection("jdbc:derby:" + dbName);      
    		System.out.println("db connection established!");
    	}
    	catch(SQLException sqle){
    		sqle.printStackTrace();
    	}
    }

    @Override
    public String findNumber(String name) {
    	
    	String sqlString = "SELECT db_number FROM PhoneBook WHERE db_name = '" + name + "'";
        String number = "";

        try {
        	Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlString);
            if (rs.next()) {
                number = rs.getString(1);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException("Unexpected database error: "+ e.toString());
        }
        return number;
    }

    @Override
    public void addNameAndNumber(String name, String number) {

    	String sqlString = "INSERT INTO PhoneBook (db_name, db_number) VALUES (?, ?)";
    	
    	if(findNumber(name).isEmpty()){
    		try {
    			PreparedStatement pstmt = conn.prepareStatement(sqlString);
    			pstmt.setString(1, name);
    			pstmt.setString(2, number);
    			pstmt.executeUpdate();
    		}
    		catch (SQLException e) {
    			throw new RuntimeException("Unexpected database error: "+ e.toString());
    		}

    	}
    	else{
    		System.out.println(name+" exists in db!");
    	}
    }
    
    @Override
    public Set<String> getAllNames() {
        Set<String> names = new HashSet<String>();

        try {
        	Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT db_name FROM PhoneBook");
            while (rs.next()) {
            	names.add(rs.getString("db_name"));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Unexpected database error: "+ e.toString());
        }
        
        return names;
    }

    @Override
    public void shutDown(){
    	try {
    		if(conn != null){
    			conn.close();
    			System.out.println("db connection closed down!");
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}	
    }
    
}
