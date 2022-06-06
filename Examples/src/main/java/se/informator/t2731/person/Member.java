package se.informator.t2731.person;

public interface Member {
	
	String getClubName();
	
	default String getMemberName(){
		return "Guest";
	}

	static boolean withinLimits(int min, int max, int value){
		return (value >= min && value <= max)? true: false;
	}

}
