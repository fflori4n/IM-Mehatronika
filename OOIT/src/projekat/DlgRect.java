package projekat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

public class DlgRect extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean applyChange = false;					// flag if OK is pressed when form exit
	private JTextField upperLeftX;
	private JTextField upperLeftY;
	private JTextField width;
	private JTextField heigth;
	
	public JTextField getUpperLeftX() {
		return upperLeftX;
	}
	public void setUpperLeftX(JTextField upperLeftX) {
		this.upperLeftX = upperLeftX;
	}
	public JTextField getUpperLeftY() {
		return upperLeftY;
	}
	public void setUpperLeftY(JTextField upperLeftY) {
		this.upperLeftY = upperLeftY;
	}
	public JTextField getTxtWidth() {
		return width;
	}
	public void setTxtWidth(JTextField width) {
		this.width = width;
	}
	public JTextField getTxtHeigth() {
		return heigth;
	}
	public void setTxtHeigth(JTextField heigth) {
		this.heigth = heigth;
	}
	
	
	
	public boolean isApplyChange() {
		return this.applyChange;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRect dialog = new DlgRect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRect() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Upper left Point X");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			upperLeftX = new JTextField();
			GridBagConstraints gbc_upperLeftX = new GridBagConstraints();
			gbc_upperLeftX.insets = new Insets(0, 0, 5, 5);
			gbc_upperLeftX.fill = GridBagConstraints.HORIZONTAL;
			gbc_upperLeftX.gridx = 1;
			gbc_upperLeftX.gridy = 0;
			contentPanel.add(upperLeftX, gbc_upperLeftX);
			upperLeftX.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Upper left Point Y");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			upperLeftY = new JTextField();
			GridBagConstraints gbc_upperLeftY = new GridBagConstraints();
			gbc_upperLeftY.insets = new Insets(0, 0, 5, 5);
			gbc_upperLeftY.fill = GridBagConstraints.HORIZONTAL;
			gbc_upperLeftY.gridx = 1;
			gbc_upperLeftY.gridy = 1;
			contentPanel.add(upperLeftY, gbc_upperLeftY);
			upperLeftY.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Width");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			width = new JTextField();
			GridBagConstraints gbc_width = new GridBagConstraints();
			gbc_width.insets = new Insets(0, 0, 5, 5);
			gbc_width.fill = GridBagConstraints.HORIZONTAL;
			gbc_width.gridx = 1;
			gbc_width.gridy = 2;
			contentPanel.add(width, gbc_width);
			width.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Heigth");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			heigth = new JTextField();
			GridBagConstraints gbc_heigth = new GridBagConstraints();
			gbc_heigth.insets = new Insets(0, 0, 0, 5);
			gbc_heigth.fill = GridBagConstraints.HORIZONTAL;
			gbc_heigth.gridx = 1;
			gbc_heigth.gridy = 3;
			contentPanel.add(heigth, gbc_heigth);
			heigth.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (upperLeftX.getText().trim().isEmpty() || upperLeftY.getText().trim().isEmpty() || width.getText().trim().isEmpty() || heigth.getText().trim().isEmpty()) {
							dispose();
							// TODO: notify user
							System.out.println("textbox can't be blank");
						}	
						applyChange = true;
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
