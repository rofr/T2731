package se.informator.t2731.game;

import java.util.Scanner;

public class MiniNumberGame {
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		int max = 20;
		int	secretNumber = (int)(Math.random()*max)+1;
		
		Scanner keyboard = new Scanner(System.in);
		int guess=0;
    	int[] guessList = new int[10];
    	int count=0;
    	
    	do{    		
    		System.out.print("Enter a number: ");
    		guess = keyboard.nextInt();
    		guessList[count] = guess;
    		count++;
    		
        	if(guess == secretNumber){
        		System.out.println("Correct!");  		
        	}
        	else{
        		if(guess < secretNumber){
        			System.out.println("Too low!");
        		}
        		else{
        			System.out.println("Too high!");
        		}
        		System.out.print("Used numbers: ");
        		for(int i=0; i<count; i++){
        			System.out.print(guessList[i]+" ");
        		}
        		System.out.println("");
        	}
    	}while(guess != secretNumber && count < 10);
    	
    	if(guess != secretNumber){
    		System.out.println("Sorry, no more tries, correct number was "+secretNumber);
    	}
	}
}
