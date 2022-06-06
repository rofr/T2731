package se.informator.t2731.deploy;

public class MiniNumberApp {
	
	public static void main(String[] args){
		
		int max = 20;
		MiniNumberModel theModel = new MiniNumberModel(max);

    	boolean status;
    	
    	do{    		
    		// call input routine
    		theModel.inputGuess(max);
    		
    		// store new guess in int-array
    		theModel.setGuessListValue(theModel.getGuess());
    		
    		// call evaluation routine
    		String output = theModel.evaluation();
    		System.out.println(output);
    		status = output.equals("Correct!");

    		// conditionally call print of previous guesses
    		if(status == false){
    			theModel.printGuessList();
        	}
    	}while(!theModel.isGameOver());
    	
    	if(status == false){
    		System.out.println("Sorry, no more tries, correct number "+theModel.getSecretNumber());
    	}
	}
}
