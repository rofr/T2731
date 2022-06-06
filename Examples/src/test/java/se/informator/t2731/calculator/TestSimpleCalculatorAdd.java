package se.informator.t2731.calculator;

import static org.junit.Assert.*;
import org.junit.*;

public class TestSimpleCalculatorAdd{

	private SimpleCalculator calc;
	
	@Before
	public void fixture(){
		calc = new SimpleCalculator();
	}
	
	@Test
	public void testAddPositive() {
		int result = calc.add(2, 2);
		assertEquals(4, result);
	}
	
	@Test	
	public void testAddNegative() {
		int result = calc.add(-3,-7);
		assertEquals(-10, result);
	}
	
	@Test
	public void testAddMixed() {
		int result = calc.add(-4, 12);
		assertEquals(8, result);
	}
	
}
