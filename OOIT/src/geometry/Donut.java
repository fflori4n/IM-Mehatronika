package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerR;

	public Donut() {

	}

	public Donut(Point center, int r, int innerR) {
		super(center, r);
		this.innerR = innerR;
	}

	public Donut(Point center, int r, int innerR, boolean selected) {
		this(center, r, innerR);
		this.selected = selected;
//		super(center, r, selected);
//		this.innerR = innerR;
	}

	@Override
	public double area() {
		return super.area() - innerR * innerR * Math.PI;
	}

	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(x, y) >= innerR;
	}

	@Override
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	// Center:(xCenter,yCenter), radius = <radius>, inner radius = <radius>
	public String toString() {
		return super.toString()+", inner radius = "+innerR;
	}

	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.black);
		g.drawOval(center.getX()-innerR, center.getY()-innerR, 2*innerR, 2*innerR);
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(this.getCenter().getX() - innerR - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() + innerR - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - innerR - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() + innerR - 2, 4, 4);
		}
	}

}
