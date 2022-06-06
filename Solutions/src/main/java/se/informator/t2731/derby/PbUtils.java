package se.informator.t2731.derby;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PbUtils {

	/*****************
	 ** Asks user to enter a phone book item or 'exit' to exit the loop - returns
	 * the string entered - loop should exit when the string 'exit' is returned
	 ******************/

	private static Scanner sc = new Scanner(System.in);

	public static String[] getPBItem() {
		System.out.println("Enter a phone book item on the form <name>,<address>,<number> (exit to end): ");
		String[] pbEntry = null;

		while (pbEntry == null) {

			String item = sc.nextLine();
			pbEntry = item.split("\\s*,\\s*");
			if (pbEntry.length == 0) {
				System.out.println("Nothing entered...");
			}
		}
		return pbEntry;
	}

	/*** Check for PhoneBook table ****/
	public static boolean pbChk4Table(Connection conTst) throws SQLException {
		try {
			Statement s = conTst.createStatement();
			s.execute("update PhoneBook set ENTRY_DATE = CURRENT_TIMESTAMP, db_name = 'TEST ENTRY' where 1=3");
		} catch (SQLException sqle) {
			String theError = (sqle).getSQLState();
			// System.out.println("  Utils GOT:  " + theError);
			/** If table exists will get - WARNING 02000: No row was found **/
			if (theError.equals("42X05")) // Table does not exist
			{
				return false;
			} else if (theError.equals("42X14") || theError.equals("42821")) {
				System.out.println("WwdChk4Table: Incorrect table definition. Drop table WISH_LIST and rerun this program");
				throw sqle;
			} else {
				System.out.println("WwdChk4Table: Unhandled SQLException");
				throw sqle;
			}
		}
		// System.out.println("Just got the warning - table exists OK ");
		return true;
	}

	public static void loadDatabaseDriver(){
		// define the driver to use 
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";

		//   Beginning of JDBC code sections   
		//   ## LOAD DRIVER SECTION ##
		try	        {
			/*
			 **  Load the Derby driver. 
			 **  When the embedded Driver is used this action start the Derby engine.
			 **  Catch an error and suggest a CLASSPATH problem
			 */
			Class.forName(driver); 
			System.out.println(driver + " loaded. ");
		} catch(java.lang.ClassNotFoundException e)     {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
			System.out.println("\n    >>> Please check your CLASSPATH variable   <<<\n");
		}
	}

}