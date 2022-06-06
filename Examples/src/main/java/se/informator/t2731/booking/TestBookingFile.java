package se.informator.t2731.booking;

import se.informator.t2731.person.*;

public class TestBookingFile {

	public static void main(String args[]){
		
		// Initialize the TicketOffice
		TicketOffice testOffice = new TicketOffice();
		
		// Create some Customers
		Customer c1 = new Customer("N Nyfiken", "nicke.nyfiken@yahoo.com");
		Customer c2 = new Customer("E Teknolog", "emil.teknolog@chalmers.org");
		Customer c3 = new Customer("G Hackman", "gene.hackman@spyware.com");
		
		// Simulate book operation for available Customers
		int bno1 = testOffice.book(701, c1.getName());
		int bno2 = testOffice.book(702, c2.getName());		
		int bno3 = testOffice.book(701, c3.getName());
		int bno4 = testOffice.book(702, c1.getName());
		int bno5 = testOffice.book(702, c3.getName());		
		
		// Cancel a previous Booking
		boolean cancelOk = testOffice.cancel(bno2);
		if(cancelOk == true){
			System.out.println("Booking " + bno2 +" cancelled!");
		}
		
		// Print out all Bookings held by the BookingOffice 
		testOffice.printAllBookings();
		
		/*
		System.out.println("----------------------------------------------------");		
		System.out.println("Storing bookings in file AllBookings.txt");
		testOffice.storeAsText("AllBookings.txt");
		
		System.out.println("Reading bookings from file AllBookings.txt");
		testOffice.readAsText("AllBookings.txt");
		testOffice.printAllBookings();
		
		System.out.println("----------------------------------------------------");	
		System.out.println("Storing bookings in file AllBookings.ser");
		testOffice.storeAsObjects("AllBookings.ser");
		
		System.out.println("Reading bookings from file AllBookings.ser");
		testOffice.readAsObjects("AllBookings.ser");
		testOffice.printAllBookings();
		*/
	}
}
