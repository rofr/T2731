package se.informator.t2731.calculator;

import static org.junit.Assert.*;
import org.junit.*;

import se.informator.t2731.calculator.SimpleCalculator;

public class TestSimpleCalculatorSub {

	private SimpleCalculator calc;
	
	@Before
	public void fixture(){
		calc = new SimpleCalculator();
	}
	
	@Test
	public void testSubPositive() {
		int result = calc.sub(23, 7);
		assertEquals(16, result);
	}
	
	@Test
	public void testSubNegative() {
		int result = calc.sub(-3,-7);
		assertEquals(-10, result);
	}
	
	@Test
	public void testSubMixed() {
		int result = calc.sub(-4, 12);
		assertEquals(-16, result);
	}
	
}
