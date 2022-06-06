package se.informator.t2731.intro;

public class ValidateEmail {

	public static void main(String[] args) {
		
		String[] emailList = new String[6];

		emailList[0] = "hans.c.andersen@tivoli.copenhagen.dk";
		emailList[1] = "bill@gates@microsoft.com";
		emailList[2] = "lotta.walters@pl123.storskogen.se";
		emailList[3] = "tomten@nordpolen.fi";
		emailList[4] = "tomtemor@nordpolen..fi";
		emailList[5] = "tomtenisse.@nordpolen.fi";
		
		for(int i=0; i<emailList.length; i++){
			String temp = emailList[i];
			
			boolean ok = validate(temp);
			if(ok){			
				System.out.println(temp + " is a valid email String!");								
			}
			else{
				System.out.println("*** " + temp +" is NOT a valid email String! ***");
			}
			System.out.println("--------------------------------------------------------------");

		}
		
	}

	private static boolean validate(String input) {
		System.out.println("Debug: validate " + input);

		// check that there is only one @
		int atPos = input.indexOf('@');
		int nextAtPos = input.indexOf('@', atPos+1);
		if(!(atPos>0 && nextAtPos == -1)){
			return false;
		}
		
		// check that first char is a letter, last char is not a dot
		boolean firstChar = Character.isLetter(input.charAt(0));
		boolean lastChar = input.charAt(input.length()-1) != '.';
		if(!(firstChar && lastChar)){
			return false;
		}
			
		// check that dot is only used as separator
		int dotPos = -1;
		do{
			dotPos = input.indexOf('.', dotPos + 1);
			if(dotPos != -1){
				char before = input.charAt(dotPos-1);
				char after = input.charAt(dotPos+1);
				if(!(Character.isLetterOrDigit(before) && Character.isLetterOrDigit(after))){
					return false;
				}
			}
		}while(dotPos != -1);
		
		return true;
	}

}
