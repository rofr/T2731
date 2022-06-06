package se.informator.t2731.date;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public final class JavaDate {

	private final int year;
	private final int month;
	private final int day;

	static final int[] daysInMonth = {0, 31,28,31, 30,31,30, 31,31,30, 31,30,31 };

	/**
	 * Default constructor setting up date to first in 400 year cycle
	 */
	public JavaDate(){
		this(2000, 1, 1);
	}

	/**
	 * Overloaded constructor supporting numerical parameters
	 * @param y holding year value
	 * @param m holding month value
	 * @param d holding day value
	 * @throws IllegalArgumentException if any parameter is out of limits
	 */
	public JavaDate(int y, int m, int d){
		if(checkValidInput(y, m, d)){
			year = y;
			month = m;
			day = d;
		}
		else{
			throw new IllegalArgumentException("Params can not create a JavaDate!");
		}
	}

	/**
	 * Overloaded constructor supporting text based parameters
	 * @param dateString holding a complete date
	 */
	public JavaDate(String dateString){
		StringTokenizer st = new StringTokenizer(dateString, "-");

		try {
			int y = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(checkValidInput(y, m, d)){
				year = y;
				month = m;
				day = d;
			}
			else{
				throw new IllegalArgumentException("Params can not create a JavaDate!");
			}
		} 
		catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid string use format YYYY-MM-DD!");
		}
		catch(NoSuchElementException e){
			throw new IllegalArgumentException("Invalid string use format YYYY-MM-DD!");
		}

	}	

	/**
	 * Getter for year attribute
	 * @return int holding current year value
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Getter for month attribute
	 * @return int holding current month value
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Getter for day attribute
	 * @return int holding current day value
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Conversion method to human readable format
	 * @return String holding date in format YYYY-MM-DD
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();		
		sb.append(year);
		sb.append("-");
		sb.append(twoDigitString(month));
		sb.append("-");
		sb.append(twoDigitString(day));

		return sb.toString();
	}

	/**
	 * Helper method for formatting of output
	 * @param value numeric value for month or day
	 * @return String holding 2 chars for MM or DD
	 */
	private String twoDigitString(int value){
		String output;
		if(value < 10){
			output = "0"+value;
		}
		else{
			output = String.valueOf(value);
		}

		return output;
	}

	/**
	 * This method checks if current year is a leap year, holding an extra day
	 * @param year numeric value to check 
	 * @return boolean indicating true for a leap year, false otherwise
	 */
	public boolean isLeapYear(int year){
		boolean leap=false;
		if ( (year%4==0 && year%100 != 0) || year%400==0){
			leap = true;
		}
		return leap;
	}

	/**
	 * This method checks if current year is a leap year, holding an extra day
	 * @return boolean indicating true for a leap year, false otherwise
	 */
	public boolean isLeapYear(){
		return isLeapYear(year);
	}

	/**
	 * This method calculates the number of days that has passed for current year
	 * @return int holding current day number
	 */
	public int calcDayNo(){
		int dayNo=0;

		for(int i=1; i<month; i++){
			dayNo += daysInMonth[i];
		}
		dayNo += day;

		if(isLeapYear(year) && month>2){
			dayNo++;
		}

		return dayNo;
	}

	/**
	 * This method checks that a JavaDate object can be created based on inparameters
	 * @param y holding year value to check
	 * @param m holding month value to check
	 * @param d holding day value to check
	 * @return boolean indicating if inparams are within limits
	 */
	private boolean checkValidInput(int y, int m, int d){
		boolean ok=true;

		if(m<1 || m>12){
			ok = false;
		}
		else{
			if(m != 2 ){			
				if(d<1 || d>daysInMonth[m]){
					ok = false;
				}
			}
			else{				
				int maxDay = isLeapYear(y)? 29: 28;
				if(d<1 || d>maxDay){
					ok = false;
				}
			}
		}

		return ok;
	}

	/**
	 * Overriding inherited method (from Object) defining equality
	 * @param obj another JavaDate object
	 * @return boolean true if contents are equal
	 */
	public boolean equals(Object obj){
		boolean flag = false;		
		if(obj instanceof JavaDate){
			JavaDate that = (JavaDate)obj;
			if(this.year == that.year && this.month == that.month && this.day == that.day){
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Quick and dirty overriding of inherited method from Object
	 * @return int holding a unique hashcode for this object
	 */
	public int hashCode(){
		return (this.toString()).hashCode();
	}

	public int compareTo(JavaDate that) {
		int value;	
		if(this.year == that.year && this.month == that.month && this.day == that.day){
			value = 0;
		}
		else{
			if(this.year > that.year
					|| this.year == that.year && this.month > that.month
					|| this.year == that.year && this.month == that.month && this.day > that.day){
				value = 1;
			}
			else{
				value = -1;
			}
		}	
		return value;
	}


	// testing leap year only
	public static void main(String[] args){

		int[] leapTestList = {
				2000,
				2010,
				2011,
				2100,
				2400
		};

		for(int testYear: leapTestList) {
			try {
				new JavaDate(testYear, 2, 29);
				System.out.println(testYear + " is a leap year!");
			}
			catch(IllegalArgumentException e) {
				System.out.println(e);
				System.out.println(testYear + " is NOT a leap year!");
			}
		}
	}
}
