package se.informator.t2731.figure;

public abstract class Figure {

	private int xpos;
	private int ypos;
	
	public Figure(){
		this(1, 1);
	}
	
	public Figure(int x, int y){
		xpos = x;
		ypos = y;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("xpos=");
		builder.append(xpos);
		builder.append(", ypos=");
		builder.append(ypos);
		return builder.toString();
	}

	public abstract double calcArea();
	
}
