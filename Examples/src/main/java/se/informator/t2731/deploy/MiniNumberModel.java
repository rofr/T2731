package se.informator.t2731.deploy;

import java.util.Scanner;

public class MiniNumberModel {

	private final int secretNumber;
	private int count;
	private final int max;
	private int guess;
	private int[] guessList = new int[10];
	private final int MAX_TRIES = 5;
	
	public MiniNumberModel(int max){
		this.max = max;
		secretNumber = (int)(Math.random()*max) + 1;
		count=0;
	}
	
	public void setGuess(int value){
		guess = value;
	}
	
	public int getGuess(){
		return guess;
	}

	public int getSecretNumber() {
		return secretNumber;
	}
	
	public int getMax(){
		return max;
	}
	
	public void setGuessListValue(int value){
		guessList[count++] = value;
	}
	
	public void inputGuess(int max){

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		boolean ok;
		
		do{   
			ok = true;
			System.out.print("Enter a number: ");
			guess = keyboard.nextInt();
			if(guess <= 0 || guess > max){
				System.out.println("*** Input out of range! ***");
				ok = false;
			}
		}while(!ok);
	}
	
	public String evaluation(){
		
		String msg;
		
		if(guess == secretNumber){
    		msg = "Correct!";
    	}
    	else{
    		if(guess < secretNumber){
       			msg = "Too low!";
    		}
    		else{
       			msg = "Too high!";
    		}
    	}
		
		return msg;
	}
	
	public void printGuessList() {

		System.out.print("Used numbers: ");
		for(int i=0; i<count; i++){
			System.out.print(guessList[i]+" ");
		}
		System.out.println("");
	}
	
	public boolean isGameOver(){
		return (guess == secretNumber || count >= MAX_TRIES);
	}

	public int getCount() {
		return count;
	}

}
