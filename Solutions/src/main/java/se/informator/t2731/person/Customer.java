package se.informator.t2731.person;

public class Customer implements Person {
	 
    private String address;
    private String name;

    public Customer(String n, String a){
      name=n;
      address=a;
    }

	@Override
    public String getName(){
        return name;
    }
    
	@Override
    public String getAddress(){
        return address;
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