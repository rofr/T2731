package se.informator.t2731.figure;

public class TestFigure {

	public static void printFigures(Figure[] figures){

		for(int i=0; i<figures.length; i++){
			System.out.print(figures[i]);
			double area = figures[i].calcArea();
			System.out.println(", area = " + area);
		}
	}	
	
	public static void main(String[] args) {
		
		Figure[] figures = new Figure[6];
		
		figures[0] = new Rectangle();
		figures[1] = new Circle();
		figures[2] = new Rectangle(10, 15, 5, 10);
		figures[3] = new Circle(2, 2, 5);
		figures[4] = new Triangle();
		figures[5] = new Triangle(5, 5, 3, 4);
		
		printFigures(figures);

	}

}
