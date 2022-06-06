package se.informator.t2731.booking;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
	{
		UnitTestBooking.class,	
		UnitTestTicketOfficeBook.class,
		UnitTestTicketOfficeCancel.class		
	}
)
public class AllTests {;}
