package se.informator.t2731.person;

public class Employee implements Person{

	private String firstName;
	private String lastName;
	private String address;
	private int employeeNo;
	
	public Employee(String first, String last, String adr, int eno){
		firstName = first;
		lastName = last;
		address = adr;
		employeeNo = eno;
	}
	
	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public String getName() {
		return firstName+" "+lastName;
	}
	
	public int getEmployeeNo(){
		return employeeNo;
	}
	
	@Override
	public String toString(){
		  StringBuilder sb = new StringBuilder();
		  sb.append(getEmployeeNo());
		  sb.append(" ");
		  sb.append(getName());
		  sb.append(" ");
		  sb.append(getAddress());
		  return sb.toString();		
	}
	
}
