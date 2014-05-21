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
import java.awt.event.ItemEvent;
import javax.swing.*;
import programma.Gebouw;
import connectie.ConnGebouw;
import java.util.ArrayList;

public class zoekGebouw extends JFrame{

	private JPanel contentPane;
	private JTextField txtZoekOp;
	private JButton btnSearch;
	private JRadioButton rdbtnGebouwId;
	private JRadioButton rdbtnStraat;
	private JRadioButton rdbtnNr;
	private JRadioButton rdbtnPostcode;
	private JRadioButton rdbtnGemeente;
	private JRadioButton rdbtnComment;
        private ButtonGroup radioGroup;
        private int button;
        private ConnGebouw conn = new ConnGebouw();
        private ArrayList<Gebouw> gebouwlist;
        private GuiGebouw gui;
	
	public zoekGebouw(GuiGebouw guigebouw) {
            
                gui = guigebouw;
            
            
		setTitle("Gebouw zoeken...");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 315, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{79, 75, 71, 0};
		gbl_contentPane.rowHeights = new int[]{20, 14, 23, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		rdbtnGebouwId = new JRadioButton("Gebouw ID");
		GridBagConstraints gbc_rdbtnGebouwId = new GridBagConstraints();
		gbc_rdbtnGebouwId.anchor = GridBagConstraints.WEST;
		gbc_rdbtnGebouwId.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnGebouwId.gridx = 0;
		gbc_rdbtnGebouwId.gridy = 2;
		contentPane.add(rdbtnGebouwId, gbc_rdbtnGebouwId);
		
		rdbtnStraat = new JRadioButton("Straat");
		GridBagConstraints gbc_rdbtnStraat = new GridBagConstraints();
		gbc_rdbtnStraat.anchor = GridBagConstraints.WEST;
		gbc_rdbtnStraat.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStraat.gridx = 1;
		gbc_rdbtnStraat.gridy = 2;
		contentPane.add(rdbtnStraat, gbc_rdbtnStraat);
		
		rdbtnNr = new JRadioButton("Nr");
		GridBagConstraints gbc_rdbtnNr = new GridBagConstraints();
		gbc_rdbtnNr.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNr.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNr.gridx = 2;
		gbc_rdbtnNr.gridy = 2;
		contentPane.add(rdbtnNr, gbc_rdbtnNr);
		
		rdbtnPostcode = new JRadioButton("Postcode");
		GridBagConstraints gbc_rdbtnPostcode = new GridBagConstraints();
		gbc_rdbtnPostcode.anchor = GridBagConstraints.WEST;
		gbc_rdbtnPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPostcode.gridx = 0;
		gbc_rdbtnPostcode.gridy = 3;
		contentPane.add(rdbtnPostcode, gbc_rdbtnPostcode);
		
		rdbtnGemeente = new JRadioButton("Gemeente");
		GridBagConstraints gbc_rdbtnGemeente = new GridBagConstraints();
		gbc_rdbtnGemeente.anchor = GridBagConstraints.WEST;
		gbc_rdbtnGemeente.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnGemeente.gridx = 1;
		gbc_rdbtnGemeente.gridy = 3;
		contentPane.add(rdbtnGemeente, gbc_rdbtnGemeente);
		
		rdbtnComment = new JRadioButton("Comment");
		GridBagConstraints gbc_rdbtnComment = new GridBagConstraints();
		gbc_rdbtnComment.anchor = GridBagConstraints.WEST;
		gbc_rdbtnComment.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnComment.gridx = 2;
		gbc_rdbtnComment.gridy = 3;
		contentPane.add(rdbtnComment, gbc_rdbtnComment);
		
		btnSearch = new JButton("SEARCH");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 4;
		contentPane.add(btnSearch, gbc_btnSearch);
                
                radioGroup = new ButtonGroup(); 
                radioGroup.add( rdbtnGebouwId );
                radioGroup.add( rdbtnStraat );
                radioGroup.add( rdbtnNr );
                radioGroup.add( rdbtnPostcode );
                radioGroup.add( rdbtnGemeente );
                radioGroup.add( rdbtnComment );
                
                btnSearch.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent login){
                       if(rdbtnGebouwId.isSelected())
                        {
                            String zoekop;
                            zoekop = txtZoekOp.getText();
                            gebouwlist = conn.Zoekgebouwid("GebouwId", zoekop);
                             if(gebouwlist.size()>0)
                            {
                                gui.setgebouwlist(gebouwlist);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Niets gevonden");
                            }
                            
                        }
                       else if(rdbtnStraat.isSelected())
                        {
                           String zoekop;
                            zoekop = txtZoekOp.getText();
                            gebouwlist = conn.ZoekStraat("Straat", zoekop);
                             if(gebouwlist.size()>0)
                            {
                                gui.setgebouwlist(gebouwlist);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Niets gevonden");
                            }
                        }
                        else if(rdbtnNr.isSelected())
                        {
                            String zoekop;
                            zoekop = txtZoekOp.getText();
                            gebouwlist = conn.ZoekNr("Nr", zoekop);
                             if(gebouwlist.size()>0)
                            {
                                gui.setgebouwlist(gebouwlist);
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Niets gevonden");
                            }
                        }
                        else if(rdbtnPostcode.isSelected())
                        {
                            String zoekop;
                            zoekop = txtZoekOp.getText();
                            gebouwlist = conn.ZoekPostcode("Postcode", zoekop);
                             if(gebouwlist.size()>0)
                            {
                                gui.setgebouwlist(gebouwlist);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Niets gevonden");
                            }
                        }
                        else if(rdbtnGemeente.isSelected())
                        {
                            String zoekop;
                            zoekop = txtZoekOp.getText();
                            gebouwlist = conn.ZoekGemeente("Gemeente", zoekop);
                             if(gebouwlist.size()>0)
                            {
                                gui.setgebouwlist(gebouwlist);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Niets gevonden");
                            }
                        }
                        else if(rdbtnComment.isSelected())
                        {
                            String zoekop;
                            zoekop = txtZoekOp.getText();
                            gebouwlist = conn.ZoekComment("Comment", zoekop);
                            if(gebouwlist.size()>0)
                            {
                                gui.setgebouwlist(gebouwlist);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Niets gevonden");
                            }
                        }
                    }
                });
                
	}
       
        
}
