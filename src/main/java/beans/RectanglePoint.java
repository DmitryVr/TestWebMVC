package beans;

public class RectanglePoint extends Shape {

	private Point p1;
	
	private Point p2;

	public RectanglePoint(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public double square() {
		
		double width = p1.getY() - p2.getY();
		
		double height = p2.getX() - p1.getX();
		
		return width * height;
	}
	
	
}
