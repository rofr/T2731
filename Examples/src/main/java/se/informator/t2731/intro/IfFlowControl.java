package se.informator.t2731.intro;

import java.util.Scanner;

public class IfFlowControl {

	public static void main(String[] args) {

		int x, y, z;
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter values for x, y and z ");
		x = keyboard.nextInt();
		y = keyboard.nextInt();
		z = keyboard.nextInt();
		
		// enter body if condition is true
		if(x > y){
			// nested if/else
			if(x > z){
				System.out.println("x holds highest value: " + x);
			}
			else{
				System.out.println("z holds highest value: " + z);				
			}
		}
		// enter else if previous if condition is false
		else{
			// short-hand if/else
			int temp = (y>z)? y: z;
			System.out.println("Highest value held by " + temp);
		}

	}

}
