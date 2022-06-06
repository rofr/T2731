package se.informator.t2731.booking;

import java.io.*;
import java.util.*;

public class BookingFileSupport {

	public static void storeTextBookings(List<Booking> bookings, String filename){
				
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename));){
			for(Booking entry: bookings){
				pw.println(entry);
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}	
	}
	
	public static List<Booking> readTextBookings(String filename){
		List<Booking> bookings = new ArrayList<Booking>();

		try(BufferedReader br = new BufferedReader(new FileReader(filename));){

			while(br.ready()){
				Booking entry = new Booking(br.readLine());
				bookings.add(entry);
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		return bookings;
	}
	
	public static void storeBookingObjects(List<Booking> bookings, String filename){
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));){
			oos.writeObject(bookings);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Booking> readBookingObjects(String filename){
		List<Booking> bookings = new ArrayList<Booking>();
		
		try(ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(filename));) {
			bookings = (List<Booking>)ois.readObject();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return bookings;
	}
}
