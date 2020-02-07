package projekat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import linija.DlgLin;

import javax.swing.JSplitPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRectangle extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Rectangle> rectList = new DefaultListModel<Rectangle>();
	JList rectDispList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRectangle frame = new FrmRectangle();
					frame.setTitle("MH59/2017 Stek & Sort");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRectangle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.WEST);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setContinuousLayout(true);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Modify clicked");
				if(rectList.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Empty list: Nothing to modify!", 
							"Error", 
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				//System.out.println(rectList.elementAt(0).toString());
				//int selectedIndex = rectDispList.getSelectedIndex();
				Rectangle temp = rectList.elementAt(0);
				
				DlgRect rectDialog = new DlgRect();
					
				rectDialog.getUpperLeftX().setText(Integer.toString(temp.getUpperLeft().getX()));
				rectDialog.getUpperLeftY().setText(Integer.toString(temp.getUpperLeft().getY()));
				rectDialog.getTxtHeigth().setText(Integer.toString(temp.getHeight()));
				rectDialog.getTxtWidth().setText(Integer.toString(temp.getWidth()));
					
				rectDialog.setVisible(true);
					
				if(rectDialog.isApplyChange()) {
					// read values from textbox and create new rect
					Rectangle newRect = new Rectangle(new Point(Integer.parseInt(rectDialog.getUpperLeftX().getText()),Integer.parseInt(rectDialog.getUpperLeftY().getText())),Integer.parseInt(rectDialog.getTxtWidth().getText()),Integer.parseInt(rectDialog.getTxtHeigth().getText()));
					rectList.add(0, newRect);
					rectList.remove(1);
				}
			}
		});
		splitPane_1.setLeftComponent(btnModify);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_2);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rectList.clear();
			}
		});
		splitPane_2.setLeftComponent(btnClear);
		
		JButton btnSort = new JButton("sort by area");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("sort clicked");
				int listLength = rectList.getSize();
				for(int i=0; i<(listLength-1);i++) {
					for(int j=0; j<(listLength - 1 - i); j++) {
						if(rectList.getElementAt(j).area() > rectList.getElementAt(j+1).getArea()) {
							Rectangle temp = rectList.getElementAt(j);
							rectList.add(j, rectList.get(j+1));
							rectList.remove(j+1);
							rectList.add(j+1, temp);
							rectList.remove(j+2);
						}
					}
				}
			}
		});
		splitPane_2.setRightComponent(btnSort);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Add clicked");
				DlgRect rectDialog = new DlgRect();
				rectDialog.setVisible(true);
				
				if(rectDialog.isApplyChange()) {
					// read values from textbox and create new rect
					Rectangle newRect = new Rectangle(new Point(Integer.parseInt(rectDialog.getUpperLeftX().getText()),Integer.parseInt(rectDialog.getUpperLeftY().getText())),Integer.parseInt(rectDialog.getTxtWidth().getText()),Integer.parseInt(rectDialog.getTxtHeigth().getText()));
					rectList.add(0, newRect);
				}
				rectDialog.dispose();
				
			}
		});
		splitPane.setLeftComponent(btnAdd);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
	
		
		rectDispList = new JList();
		scrollPane.setViewportView(rectDispList);	// display elements of rectDispList
		rectDispList.setModel(rectList);
	}

}
