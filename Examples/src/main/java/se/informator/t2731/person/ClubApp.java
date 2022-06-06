package se.informator.t2731.person;

public class ClubApp {

	public static void main(String[] args) {
		
		Member m1 = new ClubMember("Ducksville Athlets", "Donald", 35);
		Member m2 = new ClubMember("Ducksville Athlets", "Goofy", 123);
		Member m3 = new ClubMember("Ducksville Athlets", "", 42);

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
	}

}
