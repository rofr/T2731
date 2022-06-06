package se.informator.t2731.intro;

import java.util.Scanner;

public class SwitchStringFlowControl {


	public static void main(String[] args) {

		String choice;
		System.out.println("Favourite wild animal");
		System.out.println("Lion, Cobra or Rhino");

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your choice: ");
		choice = keyboard.next();
		
		// compare variable value to a number of predefined constants
		switch(choice){	
		case "Lion":	// constant
			System.out.println("Choice: Lion");
			break; // jump to end of switch scope
		case "Cobra":
			System.out.println("Choice: Cobra");
			break;
		case "Rhino":
			System.out.println("Choice: Rhino");
			break;
		default: // if no case match expression
			System.out.println("Choice: some other animal");
		}

	}

}
