package se.informator.t2731.intro;

import java.util.Scanner;

public class Echo {

	public static void main(String[] args) {
		
		// set up a Scanner for keyboard input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in); 
		keyboard.useDelimiter(System.getProperty("line.separator"));

		// read user input from keyboard
		System.out.print("Enter text: ");
		String in=keyboard.next(); 
		
		// echo to console
		System.out.println("Echo: "+in);
	}
}