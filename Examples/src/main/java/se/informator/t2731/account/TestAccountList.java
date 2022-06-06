package se.informator.t2731.account;

import java.util.ArrayList;
import java.util.Iterator;

public class TestAccountList {

	public static void main(String[] args){

		ArrayList<Account> accounts=new ArrayList<Account>();
//		ArrayList<Account> accounts=new ArrayList<>(); // Java 7

		for(int x=0; x<5; x++){
			accounts.add(new Account(1000 +  x*100));  		  
		}

		// print account numbers
		Iterator<Account> iter = accounts.iterator();
		while(iter.hasNext()){
			Account temp = iter.next();
			System.out.println(temp.getAccountNo());
		}
		
//		// for:each replaces need for Iterator
//		for(Account temp: accounts){
//			System.out.println(temp.getAccountNo());
//		}

	}	

}
