package se.informator.t2731.intro;

public class AverageCalculation {

	private int sum;
	private int observations;
	
	public AverageCalculation(int s, int n){
		sum = s;
		observations = n;
	}
	
	public double calcAverage() throws ArithmeticException {
		if(observations <= 0){
			throw new ArithmeticException();
		}		
		return (double)sum/observations;
	}
	
	public static void main(String[] args){
		try{
			int s = Integer.parseInt(args[0]);
			int n = Integer.parseInt(args[1]);
			AverageCalculation ac = new AverageCalculation(s, n);
			double avg = ac.calcAverage();
			System.out.println("Average: " + avg);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndex " + e.getMessage() + " missing!");
		}
		catch(ArithmeticException e){
			System.out.println("Average calculation caused an exception " + e);
		}
	}
}
