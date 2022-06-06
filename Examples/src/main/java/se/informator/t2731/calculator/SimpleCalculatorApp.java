package se.informator.t2731.calculator;

/**
 * This is an example of "Happy Testing"
 * A limited number of random calls are performed
 * No flaws will be exposed, but will appear later...
 */
public class SimpleCalculatorApp {
	
	public static void main(String[] args){
		
		SimpleCalculator sc = new SimpleCalculator();
		int sum = sc.add(12, 23);
		System.out.println("Sum of 12 and 23 is " + sum);
		
		sum = sc.add(sum, 46);
		System.out.println("Adding 46 to sum producing a total of " + sum);
		
		double mean = sc.div(sum, 3);
		System.out.println("Mean value of numbers are " + mean);
		
	}
}
