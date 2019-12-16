package gui2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class FrmTest {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblBranislavIvanovic;
	private JLabel lblNemanjaMatic;
	private JLabel lblAleksandarKolarov;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JTextField txtUnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest window = new FrmTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel();
		frame.getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		JButton btnIspis = new JButton("Ispis");
		btnIspis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)");
			}
		});
		pnlJug.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlJug.add(btnIspis);
		
		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(SystemColor.activeCaption);
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlCentar.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlCentar.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCentar.setLayout(gbl_pnlCentar);
		
		JToggleButton tglbtnIvanovic = new JToggleButton("Ivanovic");
		buttonGroup.add(tglbtnIvanovic);
		tglbtnIvanovic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnIvanovic.isSelected()) {
					lblBranislavIvanovic.setForeground(Color.BLUE);
					lblNemanjaMatic.setForeground(Color.BLACK);
					lblAleksandarKolarov.setForeground(Color.BLACK);
					dlm.addElement(lblBranislavIvanovic.getText());
				}
			}
		});
		GridBagConstraints gbc_tglbtnIvanovic = new GridBagConstraints();
		gbc_tglbtnIvanovic.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnIvanovic.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnIvanovic.gridx = 2;
		gbc_tglbtnIvanovic.gridy = 1;
		pnlCentar.add(tglbtnIvanovic, gbc_tglbtnIvanovic);
		
		lblBranislavIvanovic = new JLabel("Branislav Ivanovic");
		GridBagConstraints gbc_lblBranislavIvanovic = new GridBagConstraints();
		gbc_lblBranislavIvanovic.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBranislavIvanovic.insets = new Insets(0, 0, 5, 5);
		gbc_lblBranislavIvanovic.gridx = 4;
		gbc_lblBranislavIvanovic.gridy = 1;
		pnlCentar.add(lblBranislavIvanovic, gbc_lblBranislavIvanovic);
		
		JToggleButton tglbtnMatic = new JToggleButton("Matic");
		tglbtnMatic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnMatic.isSelected()) {
					lblBranislavIvanovic.setForeground(Color.BLACK);
					lblNemanjaMatic.setForeground(Color.BLUE);
					lblAleksandarKolarov.setForeground(Color.BLACK);
					dlm.addElement(lblNemanjaMatic.getText());
				}
			}
		});
		buttonGroup.add(tglbtnMatic);
		
		JScrollPane scrlPaneIgraci = new JScrollPane();
		GridBagConstraints gbc_scrlPaneIgraci = new GridBagConstraints();
		gbc_scrlPaneIgraci.fill = GridBagConstraints.BOTH;
		gbc_scrlPaneIgraci.gridheight = 3;
		gbc_scrlPaneIgraci.insets = new Insets(0, 0, 5, 0);
		gbc_scrlPaneIgraci.gridx = 8;
		gbc_scrlPaneIgraci.gridy = 1;
		pnlCentar.add(scrlPaneIgraci, gbc_scrlPaneIgraci);
		
		JList lstIgraci = new JList();
		scrlPaneIgraci.setViewportView(lstIgraci);
		lstIgraci.setModel(dlm);
		
		GridBagConstraints gbc_tglbtnMatic = new GridBagConstraints();
		gbc_tglbtnMatic.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnMatic.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnMatic.gridx = 2;
		gbc_tglbtnMatic.gridy = 2;
		pnlCentar.add(tglbtnMatic, gbc_tglbtnMatic);
		
		JToggleButton tglbtnKolarov = new JToggleButton("Kolarov");
		tglbtnKolarov.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnKolarov.isSelected()) {
					lblBranislavIvanovic.setForeground(Color.BLACK);
					lblNemanjaMatic.setForeground(Color.BLACK);
					lblAleksandarKolarov.setForeground(Color.BLUE);
					dlm.addElement(lblAleksandarKolarov.getText());
				}
			}
		});
		buttonGroup.add(tglbtnKolarov);
		
		lblNemanjaMatic = new JLabel("Nemanja Matic");
		GridBagConstraints gbc_lblNemanjaMatic = new GridBagConstraints();
		gbc_lblNemanjaMatic.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNemanjaMatic.insets = new Insets(0, 0, 5, 5);
		gbc_lblNemanjaMatic.gridx = 4;
		gbc_lblNemanjaMatic.gridy = 2;
		pnlCentar.add(lblNemanjaMatic, gbc_lblNemanjaMatic);
		GridBagConstraints gbc_tglbtnKolarov = new GridBagConstraints();
		gbc_tglbtnKolarov.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnKolarov.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKolarov.gridx = 2;
		gbc_tglbtnKolarov.gridy = 3;
		pnlCentar.add(tglbtnKolarov, gbc_tglbtnKolarov);
		
		lblAleksandarKolarov = new JLabel("Aleksandar Kolarov");
		GridBagConstraints gbc_lblAleksandarKolarov = new GridBagConstraints();
		gbc_lblAleksandarKolarov.insets = new Insets(0, 0, 5, 5);
		gbc_lblAleksandarKolarov.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAleksandarKolarov.gridx = 4;
		gbc_lblAleksandarKolarov.gridy = 3;
		pnlCentar.add(lblAleksandarKolarov, gbc_lblAleksandarKolarov);
		
		txtUnos = new JTextField();
		txtUnos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtUnos.getText());
					txtUnos.setText("");
				}
			}
		});
		
		JCheckBox chckbxUnosIgraca = new JCheckBox("Unos igraca");
		chckbxUnosIgraca.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtUnos.setEnabled(chckbxUnosIgraca.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxUnosIgraca = new GridBagConstraints();
		gbc_chckbxUnosIgraca.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUnosIgraca.gridx = 2;
		gbc_chckbxUnosIgraca.gridy = 6;
		pnlCentar.add(chckbxUnosIgraca, gbc_chckbxUnosIgraca);
		txtUnos.setEnabled(false);
		GridBagConstraints gbc_txtUnos = new GridBagConstraints();
		gbc_txtUnos.insets = new Insets(0, 0, 5, 5);
		gbc_txtUnos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUnos.gridx = 4;
		gbc_txtUnos.gridy = 6;
		pnlCentar.add(txtUnos, gbc_txtUnos);
		txtUnos.setColumns(10);
		
		JLabel lblOstaliIgraci = new JLabel("Ostali igraci");
		GridBagConstraints gbc_lblOstaliIgraci = new GridBagConstraints();
		gbc_lblOstaliIgraci.insets = new Insets(0, 0, 0, 5);
		gbc_lblOstaliIgraci.gridx = 2;
		gbc_lblOstaliIgraci.gridy = 7;
		pnlCentar.add(lblOstaliIgraci, gbc_lblOstaliIgraci);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dusan Tadic", "Aleksandar Mitrovic", "Sergej Milinkovic Savic"}));
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 7;
		pnlCentar.add(comboBox, gbc_comboBox);
		
		JPanel pnlNaslov = new JPanel();
		contentPane.add(pnlNaslov, BorderLayout.NORTH);
		pnlNaslov.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNaslov = new JLabel("Naslov");
		pnlNaslov.add(lblNaslov);
		
	}

}
