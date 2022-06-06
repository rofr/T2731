package se.informator.t2731.booking;

public interface TicketService {
	
	/**
	 * This method is used when someone wants to make a booking 
	 * @param event an int holding id of booking event 
	 * @param who a String holding id of the booker 
	 * @return an int holding a unique booking number 
	 */
	int book(int event, String who);
	
	/**
	 * This method will cancel a previously made booking
	 * @param bookingNo a unique number that identifies a Booking object
	 * @return a boolean representing the outcome of the operation, true=successful
	 */
	boolean cancel(int bookingNo);
	
	/**
	 * This is a pure service method 
	 * @return an int holding current number of registered Booking objects
	 */
	int getNumberOfBookings();
}
