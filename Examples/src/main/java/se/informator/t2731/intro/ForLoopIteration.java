package se.informator.t2731.intro;

import java.util.Scanner;

public class ForLoopIteration {

	public static void main(String[] args) {

		// an array of values can be initiated by a block of values
		int[] array = {1, 3, 5, 7, 9};
		// looping from index 0 to highest index (number of elements-1)
		for(int i=0; i<array.length; i++){
			System.out.println("Array element index " + i + " value is " + array[i]);
		}
		System.out.println("================================================");
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		
		// an array of values can reserve memory for a fixed number of values
		double[] values = new double[3];
		
		// looping forwards from index 0 to highest index using step +1
		for(int i=0; i<3; i++){
			System.out.print("Enter a double value (use local separator . or ,) ");
			values[i] = keyboard.nextDouble();
		}
		
		// looping backwards from highest index to and including 0 using step -1
		for(int i=2; i>=0; i--){
			System.out.println("values["+i+"]="+values[i]);
		}
		
	}
}
