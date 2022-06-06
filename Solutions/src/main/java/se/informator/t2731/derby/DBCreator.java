//   ## INITIALIZATION SECTION ##
//  Include the java SQL classes 
package se.informator.t2731.derby;
import java.sql.*;

public class DBCreator{
	
    public static void main(String[] args){
   //   ## DEFINE VARIABLES SECTION ##
   // define the driver to use 
      String driver = "org.apache.derby.jdbc.EmbeddedDriver";
   // the database name  
      String dbName="phonedb";
   // the table name
      String dbTableName = "PhoneBook";
   // define the Derby connection URL to use 
      String connectionURL = "jdbc:derby:" + dbName + ";create=true";

      Connection conn = null;
      Statement s;
      PreparedStatement psInsert;
      ResultSet myPhoneBook;
      String printLine = "  __________________________________________________";
      
    String createString = "CREATE TABLE " + dbTableName
    +  "(db_counter INT NOT NULL GENERATED ALWAYS AS IDENTITY " 
    +  "   CONSTRAINT WISH_PK PRIMARY KEY, " 
    +  " ENTRY_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
    +  " db_name VARCHAR(255) NOT NULL," 
    +  " db_address VARCHAR(255)," 
    +  " db_number VARCHAR(32) NOT NULL" 
    +		") " ;

      String[] answer;
 
      PbUtils.loadDatabaseDriver();
    
      
      //  Beginning of Primary DB access section
      //   ## BOOT DATABASE SECTION ##
      try {
    	  // Create (if needed) and connect to the database
    	  conn = DriverManager.getConnection(connectionURL);		 
    	  System.out.println("Connected to database " + dbName);

    	  //   ## INITIAL SQL SECTION ## 
    	  //   Create a statement to issue simple commands.  
    	  s = conn.createStatement();
    	  // Call utility method to check if table exists.
    	  //      Create the table if needed
    	  if (! PbUtils.pbChk4Table(conn))
    	  {  
    		  System.out.println (" . . . . creating table PhoneBook");
    		  s.execute(createString);
    	  }
    	  //  Prepare the insert statement to use 
    	  psInsert = conn.prepareStatement("insert into PhoneBook(db_name, db_address, db_number) values (?, ?, ?)");

    	  //   ## ADD / DISPLAY RECORD SECTION ## 
    	  //  The Add-Record Loop - continues until 'exit' is entered 
    	  do {
    		  // Call utility method to ask user for input 
    		  answer = PbUtils.getPBItem();
    		  // Check if it is time to EXIT, if not insert the data   
    		  if (! answer[0].equals("exit"))
    		  {
    			  //Insert the text entered into the PhoneBook table
    			  psInsert.setString(1,answer[0]);
    			  psInsert.setString(2,answer[1]);
       			  psInsert.setString(3,answer[2]);
    			  psInsert.executeUpdate();  

    			  //   Select all records in the WISH_LIST table
   			  myPhoneBook = s.executeQuery("select ENTRY_DATE, db_name, db_address, db_number from PhoneBook order by ENTRY_DATE");
       			  
    			  //  Loop through the ResultSet and print the data 
    			  System.out.println(printLine);
    			  while (myPhoneBook.next())
    			  {
    				  System.out.println("On " + myPhoneBook.getTimestamp(1)
    						  + " Phone book entry for  " + myPhoneBook.getString(2) 
    						  + " has address " + myPhoneBook.getString(3)
    						  + " has number " + myPhoneBook.getString(4));
    			  }
    			  System.out.println(printLine);
    			  //  Close the resultSet 
    			  myPhoneBook.close();
    		  }       //  END of IF block   
    		  // Check if it is time to EXIT, if so end the loop  
    	  } while (! answer[0].equals("exit")) ;  // End of do-while loop 

    	  // Release the resources (clean up )
    	  psInsert.close();
    	  s.close();
    	  conn.close();						
    	  System.out.println("Closed connection");

    	  //   ## DATABASE SHUTDOWN SECTION ## 
    	  /*** In embedded mode, an application should shut down Derby.
               Shutdown throws the XJ015 exception to confirm success. ***/			
    	  if (driver.equals("org.apache.derby.jdbc.EmbeddedDriver")) {
    		  boolean gotSQLExc = false;
    		  try {
    			  DriverManager.getConnection("jdbc:derby:;shutdown=true");
    		  } catch (SQLException se)  {	
    			  if ( se.getSQLState().equals("XJ015") ) {		
    				  gotSQLExc = true;
    			  }
    		  }
    		  if (!gotSQLExc) {
    			  System.out.println("Database did not shut down normally");
    		  }  else  {
    			  System.out.println("Database shut down normally");	
    		  }  
    	  }

    	  //  Beginning of the primary catch block: uses errorPrint method
      }  catch (Throwable e)  {   
            /*       Catch all exceptions and pass them to 
            **       the exception reporting method             */
            System.out.println(" . . . exception thrown:");
            errorPrint(e);
         }
         System.out.println("Derby Phone book program ending.");
      }
     //   ## DERBY EXCEPTION REPORTING CLASSES  ## 
    /***     Exception reporting methods
    **      with special handling of SQLExceptions
    ***/
      static void errorPrint(Throwable e) {
         if (e instanceof SQLException) 
            SQLExceptionPrint((SQLException)e);
         else {
            System.out.println("A non SQL error occured.");
            e.printStackTrace();
         }   
      }  // END errorPrint 

    //  Iterates through a stack of SQLExceptions 
      static void SQLExceptionPrint(SQLException sqle) {
         while (sqle != null) {
            System.out.println("\n---SQLException Caught---\n");
            System.out.println("SQLState:   " + (sqle).getSQLState());
            System.out.println("Severity: " + (sqle).getErrorCode());
            System.out.println("Message:  " + (sqle).getMessage()); 
            sqle.printStackTrace();  
            sqle = sqle.getNextException();
         }
   }  //  END SQLExceptionPrint   	
}
