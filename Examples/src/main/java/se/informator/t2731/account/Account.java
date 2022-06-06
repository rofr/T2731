
package se.informator.t2731.account;

public class Account{

	// attributes
	private int accountNo;
	private float balance;

	// static member
	private static int uniqueNo=111001;

	// default constructor
	public Account(){
		accountNo=uniqueNo++;
	}

	// overloaded constructor
	public Account(float value){
		accountNo=uniqueNo++;
		balance=value;
	}

	// setters and getters
	public void setBalance(float value){
		balance=value;
	}
	public float getBalance(){
		return balance;
	}

	public int getAccountNo(){
		return accountNo;
	}

	// convert object to human readable format
	@Override
	public String toString(){
		return "Account "+accountNo+" balance : "+balance;
	}

}