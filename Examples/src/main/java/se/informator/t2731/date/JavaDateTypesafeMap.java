package se.informator.t2731.date;

import java.util.*;

public class JavaDateTypesafeMap {
	
	private Map<Integer, JavaDate> dateMap;
	
	public JavaDateTypesafeMap(String type){
		if(type.equals("Hash")){
			dateMap = new HashMap<Integer, JavaDate>();
		}
		else{
			dateMap = new TreeMap<Integer, JavaDate>();
		}
	}
	
	public void addDate(JavaDate jd){
		int dayNo = jd.calcDayNo();
		dateMap.putIfAbsent(dayNo, jd );
	}
	
	public void removeDate(JavaDate jd){
		int dayNo = jd.calcDayNo();		
		dateMap.remove(dayNo);
	}
	
	public boolean containsDate(JavaDate jd){		
		int dayNo = jd.calcDayNo();
		Set<Integer> keys = dateMap.keySet();
		return keys.contains(dayNo);
	}
	
	public int getNoOfDates(){
		return dateMap.size();
	}
	
	public void listAllDates(){		
		Set<Integer> keySet = dateMap.keySet();
		
		Iterator<Integer> keyIter = keySet.iterator();
		while(keyIter.hasNext()){
			Integer key = keyIter.next();
			JavaDate temp = dateMap.get(key);
			System.out.println(temp);
		}		
	}	
	
	public void printDates(){
		Set<Integer> keys = dateMap.keySet();
		for(Integer key : keys){
			JavaDate temp = dateMap.get(key);
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args){
		
		String type = "Hash"; // "Tree"; //
		JavaDateTypesafeMap jdm = new JavaDateTypesafeMap(type);
		
		JavaDate jd = new JavaDate();
		jdm.addDate(jd);	
		jd = new JavaDate(2011, 9, 17);
		jdm.addDate(jd);
		jd = new JavaDate(1999, 12, 31);
		jdm.addDate(jd);
		jd = new JavaDate(2020, 4, 22);
		jdm.addDate(jd);		
		jd = new JavaDate(1973, 1, 5);
		jdm.addDate(jd);
		jd = new JavaDate(1999, 12, 31);
		jdm.addDate(jd);		
		jd = new JavaDate(2005, 4, 22);
		jdm.addDate(jd);	
		
		JavaDate test = new JavaDate(1973, 1, 5);
		if(jdm.containsDate(test)){
			jdm.removeDate(test);
		}
		
		System.out.println("Map holds "+jdm.getNoOfDates()+" JavaDate objects");
		jdm.listAllDates();
	}
}
