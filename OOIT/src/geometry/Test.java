package geometry;

public class Test {

	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point();
		
		System.out.println(p1.getX());
		
		p1.setX(6);
		p1.setY(7);
		
		p1.setSelected(true);
		
		p2.setX(9);
		p2.setY(10);
		
		double d = p1.distance(p2.getX(), p2.getY());		
		System.out.println(d);
		
		System.out.println("X coordinate of point p is: " + p1.getX() + '\n' +
				"Y coordinate of point p is: " + p1.getY() + '\n' +
				"Point p is selected: " + p1.isSelected());

	}

}
