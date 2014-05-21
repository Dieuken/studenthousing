package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class zoekStudio extends JFrame {

	private JPanel contentPane;
	private JLabel lblZoekOp;
	private JRadioButton rdbtnStudioId;
	private JRadioButton rdbtnOppervlakte;
	private JRadioButton rdbtnInrichting;
	private JRadioButton rdbtnHuurprijs;
	private JCheckBox chckbxGebouw;
	private JCheckBox chckbxLeeg;
	private JTextField textField;
	private JComboBox cmbGebouwen;
	private JButton btnSearch;

	
	public zoekStudio() {
		setTitle("Studio zoeken...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblZoekIn = new JLabel("Zoek in:");
		GridBagConstraints gbc_lblZoekIn = new GridBagConstraints();
		gbc_lblZoekIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblZoekIn.anchor = GridBagConstraints.EAST;
		gbc_lblZoekIn.gridx = 0;
		gbc_lblZoekIn.gridy = 0;
		contentPane.add(lblZoekIn, gbc_lblZoekIn);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblZoekOp = new JLabel("Zoek op:");
		GridBagConstraints gbc_lblZoekOp = new GridBagConstraints();
		gbc_lblZoekOp.insets = new Insets(0, 0, 5, 5);
		gbc_lblZoekOp.gridx = 0;
		gbc_lblZoekOp.gridy = 1;
		contentPane.add(lblZoekOp, gbc_lblZoekOp);
		
		rdbtnStudioId = new JRadioButton("Studio ID");
		GridBagConstraints gbc_rdbtnStudioId = new GridBagConstraints();
		gbc_rdbtnStudioId.anchor = GridBagConstraints.WEST;
		gbc_rdbtnStudioId.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStudioId.gridx = 1;
		gbc_rdbtnStudioId.gridy = 2;
		contentPane.add(rdbtnStudioId, gbc_rdbtnStudioId);
		
		rdbtnOppervlakte = new JRadioButton("Oppervlakte");
		GridBagConstraints gbc_rdbtnOppervlakte = new GridBagConstraints();
		gbc_rdbtnOppervlakte.anchor = GridBagConstraints.WEST;
		gbc_rdbtnOppervlakte.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOppervlakte.gridx = 2;
		gbc_rdbtnOppervlakte.gridy = 2;
		contentPane.add(rdbtnOppervlakte, gbc_rdbtnOppervlakte);
		
		rdbtnInrichting = new JRadioButton("Inrichting");
		GridBagConstraints gbc_rdbtnInrichting = new GridBagConstraints();
		gbc_rdbtnInrichting.anchor = GridBagConstraints.WEST;
		gbc_rdbtnInrichting.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnInrichting.gridx = 3;
		gbc_rdbtnInrichting.gridy = 2;
		contentPane.add(rdbtnInrichting, gbc_rdbtnInrichting);
		
		rdbtnHuurprijs = new JRadioButton("Huurprijs");
		GridBagConstraints gbc_rdbtnHuurprijs = new GridBagConstraints();
		gbc_rdbtnHuurprijs.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHuurprijs.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHuurprijs.gridx = 1;
		gbc_rdbtnHuurprijs.gridy = 3;
		contentPane.add(rdbtnHuurprijs, gbc_rdbtnHuurprijs);
		
		chckbxGebouw = new JCheckBox("Gebouw");
		GridBagConstraints gbc_chckbxGebouw = new GridBagConstraints();
		gbc_chckbxGebouw.anchor = GridBagConstraints.WEST;
		gbc_chckbxGebouw.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGebouw.gridx = 2;
		gbc_chckbxGebouw.gridy = 3;
		contentPane.add(chckbxGebouw, gbc_chckbxGebouw);
		
		chckbxLeeg = new JCheckBox("Leeg");
		GridBagConstraints gbc_chckbxLeeg = new GridBagConstraints();
		gbc_chckbxLeeg.anchor = GridBagConstraints.WEST;
		gbc_chckbxLeeg.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxLeeg.gridx = 3;
		gbc_chckbxLeeg.gridy = 3;
		contentPane.add(chckbxLeeg, gbc_chckbxLeeg);
		
		cmbGebouwen = new JComboBox();
		GridBagConstraints gbc_cmbGebouwen = new GridBagConstraints();
		gbc_cmbGebouwen.insets = new Insets(0, 0, 5, 0);
		gbc_cmbGebouwen.gridwidth = 3;
		gbc_cmbGebouwen.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbGebouwen.gridx = 1;
		gbc_cmbGebouwen.gridy = 4;
		contentPane.add(cmbGebouwen, gbc_cmbGebouwen);
		
		btnSearch = new JButton("SEARCH");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 5;
		contentPane.add(btnSearch, gbc_btnSearch);
	}

}
