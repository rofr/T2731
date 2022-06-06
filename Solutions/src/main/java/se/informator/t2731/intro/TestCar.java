package se.informator.t2731.intro;

public class TestCar {

	public static void main(String[] args){
		
		Car car1 = new Car("Volvo S80", 2003, "ABC111", "BegBil AB");
		Car car2 = new Car("Saab 9-3", 2002, "DEF222", "BegBil AB");
		Car car3 = new Car("Toyota Corolla", 2001, "GHI333", "BegBil AB");		
		
		System.out.println("BegBil AB - Cars for sale:");
		System.out.println(car1.getType()+" "+car1.getProductionYear()+" "+car1.getRegNo());
		System.out.println(car2.getType()+" "+car2.getProductionYear()+" "+car2.getRegNo());
		System.out.println(car3.getType()+" "+car3.getProductionYear()+" "+car3.getRegNo());
		
		Car car4 = new Car("Saab 900", 1998, "JKL999", "Kalle Kula");
		String seller = car4.getOwner();
		String buyer = car1.getOwner();
		car4.setOwner(buyer);

		System.out.println("------------------------------------------------");
		System.out.println("Car " + car4.getRegNo()+" bought from "+seller+" by " +buyer);				
		System.out.println("Car " + car1.getRegNo()+" sold to "+seller+" by "+buyer);
		car1.setOwner(seller);
		car1.setRegNo("Kula1");
		System.out.println("Car info: "+car1.toString());

		System.out.println("------------------------------------------------");
		System.out.println("BegBil AB - Cars for sale:");
		System.out.println(car2.getType()+" "+car2.getProductionYear()+" "+car2.getRegNo());
		System.out.println(car3.getType()+" "+car3.getProductionYear()+" "+car3.getRegNo());
		System.out.println(car4.getType()+" "+car4.getProductionYear()+" "+car4.getRegNo());
		
	}
	
}
