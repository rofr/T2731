package se.informator.t2731.intro;

import java.util.Scanner;

public class Operators {

	public static void main(String[] args) {
		
		int min=1, max=100;
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter value for x ");
		int x = keyboard.nextInt();

		// logical operator && (AND) requires both parts to be true
		if(x>min && x<max){
			System.out.println("x within range");
		}
		else{
			// comparison operator <= (less or equal)
			if(x<=min){
				System.out.println("x too small");
			}
			// comparison operator >= (greater or equal)
			if(x>=max){
				System.out.println("x too big");
			}
		}

		System.out.print("Enter value for y ");
		int y = keyboard.nextInt();
		// logical operator || (OR) requires that one of the parts are true
		if(y<=min || y>=max){
			System.out.println("y out of range");
		}
		else{
			// comparison operator == (EQUAL)
			if(x == y){
				System.out.println("x and y are equal");
			}
			else{
				System.out.println("x and y are not equal");
			}
		}
	}
}
