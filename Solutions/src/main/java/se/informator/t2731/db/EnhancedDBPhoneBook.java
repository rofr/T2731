package se.informator.t2731.db;

import java.sql.*;

public class EnhancedDBPhoneBook extends DBPhoneBook implements EnhancedPhoneBook {
    
    public EnhancedDBPhoneBook() {
        this("phonedb"); 
    }
    
    public EnhancedDBPhoneBook(String dbName) {
    	super(dbName);
    }
    
    @Override
    public void updateEntry(String name, String number){
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("UPDATE PhoneBook SET db_number = ? WHERE db_name = ?");
            pstmt.setString(1, number);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException("Unexpected database error: "+ e.toString());
        }
        finally {
            try {
            	if(pstmt != null){
            		pstmt.close();
            	}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }    	   	
    }
    
    @Override
    public void removeEntry(String name){
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM PhoneBook WHERE db_name ='"+name+"'");
        }
        catch (SQLException e) {
            throw new RuntimeException("Unexpected database error: "+ e.toString());
        }
        finally {
            try {
            	if(stmt != null){
            		stmt.close();
            	}
            } catch (SQLException e) {
                e.printStackTrace();
            }           
        }    	
    }
    

    public void addFullEntry(String name, String address, String number){

        	String sqlString = "INSERT INTO PhoneBook (db_name, db_address, db_number) VALUES (?, ?, ?)";
        	
        	if(findNumber(name).isEmpty()){
        		PreparedStatement pstmt = null;
        		try {
        			pstmt = conn.prepareStatement(sqlString);
        			pstmt.setString(1, name);
        			pstmt.setString(2, address);
        			pstmt.setString(3, number);
        	
        			pstmt.executeUpdate();
        		}
        		catch (SQLException e) {
        			throw new RuntimeException("Unexpected database error: "+ e.toString());
        		}
        		finally {
        			try {
        				if(pstmt != null){
        					pstmt.close();
        				}
        			} catch (SQLException e) {
        				e.printStackTrace();
        			}
        		}
        	}
        	else{
        		System.out.println(name+" exists in db!");
        	}
        }
         	
}
