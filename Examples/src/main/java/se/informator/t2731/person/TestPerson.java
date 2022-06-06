package se.informator.t2731.person;

public class TestPerson {

  public static void main(String[] args) {
    Person p1 = new Customer("Mr Buyer", "PO Box 123");
    System.out.println("Customer " +p1.getName());
    System.out.println("Address " +p1.getAddress());
    
    Person p2 = new Student("Nicke", "Nyfiken", "nicke.nyfiken@yahoo.com");
    System.out.println("Student " +p2.getName());
    System.out.println("Address " +p2.getAddress());
  /*  
    Person p3 = new Employee("Joe", "Smith", "51 Main Street", 12345);    
    System.out.println("Employee " +p3.getName());
    System.out.println("Address " +p3.getAddress());
    System.out.println("Employee info: "+p3.toString());
    */
  }
}


 
