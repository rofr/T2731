package se.informator.t2731.date;

import java.util.*;

public class TestJavaDate {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		JavaDate jd1 = new JavaDate();
		System.out.println("Default JavaDate: "+jd1.toString());
		
		JavaDate jd2 = new JavaDate(2011, 9, 17);
		System.out.println("Overloaded JavaDate: "+jd2.toString());
		
		JavaDate jd3 = new JavaDate(1973, jd1.getMonth(), jd2.getDay());
		System.out.println("Combined JavaDate: "+jd3.toString());

		System.out.println("Check if jd1 is a leap year: "+jd1.isLeapYear());
		System.out.println("Calculated day no for jd2: "+jd2.calcDayNo());		
		
		JavaDate jd4 = new JavaDate("1989-04-23");
		System.out.println("String based JavaDate: "+jd4.toString());
		
		System.out.print("Enter values for a new JavaDate YYYY-MM-DD: ");
		Scanner input = new Scanner(System.in);
		String userDate = input.next();
		
		String[] dateStrings = userDate.split("-");
		int y = Integer.parseInt(dateStrings[0]);
		int m = Integer.parseInt(dateStrings[1]);
		int d = Integer.parseInt(dateStrings[2]);		
		JavaDate jd5 = new JavaDate(y, m, d);
		System.out.println("User defined JavaDate: "+jd5.toString());				
		
	}
}
