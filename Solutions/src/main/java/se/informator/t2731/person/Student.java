package se.informator.t2731.person;


public class Student implements Person {

	private String firstName;
	private String lastName;
	private String email;

	public Student(String fn, String ln, String e){
		firstName=fn;
		lastName=ln;
		email=e;
	}

	@Override
	public String getName() {
		return firstName+" "+lastName;
	}

	@Override
	public String getAddress() {
		return email;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(" ");
		sb.append(getAddress());
		return sb.toString();
	}
}
