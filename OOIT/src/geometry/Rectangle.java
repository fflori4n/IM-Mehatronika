package geometry;

public class Rectangle {
	private Point upperLeft;
	private int width;
	private int height;
	private boolean selected;
	
	public Rectangle() {

	}

	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}

	// Upper left point:(xUpperLeft,yUpperLeft), width = <width>, height = <height>
	public String toString() {
		return "Upper left point: "+upperLeft+", width = "+width+", height = "+height;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			return upperLeft.equals(temp.upperLeft) && width == temp.width && height == temp.height;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return (upperLeft.getX() < x && x < upperLeft.getX() + width && upperLeft.getY() < y
				&& y < upperLeft.getY() + height);
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	public int area() {
		return width * height;
	}
	
	public int volume() {
		return 2 * width + 2 * height;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
