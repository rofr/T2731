package se.informator.t2731.intro;

public class DataTypes {

	public static void main(String[] args) {
		
		// integer types holding an exact binary sequence
		byte b = 7;				 	// 1 byte
		short s = 1234;			 	// 2 bytes
		int i = 32189;			 	// 4 bytes
		long l = 123456789012345L; 	// 8 bytes
		
		// scientific types covering a larger scope of values compared to integers
		float f = (float)3.14;	 	// 4 bytes
		double d = 1.23456789;	 	// 8 bytes
		
		System.out.println("Integer types (byte, short, int, long) " + b +", "+ s +", "+ i +", "+ l);
		System.out.println("Floating point types (float, double) " + f +", "+ d);
		
		// miscellaneous types
		char c = 'X';			 	// 2 bytes
		boolean ok = true;		  		
		String t = "A short text";

		System.out.println("Character type (char) " + c);
		System.out.println("Boolean type (boolean) " + ok);
		System.out.println("Reference type (holds address) " + t);	
		
	}
}
