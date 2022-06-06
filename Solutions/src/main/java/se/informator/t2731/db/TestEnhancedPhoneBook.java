
package se.informator.t2731.db;
import java.util.*;

public class TestEnhancedPhoneBook {

    public static void main(String[] args) {
   	
      EnhancedPhoneBook dbpb=new EnhancedDBPhoneBook("phonedb");
      
      dbpb.addNameAndNumber("Duke", "555");

      String number=dbpb.findNumber("Kalle");
      if(!number.isEmpty()){
    	  System.out.println("Database info name: Kalle, number: "+number);
      }
      

      Set<String> names = dbpb.getAllNames();
      for(String s : names){
        System.out.println(s);
      }
      
      System.out.println("=========================================");
      System.out.println("Adding new entry to database");
      dbpb.addNameAndNumber("Urban", "654321");
      number=dbpb.findNumber("Urban");
      if(!number.isEmpty()){
    	  System.out.println("Database info name: Urban, number: "+number);

    	  System.out.println("=========================================");
    	  System.out.println("Updating existing entry in database");
    	  dbpb.updateEntry("Nisse", "888");
    	  number=dbpb.findNumber("Nisse");        
    	  System.out.println("Database info name: Nisse, number: "+number);

    	  System.out.println("=========================================");
    	  System.out.println("Removing entry from database");
    	  dbpb.removeEntry("Urban");   
    	  number=dbpb.findNumber("Urban");
    	  System.out.println("Database info name: Urban, number: "+number);
      }      
      
      dbpb.shutDown();
      
    }
}