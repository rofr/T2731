package se.informator.t2731.booking;

import se.informator.t2731.person.*;


public class TestMappedTicketOffice {
	
	@SuppressWarnings("unused")
	public static void main(String args[]){
		
		MappedTicketOffice testOffice = new MappedTicketOffice();
		
		Customer c1 = new Customer("N Nyfiken", "nicke.nyfiken@yahoo.com");
		Customer c2 = new Customer("E Teknolog", "emil.teknolog@chalmers.org");
		Customer c3 = new Customer("G Hackman", "gene.hackman@spyware.com");
		Customer c4 = new Customer("M Mystisk", "maja.m.mystisk@telia.com");
		Customer c5 = new Customer("J Gosling", "duke@java.sun.com");
		
		int bno1 = testOffice.book(701, c1.getName());
		int bno2 = testOffice.book(702, c2.getName());		
		int bno3 = testOffice.book(701, c3.getName());
		int bno4 = testOffice.book(702, c1.getName());
		int bno5 = testOffice.book(703, c1.getName());
		int bno6 = testOffice.book(702, c4.getName());
		int bno7 = testOffice.book(703, c5.getName());		
		int bno8 = testOffice.book(701, c5.getName());
		int bno9 = testOffice.book(701, c4.getName());		
		
		testOffice.cancel(bno2);
		testOffice.cancel(bno6);
		
		testOffice.printBookings();
		
		System.out.println("=============================================");	
		
		testOffice.printBookingsById(c1.getName());
		
	}
}


