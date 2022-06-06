package se.informator.t2731.db;

import java.util.*;

public class TestDbPhoneBook {
  
	public static void main(String[] args) {
		
      PhoneBook dbpb=new DBPhoneBook("phonedb");
      
      dbpb.addNameAndNumber("Duke", "555");

      String number=dbpb.findNumber("Kalle");
      if(!number.isEmpty()){
        System.out.println("Number read from db using key Kalle "+number);
      }
      else{
          System.out.println("Number to Kalle can not be found in db!");    	  
      }
      
      number=dbpb.findNumber("Karin");
      if(!number.isEmpty()){
        System.out.println("Number read from db using key Karin "+number);
      }
      else{
          System.out.println("Number to Karin can not be found in db!");    	  
      }
      

      Set<String> names = dbpb.getAllNames();
      for(String name: names){
          System.out.println(name);
      }
      
      dbpb.shutDown();
    }

}