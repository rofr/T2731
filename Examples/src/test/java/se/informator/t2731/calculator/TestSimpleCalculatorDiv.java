package se.informator.t2731.calculator;

import static org.junit.Assert.*;
import org.junit.*;

import se.informator.t2731.calculator.SimpleCalculator;

public class TestSimpleCalculatorDiv {

	private SimpleCalculator calc;
	
	@Before
	public void fixture(){
		calc = new SimpleCalculator();
	}
	
	@Test
	public void testDivPositive() {
		double result = calc.div(15, 2);
		assertEquals(7.5, result, 0.001);
	}
	
	@Test
	public void testDivNegative() {
		double result = calc.div(-10,-3);
		assertEquals(3.333, result, 0.001);
	}
	
	@Test
	public void testDivMixed() {
		double result = calc.div(-12, 4);
		assertEquals(-3.0, result, 0.1);
	}
	
	@Test (expected = ArithmeticException.class) 
	public void testDivByZero() {
			calc.div(15, 0);
			fail("Divide by zero");
	}
}
