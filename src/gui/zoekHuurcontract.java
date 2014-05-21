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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class zoekHuurcontract extends JFrame {

	private JPanel contentPane;
	private JTextField txtZoeken;
	private JRadioButton rdbtnContractId;
	private JRadioButton rdbtnBegindatum;
	private JRadioButton rdbtnEinddatum;
	private JRadioButton rdbtnHuurprijs;
	private JRadioButton rdbtnWaarborg;
	private JCheckBox chckbxStudio;
	private JCheckBox chckbxStudent;
	private JCheckBox chckbxGebouw;
	private JComboBox cbxStudio;
	private JComboBox cbxStudent;
	private JComboBox cbxGebouw;
	private JButton btnSearch;

	
	public zoekHuurcontract() {
		setTitle("Huurcontract zoeken...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblZoekenOp = new JLabel("Zoeken op:");
		GridBagConstraints gbc_lblZoekenOp = new GridBagConstraints();
		gbc_lblZoekenOp.insets = new Insets(0, 0, 5, 5);
		gbc_lblZoekenOp.anchor = GridBagConstraints.EAST;
		gbc_lblZoekenOp.gridx = 0;
		gbc_lblZoekenOp.gridy = 0;
		contentPane.add(lblZoekenOp, gbc_lblZoekenOp);
		
		txtZoeken = new JTextField();
		GridBagConstraints gbc_txtZoeken = new GridBagConstraints();
		gbc_txtZoeken.gridwidth = 3;
		gbc_txtZoeken.insets = new Insets(0, 0, 5, 0);
		gbc_txtZoeken.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtZoeken.gridx = 1;
		gbc_txtZoeken.gridy = 0;
		contentPane.add(txtZoeken, gbc_txtZoeken);
		txtZoeken.setColumns(10);
		
		JLabel lblZoekenIn = new JLabel("Zoeken in:");
		GridBagConstraints gbc_lblZoekenIn = new GridBagConstraints();
		gbc_lblZoekenIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblZoekenIn.gridx = 0;
		gbc_lblZoekenIn.gridy = 1;
		contentPane.add(lblZoekenIn, gbc_lblZoekenIn);
		
		rdbtnContractId = new JRadioButton("Contract ID");
		GridBagConstraints gbc_rdbtnContractId = new GridBagConstraints();
		gbc_rdbtnContractId.anchor = GridBagConstraints.WEST;
		gbc_rdbtnContractId.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnContractId.gridx = 1;
		gbc_rdbtnContractId.gridy = 2;
		contentPane.add(rdbtnContractId, gbc_rdbtnContractId);
		
		rdbtnBegindatum = new JRadioButton("Begindatum");
		GridBagConstraints gbc_rdbtnBegindatum = new GridBagConstraints();
		gbc_rdbtnBegindatum.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBegindatum.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBegindatum.gridx = 2;
		gbc_rdbtnBegindatum.gridy = 2;
		contentPane.add(rdbtnBegindatum, gbc_rdbtnBegindatum);
		
		rdbtnEinddatum = new JRadioButton("Einddatum");
		GridBagConstraints gbc_rdbtnEinddatum = new GridBagConstraints();
		gbc_rdbtnEinddatum.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEinddatum.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnEinddatum.gridx = 3;
		gbc_rdbtnEinddatum.gridy = 2;
		contentPane.add(rdbtnEinddatum, gbc_rdbtnEinddatum);
		
		rdbtnHuurprijs = new JRadioButton("Huurprijs");
		GridBagConstraints gbc_rdbtnHuurprijs = new GridBagConstraints();
		gbc_rdbtnHuurprijs.anchor = GridBagConstraints.WEST;
		gbc_rdbtnHuurprijs.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHuurprijs.gridx = 1;
		gbc_rdbtnHuurprijs.gridy = 3;
		contentPane.add(rdbtnHuurprijs, gbc_rdbtnHuurprijs);
		
		rdbtnWaarborg = new JRadioButton("Waarborg");
		GridBagConstraints gbc_rdbtnWaarborg = new GridBagConstraints();
		gbc_rdbtnWaarborg.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWaarborg.gridx = 2;
		gbc_rdbtnWaarborg.gridy = 3;
		contentPane.add(rdbtnWaarborg, gbc_rdbtnWaarborg);
		
		chckbxStudio = new JCheckBox("Studio");
		GridBagConstraints gbc_chckbxStudio = new GridBagConstraints();
		gbc_chckbxStudio.anchor = GridBagConstraints.WEST;
		gbc_chckbxStudio.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxStudio.gridx = 1;
		gbc_chckbxStudio.gridy = 4;
		contentPane.add(chckbxStudio, gbc_chckbxStudio);
		
		chckbxStudent = new JCheckBox("Student");
		GridBagConstraints gbc_chckbxStudent = new GridBagConstraints();
		gbc_chckbxStudent.anchor = GridBagConstraints.WEST;
		gbc_chckbxStudent.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxStudent.gridx = 2;
		gbc_chckbxStudent.gridy = 4;
		contentPane.add(chckbxStudent, gbc_chckbxStudent);
		
		chckbxGebouw = new JCheckBox("Gebouw");
		GridBagConstraints gbc_chckbxGebouw = new GridBagConstraints();
		gbc_chckbxGebouw.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxGebouw.gridx = 3;
		gbc_chckbxGebouw.gridy = 4;
		contentPane.add(chckbxGebouw, gbc_chckbxGebouw);
		
		cbxStudio = new JComboBox();
		GridBagConstraints gbc_cbxStudio = new GridBagConstraints();
		gbc_cbxStudio.gridwidth = 3;
		gbc_cbxStudio.insets = new Insets(0, 0, 5, 0);
		gbc_cbxStudio.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxStudio.gridx = 1;
		gbc_cbxStudio.gridy = 5;
		contentPane.add(cbxStudio, gbc_cbxStudio);
		
		cbxStudent = new JComboBox();
		GridBagConstraints gbc_cbxStudent = new GridBagConstraints();
		gbc_cbxStudent.gridwidth = 3;
		gbc_cbxStudent.insets = new Insets(0, 0, 5, 0);
		gbc_cbxStudent.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxStudent.gridx = 1;
		gbc_cbxStudent.gridy = 6;
		contentPane.add(cbxStudent, gbc_cbxStudent);
		
		cbxGebouw = new JComboBox();
		GridBagConstraints gbc_cbxGebouw = new GridBagConstraints();
		gbc_cbxGebouw.insets = new Insets(0, 0, 5, 0);
		gbc_cbxGebouw.gridwidth = 3;
		gbc_cbxGebouw.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxGebouw.gridx = 1;
		gbc_cbxGebouw.gridy = 7;
		contentPane.add(cbxGebouw, gbc_cbxGebouw);
		
		btnSearch = new JButton("SEARCH");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 8;
		contentPane.add(btnSearch, gbc_btnSearch);
                
                
	}

}
