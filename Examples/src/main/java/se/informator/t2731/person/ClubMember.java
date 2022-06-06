package se.informator.t2731.person;

public class ClubMember implements Member {
	
	private String clubName;
	private String name;
	private int points;
	
	public ClubMember(String clubName, String name, int points){
		this.clubName = clubName;
		if(name.isEmpty()){
			this.name = getMemberName();
		}		
		else{
			this.name = name;			
		}
		this.points = (Member.withinLimits(0, 100, points))? points: 0;
	}
	
	@Override
	public String getClubName() {
		return clubName;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int getPoints(){
		return points;
	}

	public void setPoints(int points){
		this.points = points;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClubMember ");
		builder.append(clubName);
		builder.append(", ");
		builder.append(name);
		builder.append(", ");
		builder.append(points);
		builder.append("p");
		return builder.toString();
	}

}
