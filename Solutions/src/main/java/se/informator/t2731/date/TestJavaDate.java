package se.informator.t2731.date;

import java.util.Scanner;

public class TestJavaDate {
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		JavaDate jd1 = new JavaDate();
		System.out.println("Default JavaDate: "+jd1.toString());
		
		JavaDate jd2 = new JavaDate(2006, 11, 5);
		System.out.println("Overloaded JavaDate: "+jd2.toString());

		JavaDate jd3 = new JavaDate(1973, jd1.getMonth(), jd2.getDay());
		System.out.println("Combined JavaDate: "+jd3.toString());

		System.out.println("Check if jd1 is a leap year: "+jd1.isLeapYear());
		System.out.println("Calculated day no for jd2: "+jd2.calcDayNo());

		JavaDate jd4 = new JavaDate("1989-04-17");
		System.out.println("String based JavaDate: "+jd4.toString());
		
		boolean ok;
		JavaDate jd5=null;
		do{
			ok = true;
			try{		
				System.out.print("Enter values for a new JavaDate YYYY-MM-DD: ");
				Scanner input = new Scanner(System.in);
				String userDate = input.next();

				String[] dateStrings = userDate.split("-");
				int y = Integer.parseInt(dateStrings[0]);
				int m = Integer.parseInt(dateStrings[1]);
				int d = Integer.parseInt(dateStrings[2]);
				jd5 = new JavaDate(y, m, d);	
				System.out.println("User defined JavaDate: "+jd5.toString());	
			}
			catch(NumberFormatException nfe){
				System.out.println("A Date must hold numerical values!");
				ok=false;
			}
			catch(ArrayIndexOutOfBoundsException aioobe){
				System.out.println("Input must use format YYYY-MM-DD!");
				ok=false;
			}
			catch(IllegalArgumentException iae){
				System.out.println(iae.toString());
				ok=false;
			}
		}while(!ok);

		JavaDate[] dateList = new JavaDate[5];
		dateList[0] = jd1;
		dateList[1] = jd2;
		dateList[2] = jd3;
		dateList[3] = jd4;
		dateList[4] = jd5;
		
		for(int i=0; i<dateList.length; i++){
			System.out.println(dateList[i]);
		}
	}
}
