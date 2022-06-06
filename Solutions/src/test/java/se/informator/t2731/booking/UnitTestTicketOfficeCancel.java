package se.informator.t2731.booking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.informator.t2731.person.Customer;

public class UnitTestTicketOfficeCancel {

	private TicketService theOffice;
	private Customer c1;
	private Customer c2;
	
	@Before
	public void setUp() throws Exception {
		theOffice = new TicketOffice();
		c1 = new Customer("N Nyfiken", "nicke.nyfiken@yahoo.com");
		c2 = new Customer("E Teknolog", "emil.teknolog@chalmers.org");
	}

	@After
	public void tearDown() throws Exception {
		theOffice = null;
	}


	@Test
	public void testCancelExistingBooking() {
		int bno1 = theOffice.book(701, c1.getName());
		theOffice.book(702, c2.getName());	
		boolean ok = theOffice.cancel(bno1);
		assertTrue(ok);		
		assertTrue(theOffice.getNumberOfBookings() == 1);
	}

	@Test
	public void testCancelNonexistingBooking() {
		theOffice.book(701, c1.getName());
		theOffice.book(702, c2.getName());		
		boolean ok = theOffice.cancel(999);
		assertFalse(ok);	
		assertTrue(theOffice.getNumberOfBookings() == 2);
	}

	@Test
	public void testCancelSameBooking() {
		int bno1 = theOffice.book(701, c1.getName());
		theOffice.book(702, c2.getName());			
		boolean ok = theOffice.cancel(bno1);
		ok = theOffice.cancel(bno1);
		assertFalse(ok);	
		assertTrue(theOffice.getNumberOfBookings() == 1);
	}
	
}
