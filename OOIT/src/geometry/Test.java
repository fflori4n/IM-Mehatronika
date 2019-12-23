package geometry;

import java.util.Arrays;

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
		try {
			//c1.setR((int) c1.getCenter().distance(l1.getStartPoint().getX(), l1.getStartPoint().getY()));
			c1.setR(10);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		
		//VEZBE 4
		Point p3 = new Point(6, 7);
		Line l2 = new Line(p2, new Point(12, 13));
		Rectangle r2 = new Rectangle(new Point(p2.getX(), p2.getY()), 50, 100);

		p2.setX(50);
		r2.getUpperLeft().setX(p2.getX());

		Circle c2 = new Circle(new Point(), 10, true);

		System.out.println("X, Y center c2: " + c2.getCenter().getX() + " " + c2.getCenter().getY());
		System.out.println("p2 x: " + p2.getX());
		System.out.println("l2 x startPoint: " + l2.getStartPoint().getX());
		System.out.println("r2 upperLeft x: " + r2.getUpperLeft().getX());

		// kreirati pravougaonik r3 tako da ima iste koordinate kao pocetna tacka l2
		// tako da se promenom x i y pocetne tacke l2 ne promene x, y r3
		// visina duzina linije l2
		// sirina povrsina r2 umanjena za povrsina c2
		// selected vrednost izraza konjunkcije selected krajnje tacke l2 i p1

		Rectangle r3 = new Rectangle(new Point(l2.getStartPoint().getX(), l2.getStartPoint().getY()),
				(int) (r2.area() - c2.area()), (int) (l2.length()), l2.getEndPoint().isSelected() && p1.isSelected());

		System.out.println(p1);
		System.out.println(l2);
		System.out.println(r3+" selected = " + r3.isSelected());
		System.out.println(c2);

		Point p5 = new Point(5, 6);
		Point p6 = p5;
		Point p7 = new Point(5, 6);

		System.out.println("p5 == p6: " + (p5==p6));
		System.out.println("p5 == p7: " + (p5==p7));

		System.out.println("p5 equals p6: " + p5.equals(l1));
		System.out.println("p5 equals p7: " + p5.equals(p7));

		Line l3 = new Line(new Point(10, 11), new Point(12, 13));
		Line l4 = new Line(new Point(10, 11), new Point(12, 13));

		System.out.println("l3 equals l4: " + l3.equals(l4));
		
		// VEZBE 5
		System.out.println(p5.contains(10,7));

		Donut d1 = new Donut(new Point(50, 50), 100, 20);
		System.out.println(d1.getR()+" "+d1.getInnerR());
		System.out.println();

		// VEZBE 7
		System.out.println(p1);
		p1.moveBy(5, 3);
		System.out.println(p1);
		p1.moveTo(5, 3);
		System.out.println(p1);

		System.out.println(l1);
		l1.moveBy(5, 3);
		System.out.println(l1);

		System.out.println(r1);
		r1.moveBy(5, 3);
		System.out.println(r1);
		r1.moveTo(5, 3);
		System.out.println(r1);

		System.out.println(c1);
		c1.moveBy(5, 3);
		System.out.println(c1);
		c1.moveTo(5, 3);
		System.out.println(c1);

		System.out.println(d1);
		d1.moveBy(5, 3);
		System.out.println(d1);
		d1.moveTo(5, 3);
		System.out.println(d1);

		Shape d3 = new Donut(p1, 10, 2);
		Shape p9 = new Point();
		Shape l9 = l1;
		Shape c9 = c1;

		Shape[] shapes = {d3, p9, l9, c9};
		System.out.println("\n");
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);
		}

		for (int i = 0; i < shapes.length; i++) {
			shapes[i].moveBy(1, 2);
		}

		System.out.println("\n");
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);
		}

		int[] ints = {5,2,3,4,1};
		System.out.println("Nesortiran niz\n");
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i]);
		}

		Arrays.sort(ints);

		System.out.println("\nSortiran niz\n");
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i]);
		}


		Point p10 = new Point(10, 10);
		Point p20 = new Point(20, 20);
		Point p30 = new Point(30, 30);
		Point p40 = new Point(40, 40);
		Point p50 = new Point(50, 50);

		Point[] points = {p30, p10, p20, p50, p40};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}

		Arrays.sort(points);

		System.out.println("Sortiran niz: ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}

		Line l10 = new Line(new Point(10, 10), new Point(100, 100));
		Line l20 = new Line(new Point(10, 10), new Point(200, 200));
		Line l30 = new Line(new Point(10, 10), new Point(300, 300));
		Line[] lines = {l30, l10, l20};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}

		Arrays.sort(lines);

		System.out.println("Sortiran niz: ");
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}

		Rectangle r10 = new Rectangle(p1, 10, 10);
		Rectangle r20 = new Rectangle(p2, 20, 20);
		Rectangle r30 = new Rectangle(p3, 30, 30);
		Rectangle[] rectangles = {r30, r10, r20};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}

		Arrays.sort(rectangles);

		System.out.println("Sortiran niz: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}

		Circle c10 = new Circle(p1, 10);
		Circle c20 = new Circle(p1, 20);
		Circle c30 = new Circle(p1, 30);
		Circle[] circles = {c30, c10, c20};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < circles.length; i++) {
			System.out.println(circles[i]);
		}

		Arrays.sort(circles);

		System.out.println("Sortiran niz: ");
		for (int i = 0; i < circles.length; i++) {
			System.out.println(circles[i]);
		}

		Donut d10 = new Donut(p10, 100, 10);
		Donut d20 = new Donut(p10, 100, 20);
		Donut d30 = new Donut(p10, 100, 30);
		Donut[] donuts = {d30, d10, d20};
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < donuts.length; i++) {
			System.out.println(donuts[i]);
		}

		Arrays.sort(donuts);

		System.out.println("Sortiran niz: ");
		for (int i = 0; i < donuts.length; i++) {
			System.out.println(donuts[i]);
		}
		
		//VEZBE 10
		try {
			System.out.println(donuts[2]);
			Integer.parseInt("pet");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ne postoji element sa indeksom 10");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ne mogu da pretvorim u int");
		} finally {
			System.out.println("ja se uvek izvrsavam!");
		}
		System.out.println("da li sam se ispisao na konzolu ");
	}

}
