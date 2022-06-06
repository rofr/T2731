package se.informator.t2731.account;


public class TestAccount {

	  public static void main(String args[]){

	      Account a=new Account();
	      Account b=new Account(1000);

	      a.setBalance(b.getBalance()/2);
	      System.out.println(a.toString());	      
	      System.out.println(b);	      
	  }
}
