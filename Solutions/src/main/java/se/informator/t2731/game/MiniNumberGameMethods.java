package se.informator.t2731.game;

import java.util.Scanner;

public class MiniNumberGameMethods {
	
	public static int input(int max){

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		boolean ok;
		int guess; 
		do{   
			ok = true;
			System.out.print("Enter a number: ");
			guess = keyboard.nextInt();
			if(guess <= 0 || guess > max){
				System.out.println("*** Input out of range! ***");
				ok = false;
			}
		}while(!ok);
		return guess;
	}
	
	public static boolean evaluation(int guess, int secretNumber){
		
		boolean status;
		
		if(guess == secretNumber){
    		System.out.println("Correct!");
    		status = true;
    	}
    	else{
    		if(guess < secretNumber){
       			System.out.println("Too low!");
    		}
    		else{
       			System.out.println("Too high!");
    		}
	   		status = false;
    	}
		
		return status;
	}
	
	private static void printGuessList(int[] guessList, int count) {

		System.out.print("Used numbers: ");
		for(int i=0; i<count; i++){
			System.out.print(guessList[i]+" ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		
		int max = 20;
		int	secretNumber = (int)(Math.random()*max)+1;		

		int guess=0;
    	int[] guessList = new int[10];
    	int count=0;
    	boolean status;
    	
    	do{    		
    		// call input routine
    		guess = input(max);
    		
    		// store new guess in int-array
    		guessList[count++] = guess;
    		
    		// call evaluation routine
    		status = evaluation(guess, secretNumber);

    		// conditionally call print of previous guesses
    		if(status == false){
    			printGuessList(guessList, count);
        	}
    	}while(status == false && count < 10);
    	
    	if(status == false){
    		System.out.println("Sorry, no more tries, correct number "+secretNumber);
    	}
	}

}
