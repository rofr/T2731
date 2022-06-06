package se.informator.t2731.date;

import java.util.*;

public class JavaDateTypesafeCollection {
	
	private Collection<JavaDate> col;
	
	public JavaDateTypesafeCollection(String type){
		if(type.equals("List")){
			col = new ArrayList<JavaDate>();
		}
		else{
			col = new HashSet<JavaDate>();
		}
	}
	
	public void addDate(JavaDate jd){
		col.add(jd);
	}
	
	public void removeDate(JavaDate jd){
		col.remove(jd);
	}
	
	public boolean containsDate(JavaDate jd){		
		return col.contains(jd);
	}
	
	public int getNoOfDates(){
		return col.size();
	}

	public void listDates(){
		Iterator<JavaDate> iter = col.iterator();
		while(iter.hasNext()){
			JavaDate temp = iter.next();
			System.out.println(temp);
		}
	}

	public void printDates(){
		for(JavaDate temp: col){
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args){
		
		String type =   "List"; // "Set"; //
		JavaDateTypesafeCollection jdc = new JavaDateTypesafeCollection(type);
		
		JavaDate jd = new JavaDate();
		jdc.addDate(jd);	
		jd = new JavaDate(2011, 9, 17);
		jdc.addDate(jd);
		jd = new JavaDate(1999, 12, 31);
		jdc.addDate(jd);
		jd = new JavaDate(2020, 4, 22);
		jdc.addDate(jd);		
		jd = new JavaDate(1973, 1, 5);
		jdc.addDate(jd);
		jd = new JavaDate(1999, 12, 31);
		jdc.addDate(jd);		
		jd = new JavaDate(2005, 4, 22);
		jdc.addDate(jd);	
		
		JavaDate test = new JavaDate(1973, 1, 5);
		if(jdc.containsDate(test)){
			jdc.removeDate(test);
		}
		
		System.out.println("Collection holds "+jdc.getNoOfDates()+" JavaDate objects");
		jdc.printDates();
	}

}
