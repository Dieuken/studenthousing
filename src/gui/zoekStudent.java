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
import javax.swing.JButton;

public class zoekStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtZoekOp;
	private JRadioButton rdbtnStudentid;
	private JRadioButton rdbtnVoornaam;
	private JRadioButton rdbtnNaam;
	private JRadioButton rdbtnGeboortedatum;
	private JRadioButton rdbtnSchool;
	private JRadioButton rdbtnJaar;
	private JRadioButton rdbtnTelefoon;
	private JRadioButton rdbtnEmail;
	private JRadioButton rdbtnTelefoonOuders;
	private JButton btnSearch;

	
	public zoekStudent() {
		setTitle("Student zoeken...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{101, 73, 105, 0};
		gbl_contentPane.rowHeights = new int[]{20, 14, 23, 23, 23, 35, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblZoekOp = new JLabel("Zoek op:");
		GridBagConstraints gbc_lblZoekOp = new GridBagConstraints();
		gbc_lblZoekOp.insets = new Insets(0, 0, 5, 5);
		gbc_lblZoekOp.gridx = 0;
		gbc_lblZoekOp.gridy = 0;
		contentPane.add(lblZoekOp, gbc_lblZoekOp);
		
		txtZoekOp = new JTextField();
		GridBagConstraints gbc_txtZoekOp = new GridBagConstraints();
		gbc_txtZoekOp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtZoekOp.insets = new Insets(0, 0, 5, 0);
		gbc_txtZoekOp.gridwidth = 2;
		gbc_txtZoekOp.gridx = 1;
		gbc_txtZoekOp.gridy = 0;
		contentPane.add(txtZoekOp, gbc_txtZoekOp);
		txtZoekOp.setColumns(10);
		
		JLabel lblZoekIn = new JLabel("Zoek in:");
		GridBagConstraints gbc_lblZoekIn = new GridBagConstraints();
		gbc_lblZoekIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblZoekIn.gridx = 0;
		gbc_lblZoekIn.gridy = 1;
		contentPane.add(lblZoekIn, gbc_lblZoekIn);
		
		rdbtnStudentid = new JRadioButton("StudentID");
		GridBagConstraints gbc_rdbtnStudentid = new GridBagConstraints();
		gbc_rdbtnStudentid.anchor = GridBagConstraints.WEST;
		gbc_rdbtnStudentid.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStudentid.gridx = 0;
		gbc_rdbtnStudentid.gridy = 2;
		contentPane.add(rdbtnStudentid, gbc_rdbtnStudentid);
		
		rdbtnVoornaam = new JRadioButton("Voornaam");
		GridBagConstraints gbc_rdbtnVoornaam = new GridBagConstraints();
		gbc_rdbtnVoornaam.anchor = GridBagConstraints.WEST;
		gbc_rdbtnVoornaam.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVoornaam.gridx = 1;
		gbc_rdbtnVoornaam.gridy = 2;
		contentPane.add(rdbtnVoornaam, gbc_rdbtnVoornaam);
		
		rdbtnNaam = new JRadioButton("Naam");
		GridBagConstraints gbc_rdbtnNaam = new GridBagConstraints();
		gbc_rdbtnNaam.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNaam.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNaam.gridx = 2;
		gbc_rdbtnNaam.gridy = 2;
		contentPane.add(rdbtnNaam, gbc_rdbtnNaam);
		
		rdbtnGeboortedatum = new JRadioButton("Geboortedatum");
		GridBagConstraints gbc_rdbtnGeboortedatum = new GridBagConstraints();
		gbc_rdbtnGeboortedatum.anchor = GridBagConstraints.WEST;
		gbc_rdbtnGeboortedatum.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnGeboortedatum.gridx = 0;
		gbc_rdbtnGeboortedatum.gridy = 3;
		contentPane.add(rdbtnGeboortedatum, gbc_rdbtnGeboortedatum);
		
		rdbtnSchool = new JRadioButton("School");
		GridBagConstraints gbc_rdbtnSchool = new GridBagConstraints();
		gbc_rdbtnSchool.anchor = GridBagConstraints.WEST;
		gbc_rdbtnSchool.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSchool.gridx = 1;
		gbc_rdbtnSchool.gridy = 3;
		contentPane.add(rdbtnSchool, gbc_rdbtnSchool);
		
		rdbtnJaar = new JRadioButton("Jaar");
		GridBagConstraints gbc_rdbtnJaar = new GridBagConstraints();
		gbc_rdbtnJaar.anchor = GridBagConstraints.WEST;
		gbc_rdbtnJaar.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnJaar.gridx = 2;
		gbc_rdbtnJaar.gridy = 3;
		contentPane.add(rdbtnJaar, gbc_rdbtnJaar);
		
		rdbtnTelefoon = new JRadioButton("Telefoon");
		GridBagConstraints gbc_rdbtnTelefoon = new GridBagConstraints();
		gbc_rdbtnTelefoon.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTelefoon.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTelefoon.gridx = 0;
		gbc_rdbtnTelefoon.gridy = 4;
		contentPane.add(rdbtnTelefoon, gbc_rdbtnTelefoon);
		
		rdbtnEmail = new JRadioButton("E-mail");
		GridBagConstraints gbc_rdbtnEmail = new GridBagConstraints();
		gbc_rdbtnEmail.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEmail.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEmail.gridx = 1;
		gbc_rdbtnEmail.gridy = 4;
		contentPane.add(rdbtnEmail, gbc_rdbtnEmail);
		
		rdbtnTelefoonOuders = new JRadioButton("Telefoon Ouders");
		GridBagConstraints gbc_rdbtnTelefoonOuders = new GridBagConstraints();
		gbc_rdbtnTelefoonOuders.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTelefoonOuders.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnTelefoonOuders.gridx = 2;
		gbc_rdbtnTelefoonOuders.gridy = 4;
		contentPane.add(rdbtnTelefoonOuders, gbc_rdbtnTelefoonOuders);
		
		btnSearch = new JButton("SEARCH");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 6;
		contentPane.add(btnSearch, gbc_btnSearch);
	}

}
