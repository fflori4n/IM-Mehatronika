package projekat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgUniversal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtPointX;
	public JTextField txtPointY;
	public JTextField txtWidth;
	public JTextField txtHeight;
	public JTextField txtRadiusOuter;
	public JTextField txtInnerRadius;
	public JTextField txtEndX;
	public JTextField txtEndY;
	public Color shapeColor;
	public Color defaultColor;
	
	public boolean OKpressed = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUniversal dialog = new DlgUniversal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUniversal() {
		setModal(true);
		setBounds(100, 100, 463, 338);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblObjType = new JLabel("object type");
		lblObjType.setBounds(10, 11, 89, 14);
		contentPanel.add(lblObjType);
		
		JLabel lblNewLabel = new JLabel("Point x/y");
		lblNewLabel.setBounds(10, 33, 46, 14);
		contentPanel.add(lblNewLabel);
		
		txtPointX = new JTextField();
		txtPointX.setBounds(86, 30, 86, 20);
		contentPanel.add(txtPointX);
		txtPointX.setColumns(10);
		
		txtPointY = new JTextField();
		txtPointY.setBounds(182, 30, 86, 20);
		contentPanel.add(txtPointY);
		txtPointY.setColumns(10);
		
		JLabel lblWidth = new JLabel("Width");
		lblWidth.setBounds(10, 86, 46, 14);
		contentPanel.add(lblWidth);
		
		txtWidth = new JTextField();
		txtWidth.setEnabled(false);
		txtWidth.setBounds(86, 83, 86, 20);
		contentPanel.add(txtWidth);
		txtWidth.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(10, 110, 46, 14);
		contentPanel.add(lblHeight);
		
		txtHeight = new JTextField();
		txtHeight.setEnabled(false);
		txtHeight.setBounds(86, 107, 86, 20);
		contentPanel.add(txtHeight);
		txtHeight.setColumns(10);
		
		txtRadiusOuter = new JTextField();
		txtRadiusOuter.setEnabled(false);
		txtRadiusOuter.setBounds(86, 131, 86, 20);
		contentPanel.add(txtRadiusOuter);
		txtRadiusOuter.setColumns(10);
		
		JLabel lblRadius = new JLabel("Outer Radius");
		lblRadius.setBounds(10, 134, 89, 14);
		contentPanel.add(lblRadius);
		
		txtInnerRadius = new JTextField();
		txtInnerRadius.setEnabled(false);
		txtInnerRadius.setBounds(86, 156, 86, 20);
		contentPanel.add(txtInnerRadius);
		txtInnerRadius.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Inner Radius");
		lblNewLabel_1.setBounds(9, 159, 78, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("End Point x/y");
		lblNewLabel_2.setBounds(10, 58, 77, 14);
		contentPanel.add(lblNewLabel_2);
		
		txtEndX = new JTextField();
		txtEndX.setEnabled(false);
		txtEndX.setBounds(86, 55, 86, 20);
		contentPanel.add(txtEndX);
		txtEndX.setColumns(10);
		
		txtEndY = new JTextField();
		txtEndY.setEnabled(false);
		txtEndY.setBounds(182, 55, 86, 20);
		contentPanel.add(txtEndY);
		txtEndY.setColumns(10);
		
		JButton btnChoseColor = new JButton("color");
		btnChoseColor.setBackground(defaultColor);
		btnChoseColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        Color newcolor = JColorChooser.showDialog(null, "Change Button Background",defaultColor);
			        if (newcolor == null) {
			        	System.out.println("[  Wr  ]: color not changed!");
			        	if(defaultColor == null && shapeColor == null) {
			        		shapeColor = Color.black;
			        	}
			        	return;
			        }
			        btnChoseColor.setBackground(newcolor);
			        shapeColor = newcolor; 
			
			}
		});
		btnChoseColor.setBounds(83, 183, 89, 23);
		contentPanel.add(btnChoseColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtPointX.getText().strip().isEmpty() || txtPointY.getText().strip().isEmpty()) {
							System.out.println("[  Er  ]: Point can't be NULL!");
							return;
						}
						try {
							if((0 > Integer.parseInt(txtPointX.getText())) || (0 > Integer.parseInt(txtPointY.getText()))){
								System.out.println("[  Er  ]: Point can't be negative!");
								return;
							}
						}catch(Exception ex){
							System.out.println("[  Er  ]: Start x or y conversion failed!");
							return;
						}
						
						if(txtWidth.isEnabled() || txtHeight.isEnabled()) {
							if(txtWidth.getText().strip().isEmpty() || txtHeight.getText().strip().isEmpty()) {
								System.out.println("[  Er  ]: Width or Hight can't be NULL!");
								return;
							}
							try {
								if((0 > Integer.parseInt(txtWidth.getText())) || (0 > Integer.parseInt(txtHeight.getText()))){
									System.out.println("[  Er  ]: Width and Height can't be negative!");
									return;
								}
							}catch(Exception ex){
								System.out.println("[  Er  ]: Width or Height conversion failed!");
								return;
							}
						}
						
						if(txtEndX.isEnabled() || txtEndY.isEnabled()) {
							if(txtEndX.getText().strip().isEmpty() || txtEndY.getText().strip().isEmpty()) {
								System.out.println("[  Er  ]: End x or y can't be NULL!");
								return;
							}
							try {
								if((0 > Integer.parseInt(txtEndX.getText())) || (0 > Integer.parseInt(txtEndY.getText()))){
									System.out.println("[  Er  ]: End x or y can't be negative!");
									return;
								}
							}catch(Exception ex){
								System.out.println("[  Er  ]: End x or y conversion failed!");
								return;
							}
						}
						
						if(txtRadiusOuter.isEnabled()) {
							if(txtRadiusOuter.getText().strip().isEmpty()) {
								System.out.println("[  Er  ]: Outer radius can't be NULL!");
								return;
							}
							try {
								if((0 > Integer.parseInt(txtRadiusOuter.getText()))){
									System.out.println("[  Er  ]: Outer radius can't be negative!");
									return;
								}
							}catch(Exception ex){
								System.out.println("[  Er  ]: Outer radius conversion failed!");
								return;
							}
						}
						if(txtInnerRadius.isEnabled()) {
							if(txtInnerRadius.getText().strip().isEmpty()) {
								System.out.println("[  Er  ]: Inner radius can't be NULL!");
								return;
							}
							try {
								if((0 > Integer.parseInt(txtInnerRadius.getText()))){
									System.out.println("[  Er  ]: Inner radius can't be negative!");
									return;
								}
								if(Integer.parseInt(txtInnerRadius.getText()) >= Integer.parseInt(txtRadiusOuter.getText())) {
									System.out.println("[  Er  ]: Inner radius can't be greater than outer radius!");
									return;
								}
							}catch(Exception ex){
								System.out.println("[  Er  ]: Inner radius conversion failed!");
								return;
							}
						}
						OKpressed = true;
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
	}
}
