package se.informator.t2731.figure;

public class Triangle extends Figure {

	private int base;
	private int height;
	
	public Triangle(){
		this (1, 1, 1, 1);
	}
	
	public Triangle(int x, int y, int b, int h) {
		super(x, y);
		base = b;
		height = h;
	}

	@Override
	public double calcArea() {
		return (double)base * height / 2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Triangle [");
		builder.append(super.toString());
		builder.append(", base=");		
		builder.append(base);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

}
