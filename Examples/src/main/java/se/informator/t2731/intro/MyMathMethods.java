package se.informator.t2731.intro;

import java.util.Scanner;

public class MyMathMethods {

	/**
	 * Utility method for calculating max value out of 3 arguments
	 * @param a holds first number
	 * @param b holds second number
	 * @param c holds third number
	 * @return int holding highest value 
	 */
	public static int maxOf3(int a, int b, int c){
		if(a > b){
			return (a > c)? a: c;
		}
		else{
			return (b > c)? b: c;
		}
	}
	
	/**
	 * Utility method for calculating max value out of 2 arguments
	 * @param a holds first number
	 * @param b holds second number
	 * @return int holding highest value 
	 */
	public static int maxOf2(int a, int b){
		return (a>b)? a: b;
	}
	
	
	public static void main(String[] args) {

		int x, y, z;
		
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter values for x, y and z ");
		x = keyboard.nextInt();
		y = keyboard.nextInt();
		z = keyboard.nextInt();
		
		int test1 = maxOf3(x, y, z);
		System.out.println("Highest value of x, y and z is " + test1);

		int test2 = maxOf2(x, y);
		System.out.println("Highest value of x and y is " + test2);

		int test3 = maxOf2(x, z);
		System.out.println("Highest value of x and z is " + test3);

		int test4 = maxOf2(y, z);
		System.out.println("Highest value of y and z is " + test4);

		int test5 = Math.max(x, y);
		System.out.println("java.lang.Math.max() returns " + test5);
		
	}
}
