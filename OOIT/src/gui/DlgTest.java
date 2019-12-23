package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTest extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIme;
	private JTextField txtPrezime;
	
	boolean isOk;

	public JTextField getTxtIme() {
		return txtIme;
	}

	public void setTxtIme(JTextField txtIme) {
		this.txtIme = txtIme;
	}

	public JTextField getTxtPrezime() {
		return txtPrezime;
	}

	public void setTxtPrezime(JTextField txtPrezime) {
		this.txtPrezime = txtPrezime;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTest dialog = new DlgTest();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTest() {
		setModal(true);
		setBounds(100, 100, 446, 175);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblIme = new JLabel("Ime");
			contentPanel.add(lblIme);
		}
		{
			txtIme = new JTextField();
			txtIme.setText("Ime");
			contentPanel.add(txtIme);
			txtIme.setColumns(10);
		}
		{
			JLabel lblPrezime = new JLabel("Prezime");
			contentPanel.add(lblPrezime);
		}
		{
			txtPrezime = new JTextField();
			txtPrezime.setText("Prezime");
			contentPanel.add(txtPrezime);
			txtPrezime.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOk = true;
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
