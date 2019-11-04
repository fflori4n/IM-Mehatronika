package geometry;

public class Test {

	public static void main(String[] args) {
		// VEZBE 2
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
		
		//VEZBE 3
		Point pt1 = new Point();
		pt1.setX(10);
		pt1.setY(20);
		
		Point pt2 = new Point();
		pt2.setX(20);
		pt2.setY(40);
		
		Line l1 = new Line();
		l1.setStartPoint(pt1);
		l1.setEndPoint(pt2);
		
		l1.getStartPoint().setX(25); // Menja se vrednost X koordinate tacke startPoint, tj. tacke pt1.
		System.out.println("Nova vrednost X koordinate tacke pt1: " + l1.getStartPoint().getX());
		
		Rectangle r1 = new Rectangle();
		// ispisati povrsinu r1
		System.out.println("P r1: " + r1.area());

		// postaviti upperLeft r1 na endPoint l1
		r1.setUpperLeft(l1.getEndPoint());

		Circle c1 = new Circle();
		c1.setCenter(p2);
		System.out.println("\n\nX center c1: " + c1.getCenter().getX()
				+"\n\tY center c1: "+c1.getCenter().getY()
				+"\nr c1: "+c1.getR()
				+"\nselected c1: "+c1.isSelected());

		// postaviti radius kruga c1 na vrednost udaljenosti tacaka
		// center c1 i l1 startPoint
		c1.setR((int) c1.getCenter().distance(l1.getStartPoint().getX(), l1.getStartPoint().getY()));
		System.out.println("R c1: "+c1.getR());

		// postaviti selected c1 na vrednost izraza koji proverava
		// da li je x centra c1 vece od y koordinate upperLeft r1
		c1.setSelected(c1.getCenter().getX() > r1.getUpperLeft().getY());
		System.out.println(c1.isSelected());

		// Postaviti y koordinatu krajnje tacke l1 na vrednost
		// razlike koordinata centra kruga c1 
		// umanjene 
		// za vrednost zbira x koordinate upperLeftPoint r1 i povrsine c1
		l1.getEndPoint().setY((int) ((c1.getCenter().getX() - c1.getCenter().getY())
				- (r1.getUpperLeft().getX() + c1.area())));
		System.out.println(l1.getEndPoint().getY());

	}

}
