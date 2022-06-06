package se.informator.t2731.db;

import java.util.*;


public class CleanUpDb {

    private static String[] dbNames={"SOS", "Kalle", "Nisse", "Anna", "Emma", "Ylva", "Tom", "Nicklas" };
    private static String[] dbNos={"112", "12345", "888", "75135", "62333", "2523", "13454", "999"};
    private static String[] dbAddress={null, "Storgatan 12", "Kungsgatan 7", "Ekvägen 15",
    						"Pl 123", "Tvärgränd 9b", "Storgatan 41", "Avenyn 5"};
    
    public static void main(String[] args) {
        
        EnhancedPhoneBook edbpb = new EnhancedDBPhoneBook();        
        Set<String> dbSet = (HashSet<String>)edbpb.getAllNames();
        
        // remove all items
        Iterator<String> iter = dbSet.iterator();
        while(iter.hasNext()){
            String dbEntry=(String)iter.next();
            edbpb.removeEntry(dbEntry);
        }
        
        // store new items
        for(int i=0; i<dbNames.length; i++){
        	if(dbAddress[i] == null){
        		edbpb.addNameAndNumber(dbNames[i], dbNos[i]);
        	}
        	else{
        		((EnhancedDBPhoneBook)edbpb).addFullEntry(dbNames[i], dbAddress[i], dbNos[i]);
        	}
        }
        
        edbpb.shutDown();
    }

}
