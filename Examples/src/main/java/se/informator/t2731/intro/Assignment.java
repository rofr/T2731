package se.informator.t2731.intro;

public class Assignment {

		  public static void main(String[] args) {
			  
			int i1 = 10;	// i1 = 10
		  	int i2 = 2;		// i2 =  2
		  	i1 += 25;		// i1 = 35
		  	i1 -= i2;		// i1 = 33
		  
		  	int i3 = ++i1 * i2--; 	// i1 = 34; i3 = 68; i2 = 1
			System.out.println("Final values i1, i2, i3:  "
					+i1+", "+i2+", "+ i3);

		}

}
