package projekat;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class PnlDrawing extends  JPanel {
	
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	private ArrayList<Shape> found = new ArrayList<Shape>();
	
	private String drawMode = "SEL";
	/* POI - Point
	 * LNE - Line
	 * RCT - Rectangle
	 * CRC - Circle
	 * NUT - Doughnut
	 * 
	 * SEl - Select
	 * MOD - Modify
	 * REM - Remove
	*/
	public void setDrawMode(String drw) {
		drawMode = drw;
	}
	public String getDrawMode() {
		return drawMode;
	}
	public int getIndexOf(Shape obj) {
		return shapeList.indexOf(obj);
	}
	public void removeIndex(int i, Graphics g) {
		try {
		shapeList.remove(i);
		}
		catch(Exception ex) {
			//Pass
		}
		super.paintComponent(g);
		this.update(g);
	}
	public void removeSelected(Graphics g) {
		Iterator<Shape> it = shapeList.iterator();
		while(it.hasNext()) {
			Shape temp = it.next();
			if(temp.isSelected()) {
				found.add(temp);
				System.out.println("removing " + temp);
			}
		}
		shapeList.removeAll(found);
		found.clear();
		System.out.println("clear completed");
		super.paintComponent(g);
		this.update(g);
	}
	public void add2shapes(Shape newelement) {
		shapeList.add(0, newelement);
	}
	public Shape getFromShapes(int index) {
		return shapeList.get(index);
	}
	public void paint(Graphics g) {
		// TODO: clear drawing area
		Iterator<Shape> it = shapeList.iterator();
		while(it.hasNext()) {
			Shape temp = it.next();
			temp.draw(g);
			System.out.println(temp);
		}
	}
	public void select(int x, int y,Graphics g) {
		Iterator<Shape> it = shapeList.iterator();
		while(it.hasNext()) {
			Shape temp = it.next();
			if(temp.contains(x, y)) {
				temp.setSelected(true);
				break;
			}
			System.out.println(temp);
		}
	}
	public void deselectAll(Graphics g) {
		Iterator<Shape> it = shapeList.iterator();
		while(it.hasNext()) {
			Shape temp = it.next();
			if(temp.isSelected()) {
				temp.setSelected(false);
				//break;
			}
		}
		super.paintComponent(g);
		this.update(g);
		//Collections.reverse(shapeList);
	}
	public Shape getSelected() {
		Iterator<Shape> it = shapeList.iterator();
		while(it.hasNext()) {
			Shape temp = it.next();
			if(temp.isSelected()) {
				return temp;
			}
		}
		return null;
	}
	public void update(Graphics g) {
		this.paint(g);
	} 
	/*public static void main(String[] args) {
		PnlDrawing drawing = new PnlDrawing();
		drawing.setBackground(Color.WHITE);
	}*/

}
