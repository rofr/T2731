package se.informator.t2731.figure;

public class Circle extends Figure {
	
	private int radius;
	
	public Circle(){
		this(1, 1, 1);
	}
	
	public Circle(int x, int y, int r){
		super(x, y);
		radius = r;
	}
	
	@Override
	public double calcArea(){
		return (Math.PI * radius * radius); 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Circle [");
		builder.append(super.toString());
		builder.append(", radius=");
		builder.append(radius);
		builder.append("]");
		return builder.toString();
	}

}
