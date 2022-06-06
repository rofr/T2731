package se.informator.t2731.booking;

import se.informator.t2731.person.*;

public class TestTicketOffice {

	public static void main(String args[]){
		
		// Initialize the TicketOffice
		TicketOffice testOffice = new TicketOffice();
		
		Customer c1 = new Customer("N Nyfiken", "nicke.nyfiken@yahoo.com");
		Customer c2 = new Customer("E Teknolog", "emil.teknolog@chalmers.org");
		Customer c3 = new Customer("G Hackman", "gene.hackman@spyware.com");
		
		// perform some book operations
		int bno1 = testOffice.book(701, c1.getName());
		int bno2 = testOffice.book(702, c2.getName());		
		int bno3 = testOffice.book(701, c3.getName());
		int bno4 = testOffice.book(702, c1.getName());
		int bno5 = testOffice.book(702, c3.getName());		
		
		// present all current Booking objects
		testOffice.printAllBookings();
		
		// Cancel a previous Booking
		boolean cancelOk = testOffice.cancel(bno2);
		if(cancelOk == true){
			System.out.println("Booking " + bno2 +" cancelled!");
		}
		// Try to cancel a non-existing Booking
		cancelOk = testOffice.cancel(12345);
		if(cancelOk){
			System.out.println("Booking cancelled!");
		}
		else{
			System.out.println("Booking 12345 NOT cancelled!");
		}
		
		// present all current Booking objects
		testOffice.printAllBookings();
		
		System.out.println("--------------------------------------------");
		
		// present all Booking objects by one Customer
	//	testOffice.printBookingsById(c1.getName());
	}
}
