package se.informator.t2731.booking;

import java.util.*;

public class MappedTicketOffice implements TicketService{
	
	private static int uniqueNo = 10001;
	
	Map<Integer, Booking> bookingMap;
	
	public MappedTicketOffice(){
		bookingMap = new TreeMap<Integer, Booking>();
	}
	
	private int getUniqueBookingNo(){
		return uniqueNo++;
	}
	
	public int book(int event, String who){
		int bookingNo = getUniqueBookingNo(); 
		Booking b = new Booking(event, who, bookingNo);
		// autoboxing
		bookingMap.put(bookingNo, b);
		
		return bookingNo;
	}
	
	public boolean cancel(int bookingNo){
		boolean found = false;
		
		Set<Integer> keySet = bookingMap.keySet();
		
		// autoboxing			
		if(keySet.contains(bookingNo)){
			// autoboxing
			Booking temp = bookingMap.get(bookingNo);
			found = true;
			// autoboxing			
			bookingMap.remove(temp.getBookingNo());
		}
				
		return found;
	}
	
	public void printBookings(){
		
		Set<Integer> keys = bookingMap.keySet();
		
		for(Integer key : keys){
			Booking temp = bookingMap.get(key);
			System.out.println(temp);			
		}
	}
	
	public void printBookingsById(String who){
		
		for(Booking temp: bookingMap.values()){
			if(temp.getId().equals(who)){
				System.out.println(temp.toString());				
			}
		}
	}

	@Override
	public int getNumberOfBookings() {
		return bookingMap.size();
	}
		
}

