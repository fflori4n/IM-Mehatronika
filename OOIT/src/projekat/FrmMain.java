package projekat;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import geometry.Circle;
import geometry.Donut;
import geometry.Drawing;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import projekat.PnlDrawing;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;

public class FrmMain {

	private JFrame frmPoorMansPaint;
	public PnlDrawing drawing = new PnlDrawing();
	private String drawModeDisp = "SEL";
	public Color defaultColor = Color.DARK_GRAY;
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
	private ArrayList<Point> otherClicks = new ArrayList();
	JCheckBox chckbxPreciseMode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain window = new FrmMain();
					window.frmPoorMansPaint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPoorMansPaint = new JFrame();
		frmPoorMansPaint.getContentPane().setForeground(Color.WHITE);
		//frmPoorMansPaint.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmPoorMansPaint.setTitle("MH59/2017 Drawing");
		frmPoorMansPaint.setBounds(100, 100, 690, 427);
		frmPoorMansPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmPoorMansPaint.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewPoint = new JButton("point");
		btnNewPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing.setDrawMode("POI");
			}
		});
		GridBagConstraints gbc_btnNewPoint = new GridBagConstraints();
		gbc_btnNewPoint.fill = GridBagConstraints.BOTH;
		gbc_btnNewPoint.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewPoint.gridx = 0;
		gbc_btnNewPoint.gridy = 1;
		frmPoorMansPaint.getContentPane().add(btnNewPoint, gbc_btnNewPoint);
		
		//PnlDrawing drawing = new PnlDrawing();
		//drawing.setBackground(Color.WHITE);
		GridBagConstraints gbc_drawing = new GridBagConstraints();
		gbc_drawing.gridwidth = 5;
		gbc_drawing.gridheight = 12;
		gbc_drawing.fill = GridBagConstraints.BOTH;
		gbc_drawing.gridx = 1;
		gbc_drawing.gridy = 1;
		// FROM: https://stackoverflow.com/questions/12396066/how-to-get-location-of-a-mouse-click-relative-to-a-swing-window
		drawing.addMouseListener(new MouseListener() {	// add listener to 'drawing' -- coordinates are relative to drawing
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	Graphics g = drawing.getGraphics();
		    	 int x=e.getX();
		    	 int y=e.getY();
		    	// System.out.println(x+","+y);//these co-ords are relative to the component
		    	 
		    	 if (e.getModifiers() == MouseEvent.BUTTON3_MASK && e.getClickCount() == 1) {
		             System.out.print("right click!");
		             drawing.deselectAll(g);
		         }
		    	 
		    	 if(!(drawing.getDrawMode().contentEquals("SEL") || drawing.getDrawMode().contentEquals("MOD") || drawing.getDrawMode().contentEquals("REM"))) {
		    	if(chckbxPreciseMode.isSelected()) {
		    	 
		    	 DlgUniversal addShape = new DlgUniversal();
		    	 addShape.txtPointX.setText(Integer.toString(x));
		    	 addShape.txtPointY.setText(Integer.toString(y));
		    	 addShape.defaultColor = defaultColor;
		    	 addShape.shapeColor = defaultColor;
		    	 if(drawing.getDrawMode().contentEquals("POI")) {
		    	 }
		    	 else if(drawing.getDrawMode().contentEquals("LNE")) {
		    		 addShape.txtEndX.enable();
		    		 addShape.txtEndY.enable();
		    	 }else if(drawing.getDrawMode().contentEquals("REC")) {
		    		 addShape.txtHeight.enable();
		    		 addShape.txtWidth.enable();
		    	 }else if(drawing.getDrawMode().contentEquals("CRC")) {
		    		 addShape.txtRadiusOuter.enable();
		    	 }else if(drawing.getDrawMode().contentEquals("NUT")) {
		    		 addShape.txtInnerRadius.enable();
		    		 addShape.txtRadiusOuter.enable();
		    	 }
				 addShape.setVisible(true);
				 
				 if(!addShape.OKpressed) {
					 return;
				 }
				 Point newPoint = new Point(Integer.parseInt(addShape.txtPointX.getText()),Integer.parseInt(addShape.txtPointY.getText()));
				 if(drawing.getDrawMode().contentEquals("POI")) {
					 drawing.add2shapes(new Point(Integer.parseInt(addShape.txtPointX.getText()),Integer.parseInt(addShape.txtPointY.getText()),addShape.shapeColor));
		    	 }else if(drawing.getDrawMode().contentEquals("LNE")) {
		    		 drawing.add2shapes(new Line(newPoint,new Point(Integer.parseInt(addShape.txtEndX.getText()),Integer.parseInt(addShape.txtEndY.getText())),addShape.shapeColor));
		    	 }else if(drawing.getDrawMode().contentEquals("REC")) {
		    		 drawing.add2shapes(new Rectangle(newPoint,Integer.parseInt(addShape.txtWidth.getText()),Integer.parseInt(addShape.txtHeight.getText()),addShape.shapeColor));
		    	 }else if(drawing.getDrawMode().contentEquals("CRC")) {
		    		 drawing.add2shapes(new Circle(newPoint,Integer.parseInt(addShape.txtRadiusOuter.getText()),addShape.shapeColor));
		    	 }else if(drawing.getDrawMode().contentEquals("NUT")) {
		    		 drawing.add2shapes(new Donut(newPoint,Integer.parseInt(addShape.txtRadiusOuter.getText()),Integer.parseInt(addShape.txtInnerRadius.getText()),addShape.shapeColor));
		    	 }
				 
		    	}
		    	else {
		    	 if(drawing.getDrawMode().contentEquals("POI")) {
		    		 System.out.println("[  OK  ]creating new point");
		    		 drawing.add2shapes(new Point(x,y,defaultColor));
		    	 }else if(drawing.getDrawMode().contentEquals("LNE")) {
		    		 otherClicks.add(new Point(x,y));
		    		 if(otherClicks.size() >= 2) {
		    			 drawing.add2shapes(new Line(otherClicks.get(0),otherClicks.get(1),defaultColor));
		    			 otherClicks.clear();
		    		 }
		    	 }else if(drawing.getDrawMode().contentEquals("REC")) {
		    		 otherClicks.add(new Point(x,y));
		    		 if(otherClicks.size() >= 2) {
		    			 int width = (otherClicks.get(1).getX() - otherClicks.get(0).getX());
		    			 drawing.add2shapes(new Rectangle(otherClicks.get(0),width,(otherClicks.get(1).getY() - otherClicks.get(0).getY()),defaultColor));
		    			 otherClicks.clear();
		    		 }
		    	 }
		    	 else if(drawing.getDrawMode().contentEquals("CRC")) {
		    		 otherClicks.add(new Point(x,y));
		    		 if(otherClicks.size() >= 2) {
		    			 int r =(int) otherClicks.get(0).distance(otherClicks.get(1).getX(),otherClicks.get(1).getY());
		    			 drawing.add2shapes(new Circle(otherClicks.get(0),r,defaultColor));
		    			 otherClicks.clear();
		    		 }
		    	 }
		    	 else if(drawing.getDrawMode().contentEquals("NUT")) {
		    		 otherClicks.add(new Point(x,y));
		    		 if(otherClicks.size() >= 3) {
		    			 int r =(int) otherClicks.get(0).distance(otherClicks.get(1).getX(),otherClicks.get(1).getY());
		    			 int R =(int) otherClicks.get(0).distance(otherClicks.get(2).getX(),otherClicks.get(2).getY());
		    			 drawing.add2shapes(new Donut(otherClicks.get(0),R,r,defaultColor));
		    			 otherClicks.clear();
		    		 }
		    	 }
		    	}
		    	}
		    	 if(drawing.getDrawMode().contentEquals("SEL")) {
		    		 drawing.select(x,y,g);
		    	 }
		    	 drawing.update(g);
		    }
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		frmPoorMansPaint.getContentPane().add(drawing, gbc_drawing);
		
		JButton btnNewLine = new JButton(" line ");
		btnNewLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing.setDrawMode("LNE");
			}
		});
		GridBagConstraints gbc_btnNewLine = new GridBagConstraints();
		gbc_btnNewLine.fill = GridBagConstraints.BOTH;
		gbc_btnNewLine.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewLine.gridx = 0;
		gbc_btnNewLine.gridy = 2;
		frmPoorMansPaint.getContentPane().add(btnNewLine, gbc_btnNewLine);
		
		JButton btnNewRectangle = new JButton("rectangle");
		btnNewRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing.setDrawMode("REC");
			}
		});
		GridBagConstraints gbc_btnNewRectangle = new GridBagConstraints();
		gbc_btnNewRectangle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewRectangle.gridx = 0;
		gbc_btnNewRectangle.gridy = 3;
		frmPoorMansPaint.getContentPane().add(btnNewRectangle, gbc_btnNewRectangle);
		
		JButton btnNewCircle = new JButton("circle");
		btnNewCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing.setDrawMode("CRC");
			}
		});
		GridBagConstraints gbc_btnNewCircle = new GridBagConstraints();
		gbc_btnNewCircle.fill = GridBagConstraints.BOTH;
		gbc_btnNewCircle.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewCircle.gridx = 0;
		gbc_btnNewCircle.gridy = 4;
		frmPoorMansPaint.getContentPane().add(btnNewCircle, gbc_btnNewCircle);
		
		JButton btnNewDoughnut = new JButton("doughnut");
		btnNewDoughnut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing.setDrawMode("NUT");
			}
		});
		GridBagConstraints gbc_btnNewDoughnut = new GridBagConstraints();
		gbc_btnNewDoughnut.fill = GridBagConstraints.BOTH;
		gbc_btnNewDoughnut.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewDoughnut.gridx = 0;
		gbc_btnNewDoughnut.gridy = 5;
		frmPoorMansPaint.getContentPane().add(btnNewDoughnut, gbc_btnNewDoughnut);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridheight = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 6;
		frmPoorMansPaint.getContentPane().add(separator, gbc_separator);
		
		JButton btnSelect = new JButton("select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing.setDrawMode("SEL");
			}
		});
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.BOTH;
		gbc_btnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelect.gridx = 0;
		gbc_btnSelect.gridy = 7;
		frmPoorMansPaint.getContentPane().add(btnSelect, gbc_btnSelect);
		
		JButton btnModify = new JButton("modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing.setDrawMode("MOD");
				Shape shapeToModif = drawing.getSelected();
				drawing.setDrawMode("SEL");
				if(shapeToModif == null) {
					System.out.print("[  Wr  ]: no item selected!");
					return;
				}
				Graphics g = drawing.getGraphics();
				DlgUniversal addShape = new DlgUniversal();
				
				if(shapeToModif instanceof Point) {
			    	 addShape.txtPointX.setText(Integer.toString(((Point) shapeToModif).getX()));
			    	 addShape.txtPointY.setText(Integer.toString(((Point) shapeToModif).getY()));	
			    	 drawing.setDrawMode("POI");
				}
				else if(shapeToModif instanceof Line) {
					addShape.txtPointX.setText(Integer.toString((((Line) shapeToModif).getStartPoint().getX())));
			    	addShape.txtPointY.setText(Integer.toString((((Line) shapeToModif).getStartPoint().getY())));
			    	addShape.txtEndX.setText(Integer.toString((((Line) shapeToModif).getEndPoint().getX())));
			    	addShape.txtEndY.setText(Integer.toString(((Line) shapeToModif).getEndPoint().getY()));
			    	addShape.txtEndX.enable();
			    	addShape.txtEndY.enable();
			    	drawing.setDrawMode("LNE");
				}
				else if(shapeToModif instanceof Rectangle) {
					addShape.txtPointX.setText(Integer.toString(((Rectangle) shapeToModif).getUpperLeft().getX()));
			    	addShape.txtPointY.setText(Integer.toString(((Rectangle) shapeToModif).getUpperLeft().getY()));
			    	addShape.txtWidth.setText(Integer.toString(((Rectangle) shapeToModif).getWidth()));
			    	addShape.txtHeight.setText(Integer.toString(((Rectangle) shapeToModif).getHeight()));
			    	addShape.txtWidth.enable();
			    	addShape.txtHeight.enable();
			    	drawing.setDrawMode("REC");
				}
				else if(shapeToModif instanceof Donut) {
					addShape.txtPointX.setText(Integer.toString(((Donut) shapeToModif).getCenter().getX()));
			    	addShape.txtPointY.setText(Integer.toString(((Donut) shapeToModif).getCenter().getY()));
			    	addShape.txtRadiusOuter.setText(Integer.toString(((Donut) shapeToModif).getR()));
			    	addShape.txtInnerRadius.setText(Integer.toString(((Donut) shapeToModif).getInnerR()));
			    	addShape.txtRadiusOuter.enable();
			    	addShape.txtInnerRadius.enable();
			    	drawing.setDrawMode("NUT");
					
				}else if(shapeToModif instanceof Circle) {
					addShape.txtPointX.setText(Integer.toString(((Circle) shapeToModif).getCenter().getX()));
			    	addShape.txtPointY.setText(Integer.toString(((Circle) shapeToModif).getCenter().getY()));
			    	addShape.txtRadiusOuter.setText(Integer.toString(((Circle) shapeToModif).getR()));
			    	addShape.txtRadiusOuter.enable();
			    	drawing.setDrawMode("CRC");
					
				}
				addShape.defaultColor = shapeToModif.getColor();
				addShape.shapeColor = shapeToModif.getColor();
				addShape.setVisible(true);
				
				if(!addShape.OKpressed) {
					 return;
				}
				try {
					System.out.print("color:" + addShape.shapeColor + '\n');
				 Point newPoint = new Point(Integer.parseInt(addShape.txtPointX.getText()),Integer.parseInt(addShape.txtPointY.getText()));
				 if(drawing.getDrawMode().contentEquals("POI")) {
					 drawing.add2shapes(new Point(Integer.parseInt(addShape.txtPointX.getText()),Integer.parseInt(addShape.txtPointY.getText()),addShape.shapeColor));
		    	 }else if(drawing.getDrawMode().contentEquals("LNE")) {
		    		 drawing.add2shapes(new Line(newPoint,new Point(Integer.parseInt(addShape.txtEndX.getText()),Integer.parseInt(addShape.txtEndY.getText())),addShape.shapeColor));
		    	 }else if(drawing.getDrawMode().contentEquals("REC")) {
		    		 drawing.add2shapes(new Rectangle(newPoint,Integer.parseInt(addShape.txtWidth.getText()),Integer.parseInt(addShape.txtHeight.getText()),addShape.shapeColor));
		    	 }else if(drawing.getDrawMode().contentEquals("CRC")) {
		    		 drawing.add2shapes(new Circle(newPoint,Integer.parseInt(addShape.txtRadiusOuter.getText()),addShape.shapeColor));
		    	 }else if(drawing.getDrawMode().contentEquals("NUT")) {
		    		 drawing.add2shapes(new Donut(newPoint,Integer.parseInt(addShape.txtRadiusOuter.getText()),Integer.parseInt(addShape.txtInnerRadius.getText()),addShape.shapeColor));
		    	 }
				 }catch(Exception ex){
					 System.out.print("[  Er  ]: conversion error!");
					 return;
				 }
				 drawing.printList();
				 drawing.removeIndex(drawing.getIndexOf(shapeToModif), g);
				 drawing.setDrawMode("SEL");
				 drawing.printList();
			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.fill = GridBagConstraints.BOTH;
		gbc_btnModify.insets = new Insets(0, 0, 5, 5);
		gbc_btnModify.gridx = 0;
		gbc_btnModify.gridy = 8;
		frmPoorMansPaint.getContentPane().add(btnModify, gbc_btnModify);
		
		JButton btnRemove = new JButton("remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing.setDrawMode("REM");
				Graphics g = drawing.getGraphics();
		    	//drawing.update(g);
				drawing.removeSelected(g);
				drawing.setDrawMode("SEL");
			}
		});
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.BOTH;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 9;
		frmPoorMansPaint.getContentPane().add(btnRemove, gbc_btnRemove);
		
		chckbxPreciseMode = new JCheckBox("Precise Mode");
		chckbxPreciseMode.setSelected(true);
		GridBagConstraints gbc_chckbxPreciseMode = new GridBagConstraints();
		gbc_chckbxPreciseMode.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPreciseMode.gridx = 0;
		gbc_chckbxPreciseMode.gridy = 11;
		frmPoorMansPaint.getContentPane().add(chckbxPreciseMode, gbc_chckbxPreciseMode);
		
		JButton btnDefaultColor = new JButton("Color");
		btnDefaultColor.setBackground(defaultColor);
		btnDefaultColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newcolor = JColorChooser.showDialog(null, "Change Button Background",defaultColor);
		        if (newcolor == null) {
		        	System.out.println("[  Wr  ]: color not changed");
		        	return;
		        }
		        btnDefaultColor.setBackground(newcolor);
		        defaultColor = newcolor; 
			}
		});
		GridBagConstraints gbc_btnDefaultColor = new GridBagConstraints();
		gbc_btnDefaultColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDefaultColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnDefaultColor.gridx = 0;
		gbc_btnDefaultColor.gridy = 12;
		frmPoorMansPaint.getContentPane().add(btnDefaultColor, gbc_btnDefaultColor);
		
		frmPoorMansPaint.setVisible(true);
	}

}
