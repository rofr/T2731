package se.informator.t2731.booking;

/**
 * This class holds full info of a Booking of some kind of event
 * Objects of this type cannot be changed, since there are no methods
 * that can set individual values. 
 * This class is considered to be a value class
 */
public final class Booking implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private final int eventNo;
	private final String id;
	private final int bookingNo;
	
	/**
	 * Constructor
	 * @param eventId holding a unique event identification
	 * @param who holding id for the one who owns the Booking
	 * @param no holding a unique number for this Booking
	 */
	public Booking(int eventId, String who, int no){
		eventNo = eventId;
		id = who;
		bookingNo = no;
	}
	
	/**
	 * Constructor
	 * @param input holding a full entry to be parsed
	 */
	public Booking(String input) {
		String info = input.substring(input.indexOf(":") + 1);
		String[] parts = info.split(",");
		eventNo = Integer.parseInt(parts[0].trim());
		id = parts[1].trim();
		bookingNo = Integer.parseInt(parts[2].trim());
	}
	
	/**
	 * Getter of attribute eventNo
	 * @return eventNo an int holding Booking event
	 */
	public int getEventNo(){
		return eventNo;
	}
	
	/**
	 * Getter of attribute id
	 * @return id a String holding owner of Booking
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * Getter of attribute bookingNo
	 * @return bookingNo an int holding a unique number for this Booking
	 */
	public int getBookingNo(){
		return bookingNo;
	}
	
	/**
	 * Converting this object to human readable format
	 * @return a String holding full object state
	 * Output format "Booking: <eventNo>, <id>, <bookingNo>"
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Booking: ");
		sb.append(eventNo);
		sb.append(", ");		
		sb.append(id);
		sb.append(", ");
		sb.append(bookingNo);
		
		return sb.toString();
	}
}
