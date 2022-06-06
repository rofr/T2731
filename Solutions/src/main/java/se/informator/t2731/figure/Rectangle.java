package se.informator.t2731.figure;

public class Rectangle extends Figure {

	private int width;
	private int height;
	
	public Rectangle(){
		this(1, 1, 1, 1);
	}
	
	public Rectangle(int x, int y, int w, int h){
		super(x, y);
		width = w;
		height = h;
	}
	
	@Override
	public double calcArea(){
		return width * height; 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Rectangle [");
		builder.append(super.toString());
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}
	
}
