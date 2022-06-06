package se.informator.t2731.intro;

import java.util.Scanner;

public class SwitchEnumFlowControl {

	public enum Size {SMALL, MEDIUM, LARGE}

	public static void main(String[] args) {

		Size value;
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your length in cm ");
		int length = keyboard.nextInt();
		
		if(length < 160){
			value = Size.SMALL;
		}
		else{
			value = (length>180)? Size.LARGE: Size.MEDIUM;
		}
		
		// compare variable value to a number of predefined constants
		switch(value){	
		case SMALL:	// constant
			System.out.println("You find " + value.toString() + " marked as XXS, XS or S");
			break; // jump to end of switch scope
		case MEDIUM:
			System.out.println("You find " + value.toString() + " marked as M");
			break;
		case LARGE:
			System.out.println("You find " + value.toString() + " marked as L, XL or XXL");
			break;
		}
	}

}
