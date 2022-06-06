package se.informator.t2731.date;

import java.util.ArrayList;
import java.util.List;

public class TestJavaDateFile {

	public static void main(String[] args){
		
		ArrayList<JavaDate> dates = new ArrayList<JavaDate>();
		
		dates.add(new JavaDate());	
		dates.add(new JavaDate(2011, 9, 17));
		dates.add(new JavaDate("1973-11-17"));
	
		for(JavaDate jd : dates){
			System.out.println("Original date: " + jd);
		}
			
		System.out.println("------------------------------------------------------------");
		// store and read back collection of JavaDate objects
		JavaDateFileSupport.storeTextCollection(dates, "JavaDatesCol.txt");	
		List<JavaDate> fileDateTextCol = JavaDateFileSupport.readTextCollection("JavaDatesCol.txt");
		for(int i=0; i<fileDateTextCol.size(); i++){
			System.out.println("JavaDate from text file: "+fileDateTextCol.get(i));
		}
		
		/*
		System.out.println("------------------------------------------------------------");
  		// store and read back array of JavaDate objects in binary mode
		JavaDateFileSupport.storeBinaryDates(dates, "JavaDates.dat");		
		List<JavaDate> fileDateBinaryCol = JavaDateFileSupport.readBinaryDates("JavaDates.dat");
		for(int i=0; i<fileDateBinaryCol.size(); i++){
			System.out.println("JavaDate from binary file: "+fileDateBinaryCol.get(i));
		}
		
		System.out.println("------------------------------------------------------------");
  		// store and read back JavaDate objects using serialization
		JavaDateFileSupport.storeObjectDates(dates, "JavaDates.ser");		
		List<JavaDate> fileDateObjectCol = JavaDateFileSupport.readObjectDates("JavaDates.ser");
		for(JavaDate temp : fileDateObjectCol){
			System.out.println("JavaDate from object file: "+temp);
		}
		*/
	}
}
