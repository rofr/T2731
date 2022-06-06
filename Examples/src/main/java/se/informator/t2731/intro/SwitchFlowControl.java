package se.informator.t2731.intro;

import java.util.Scanner;

public class SwitchFlowControl {


	public static void main(String[] args) {

		int choice;
		System.out.println("Favourite wild animal");
		System.out.println("1 - Lion");
		System.out.println("2 - Cobra");
		System.out.println("3 - Rhino");

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your choice (1, 2 or 3) ");
		choice = keyboard.nextInt();
		
		// compare variable value to a number of predefined constants
		switch(choice){	
		case 1:	// constant
			System.out.println("Choice: Lion");
			break; // jump to end of switch scope
		case 2:
			System.out.println("Choice: Cobra");
			break;
		case 3:
			System.out.println("Choice: Rhino");
			break;
		default: // if no case match expression
			System.out.println("Choice: some other animal");
		}

	}

}
