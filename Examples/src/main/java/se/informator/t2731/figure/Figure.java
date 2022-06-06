package se.informator.t2731.figure;

public abstract class Figure {

	// common attributes
	private int xpos;
	private int ypos;
	
	// constructor
	protected Figure(int x, int y){
		xpos = x;
		ypos = y;
	}
		
	// abstract operation
	public abstract double calcArea();
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("xpos=");
		builder.append(xpos);
		builder.append(", ypos=");
		builder.append(ypos);
		return builder.toString();
	}
	
}
