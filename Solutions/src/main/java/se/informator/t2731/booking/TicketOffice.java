package se.informator.t2731.booking;

import java.util.*;

public class TicketOffice implements TicketService{

	private static int uniqueNo = 10001;
	
	List<Booking> bookingList;
	
	public TicketOffice(){
		bookingList = new ArrayList<Booking>();
	}
	
	private int getUniqueBookingNo(){
		return uniqueNo++;
	}
	
	@Override
	public int book(int event, String who){
		int bookingNo = getUniqueBookingNo(); 
		Booking b = new Booking(event, who, bookingNo);
		bookingList.add(b);
		
		return bookingNo;
	}
	
	@Override
	public boolean cancel(int bookingNo){
		boolean found = false;
		
		Iterator<Booking> iter = bookingList.iterator();
		while(iter.hasNext() && !found){
			Booking temp = iter.next();
			if(temp.getBookingNo() == bookingNo){
				found = true;
				// bookings.remove(temp);
				iter.remove();
			}
		}
		
		return found;
	}


	@Override
	public int getNumberOfBookings() {
		return bookingList.size();
	}	
	
	public void printBookings(){	
		for(Booking  temp : bookingList){
			System.out.println(temp);
		}
	}
	
	public void printBookingsById(String who){
		for(int i=0; i<bookingList.size(); i++){
			Booking temp = bookingList.get(i);
			if(temp.getId().equals(who)){
				System.out.println(temp);
			}
		}		
	}
	
	public void storeAsText(String filename){
		BookingFileSupport.storeTextBookings(bookingList, filename);
	}
	
	public void readAsText(String filename){
		bookingList = BookingFileSupport.readTextBookings(filename);
	}	
	
	public void storeAsObjects(String filename){
		BookingFileSupport.storeBookingObjects(bookingList, filename);	
	}
	
	public void readAsObjects(String filename){
		bookingList = BookingFileSupport.readBookingObjects(filename);
	}
	
}