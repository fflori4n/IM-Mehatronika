package linija;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLin extends JFrame {

	private JPanel contentPane;
	DefaultListModel<Line> dlm = new DefaultListModel<Line>();
	
	JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLin frame = new FrmLin();
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
	public FrmLin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgLin dlg = new DlgLin();
				dlg.setVisible(true);
				
				if (dlg.isOk) {
					Line l1 = new Line(new Point(Integer.parseInt(dlg.getTxtStartX().getText().toString()), Integer.parseInt(dlg.getTxtStartY().getText().toString())), 
							new Point(Integer.parseInt(dlg.getTxtEndX().getText().toString()), Integer.parseInt(dlg.getTxtEndY().getText().toString())));
					
					dlm.addElement(l1);
				}
			}
		});
		pnlJug.add(btnDodaj);
		
		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Nije selektovan ni jedan red!", 
							"Greška", 
							JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println(dlm.elementAt(list.getSelectedIndex()).toString());
					 
					//String[] split = dlm.elementAt(list.getSelectedIndex()).toString().split("[\\W]");
					
					Line temp = dlm.elementAt(list.getSelectedIndex());
					
					DlgLin dlg = new DlgLin();
					/*dlg.getTxtStartX().setText(split[1]);
					dlg.getTxtStartY().setText(split[3]);
					dlg.getTxtEndX().setText(split[8]);
					dlg.getTxtEndY().setText(split[10]);*/
					
					dlg.getTxtStartX().setText(Integer.toString(temp.getStartPoint().getX()));
					dlg.getTxtStartY().setText(Integer.toString(temp.getStartPoint().getY()));
					dlg.getTxtEndX().setText(Integer.toString(temp.getEndPoint().getX()));
					dlg.getTxtEndY().setText(Integer.toString(temp.getEndPoint().getY()));
					
					dlg.setVisible(true);
					
					if (dlg.isOk) {
						dlm.removeElementAt(list.getSelectedIndex());
						Line l1 = new Line(new Point(Integer.parseInt(dlg.getTxtStartX().getText().toString()), Integer.parseInt(dlg.getTxtStartY().getText().toString())), 
								new Point(Integer.parseInt(dlg.getTxtEndX().getText().toString()), Integer.parseInt(dlg.getTxtEndY().getText().toString())));
						
						dlm.addElement(l1);
					}
				}
			}
		});
		pnlJug.add(btnModifikuj);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.clear();
			}
		});
		pnlJug.add(btnObrisi);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}

}
