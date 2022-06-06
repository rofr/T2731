package se.informator.t2731.calculator;

import static org.junit.Assert.*;
import org.junit.*;

import se.informator.t2731.calculator.SimpleCalculator;

public class TestSimpleCalculatorMult{

	private SimpleCalculator calc;
	
	@Before
	public void fixture(){
		calc = new SimpleCalculator();
	}
	
	@Test
	public void testMultPositive() {
		int result = calc.mult(5, 6);
		assertEquals(30, result);
	}
	
	@Test
	public void testMultNegative() {
		int result = calc.mult(-3,-7);
		assertEquals(21, result);
	}
	
	@Test
	public void testMultMixed() {
		int result = calc.mult(-4, 12);
		assertEquals(-48, result);
	}
	
	@Test
	public void testMultByZero() {
		int result = calc.mult(7, 0);
		assertEquals(0, result);
	}	
}
