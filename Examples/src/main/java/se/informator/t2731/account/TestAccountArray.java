
package se.informator.t2731.account;


public class TestAccountArray{

  public static void main(String args[]){

      Account[] accounts=new Account[5];

      for(int x=0; x<5; x++){
    	  if(x!=3){
    		  accounts[x]=new Account(1000 +  x*100);	  
    	  }
      }
      // print all array elements using a loop
      for(int i=0; i<accounts.length; i++){
    	  System.out.println(accounts[i]);
      }
  }
}