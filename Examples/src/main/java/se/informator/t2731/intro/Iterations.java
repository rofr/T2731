package se.informator.t2731.intro;

import java.util.Scanner;

public class Iterations {

	public static void main(String[] args) {
	
		int x;
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		// do-while block will be run at least one time
		do{			
			System.out.print("Enter a positive value for x > 0 ");
			x = keyboard.nextInt();			
		}while(x<=0);

		// while block may not be run at all
		while(x%2 != 0){
			int y = x%2;
			System.out.print("Odd value is " + y);
			x = x/2;
			System.out.println(" x is now "+x);
		}
		
		System.out.println("Final value for x is even " + x);
	}
	
}
