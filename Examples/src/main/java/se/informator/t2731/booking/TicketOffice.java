package se.informator.t2731.booking;

import java.util.*;

public class TicketOffice implements TicketService {

	/**
	 * Common attribute for all objects of type TicketOffice
	 * This attribute will hold the next available number 
	 * that will be associated with a new Booking
	 */
	private static int uniqueNo = 10001;

	// TODO Add collection attribute here

	/**
	 * Constructor creating the concrete collection object
	 */
	public TicketOffice(){
		// TODO Add code here
	}
	
	/**
	 * Internal routine that produces a unique number
	 * @return int holding next available booking number
	 */
	private int getUniqueNo(){
		return uniqueNo++;
	}

	/**
	 * See interface for documentation details
	 */
	@Override
	public int book(int event, String who) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * See interface for documentation details
	 */
	@Override
	public boolean cancel(int bookingNo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Support method printing out all current Bookings to console
	 */
	public void printAllBookings(){
		// TODO Add code here
	}

	@Override
	public int getNumberOfBookings() {
		// TODO Auto-generated method stub
		return 0;
	}
		
}