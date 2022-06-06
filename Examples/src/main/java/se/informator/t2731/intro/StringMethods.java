package se.informator.t2731.intro;

public class StringMethods {

	public static void main(String[] args) {
		String text = "Annas ananas i glass";
		
		// inspecting String object
		if(text.isEmpty()){
			System.out.println("String object text is empty!");
		}
		else{
			int n = text.length();
			System.out.println("text holds " + n + " characters");
			System.out.print("First is " + text.charAt(0));
			System.out.println(", last is " + text.charAt(n-1));
		}		
		System.out.println("");	
		
		
		// look for start/end of text
		if (text.startsWith("Ann")){
			System.out.println("text starts with Ann");
		}
		if (text.endsWith("Glass")){
			System.out.println("text ends with Glass");
		}
		System.out.println();
		
		// look for first index in text
		int firstPos = text.indexOf("na");		
		while(firstPos != -1){
			System.out.println("Found na at pos " + firstPos);
			firstPos = text.indexOf("na", firstPos+1);
		}
		System.out.println();
		
		
		// look for last index in text
		int lastPos = text.lastIndexOf("as");
		while(lastPos != -1){
			System.out.println("Found as at pos " + lastPos);
			lastPos = text.lastIndexOf("as", lastPos-1);
		}

		System.out.println();
				
		
		// divide text into parts
		String[] parts = text.split(" ");
		System.out.println("Splitting \"" + text + "\" into pieces");
		for(int i=0; i<parts.length; i++){
			System.out.println("part no "+i+" = "+parts[i]);
		}
		System.out.println();
		
		String firstPart = parts[0].toLowerCase();
		String lastPart = parts[parts.length-1].toUpperCase();
		String newText = firstPart + " " + lastPart;
		System.out.println("Manipulated text: " + newText);
	}

}
