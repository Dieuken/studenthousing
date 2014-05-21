package gui;

import connectie.ConnGebouw;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import programma.Gebouw;
import programma.Gebouw;

public class GuiGebouw extends JPanel {
	private JTextField txtPostcode;
	private JTextField txtNr;
	private JTextField txtGebouwID;
	private JTextField txtGemeente;
	private JTextField txtStraat;
        private JTextArea txtaComment;
        
        private ArrayList<Gebouw> gebouwlist;
        private ConnGebouw conn = new ConnGebouw();
        private int positie;
        private boolean nieuw;
        private zoekGebouw zoek;
        
	
	public GuiGebouw() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGebouwId = new JLabel("Gebouw ID:");
		GridBagConstraints gbc_lblGebouwId = new GridBagConstraints();
		gbc_lblGebouwId.anchor = GridBagConstraints.EAST;
		gbc_lblGebouwId.insets = new Insets(0, 0, 5, 5);
		gbc_lblGebouwId.gridx = 0;
		gbc_lblGebouwId.gridy = 0;
		add(lblGebouwId, gbc_lblGebouwId);
		
		txtGebouwID = new JTextField();
		GridBagConstraints gbc_txtGebouwID = new GridBagConstraints();
		gbc_txtGebouwID.insets = new Insets(0, 0, 5, 5);
		gbc_txtGebouwID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGebouwID.gridx = 1;
		gbc_txtGebouwID.gridy = 0;
		add(txtGebouwID, gbc_txtGebouwID);
		txtGebouwID.setColumns(10);
                txtGebouwID.setEditable(false);
		
		JLabel lblGemeente = new JLabel("Gemeente:");
		GridBagConstraints gbc_lblGemeente = new GridBagConstraints();
		gbc_lblGemeente.anchor = GridBagConstraints.EAST;
		gbc_lblGemeente.insets = new Insets(0, 0, 5, 5);
		gbc_lblGemeente.gridx = 0;
		gbc_lblGemeente.gridy = 1;
		add(lblGemeente, gbc_lblGemeente);
		
		txtGemeente = new JTextField();
		GridBagConstraints gbc_txtGemeente = new GridBagConstraints();
		gbc_txtGemeente.insets = new Insets(0, 0, 5, 5);
		gbc_txtGemeente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGemeente.gridx = 1;
		gbc_txtGemeente.gridy = 1;
		add(txtGemeente, gbc_txtGemeente);
		txtGemeente.setColumns(10);
		
		JLabel lblPostcode = new JLabel("Postcode: ");
		GridBagConstraints gbc_lblPostcode = new GridBagConstraints();
		gbc_lblPostcode.anchor = GridBagConstraints.EAST;
		gbc_lblPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostcode.gridx = 2;
		gbc_lblPostcode.gridy = 1;
		add(lblPostcode, gbc_lblPostcode);
		
		txtPostcode = new JTextField();
		GridBagConstraints gbc_txtPostcode = new GridBagConstraints();
		gbc_txtPostcode.insets = new Insets(0, 0, 5, 0);
		gbc_txtPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostcode.gridx = 3;
		gbc_txtPostcode.gridy = 1;
		add(txtPostcode, gbc_txtPostcode);
		txtPostcode.setColumns(10);
		
		JLabel lblStraat = new JLabel("Straat: ");
		GridBagConstraints gbc_lblStraat = new GridBagConstraints();
		gbc_lblStraat.anchor = GridBagConstraints.EAST;
		gbc_lblStraat.insets = new Insets(0, 0, 5, 5);
		gbc_lblStraat.gridx = 0;
		gbc_lblStraat.gridy = 2;
		add(lblStraat, gbc_lblStraat);
		
		txtStraat = new JTextField();
		GridBagConstraints gbc_txtStraat = new GridBagConstraints();
		gbc_txtStraat.insets = new Insets(0, 0, 5, 5);
		gbc_txtStraat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStraat.gridx = 1;
		gbc_txtStraat.gridy = 2;
		add(txtStraat, gbc_txtStraat);
		txtStraat.setColumns(10);
		
		JLabel lblNr = new JLabel("Nr: ");
		GridBagConstraints gbc_lblNr = new GridBagConstraints();
		gbc_lblNr.anchor = GridBagConstraints.EAST;
		gbc_lblNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblNr.gridx = 2;
		gbc_lblNr.gridy = 2;
		add(lblNr, gbc_lblNr);
		
		txtNr = new JTextField();
		GridBagConstraints gbc_txtNr = new GridBagConstraints();
		gbc_txtNr.insets = new Insets(0, 0, 5, 0);
		gbc_txtNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNr.gridx = 3;
		gbc_txtNr.gridy = 2;
		add(txtNr, gbc_txtNr);
		txtNr.setColumns(10);
		
		JLabel lblComment = new JLabel("Comment");
		GridBagConstraints gbc_lblComment = new GridBagConstraints();
		gbc_lblComment.insets = new Insets(0, 0, 5, 5);
		gbc_lblComment.gridx = 0;
		gbc_lblComment.gridy = 4;
		add(lblComment, gbc_lblComment);
		
		txtaComment = new JTextArea();
		GridBagConstraints gbc_txtaComment = new GridBagConstraints();
		gbc_txtaComment.insets = new Insets(0, 0, 5, 5);
		gbc_txtaComment.fill = GridBagConstraints.BOTH;
		gbc_txtaComment.gridx = 1;
		gbc_txtaComment.gridy = 4;
		add(txtaComment, gbc_txtaComment);
		
		zoek = new zoekGebouw(this);
                zoek.setVisible(false);
                
                JToolBar buttonbar = new JToolBar();
		buttonbar.setFloatable(false);

                JButton first = new JButton(new ImageIcon(getClass().getResource("/resources/first.png")));
		first.setToolTipText("First");
                first.setSelected(true);
                first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				positie = 0;
                                vullen(positie);
                                
                                nieuw = false;
			}
                });
		
                JButton previous = new JButton(new ImageIcon(getClass().getResource("/resources/previous.png")));
		previous.setToolTipText("Previous");
                 previous.setSelected(true);
                previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            if((positie -1)<0)
                            {
                                
                            }       
                            else
                            {   
                                    positie--;
                                    vullen(positie);  
                                    
                                    nieuw = false;
                            }
                        }
                });
        
        JButton next = new JButton(new ImageIcon(getClass().getResource("/resources/next.png")));
		next.setToolTipText("Next");
                next.setSelected(true);
                next.addActionListener(new ActionListener() 
                {
                    @Override
                public void actionPerformed(ActionEvent e) {
                    if((positie +1) > (gebouwlist.size()-1))
                            {
                                
                            }       
                            else
                            {   
                                positie++;
                                vullen(positie);
                                
                                nieuw = false;
                            }
                        }
                   
                });
        
        JButton last = new JButton(new ImageIcon(getClass().getResource("/resources/last.png")));
		last.setToolTipText("Last");
        last.setSelected(true);
       last.addActionListener(new ActionListener() 
       {
        	@Override
            public void actionPerformed(ActionEvent e) 
                {
                    positie = gebouwlist.size() - 1;
                    vullen(positie);
                    
                    nieuw = false;
                }
        });
       
        JButton add = new JButton(new ImageIcon(getClass().getResource("/resources/new.png")));
		last.setToolTipText("add");
            add.setSelected(true);
            add.addActionListener(new ActionListener() 
       {
        	@Override
            public void actionPerformed(ActionEvent e) 
                {
                    Gebouw Gebouw = new Gebouw();
                    int ID;
                   
                    Gebouw = gebouwlist.get(gebouwlist.size()-1);
                    ID = Gebouw.getGebouwID() + 1;
                    txtGebouwID.setText(Integer.toString(ID));
                    txtStraat.setText("");
                    txtGemeente.setText("");
                    txtNr.setText("");
                    txtPostcode.setText("");
                    txtaComment.setText("");
                    
                    nieuw = true;
                }
               
        });
        
        JButton save = new JButton(new ImageIcon(getClass().getResource("/resources/save.png")));
		last.setToolTipText("save");
        last.setSelected(true);
       save.addActionListener(new ActionListener() 
        {
        	@Override
            public void actionPerformed(ActionEvent e) {
              
                    
                    
                    int ID = Integer.parseInt(txtGebouwID.getText());
                    int gebid;
                    int size = gebouwlist.size();
                    int i = 0;
                    while (i <= size)
                    {
                        gebid = gebouwlist.get(i).getGebouwID();
                        if(nieuw == true)
                        {
                            Gebouw Gebouw = new Gebouw();
                            
                            Gebouw.setGebouwID(Integer.parseInt(txtGebouwID.getText()));
                            Gebouw.setNr(Integer.parseInt(txtNr.getText()));
                            Gebouw.setGemeente(txtGemeente.getText());
                            Gebouw.setPostcode(txtPostcode.getText());
                            Gebouw.setStraat(txtStraat.getText());
                            Gebouw.setComment(txtaComment.getText());
                            
                            conn.Gebouwnieuwopslaan(Gebouw);

                            positie = gebouwlist.size()-1;
                            
                            ophalen();
                            vullen(positie);
                            nieuw = false;
                            break; 
                        
                        }
                        if(ID == gebid)
                        {
                            Gebouw Gebouw = new Gebouw();
                            
                            Gebouw.setGebouwID(Integer.parseInt(txtGebouwID.getText()));
                            Gebouw.setNr(Integer.parseInt(txtNr.getText()));
                            Gebouw.setGemeente(txtGemeente.getText());
                            Gebouw.setPostcode(txtPostcode.getText());
                            Gebouw.setStraat(txtStraat.getText());
                            Gebouw.setComment(txtaComment.getText());
                            
                            conn.Gebouwaanpassen(Gebouw);
                            ophalen();
                            vullen(positie);
                            nieuw = false;
                            break;
                        
                        }
                        
                    i++;
                    }
                    
                    
                   }
       });
        
        JButton delete = new JButton(new ImageIcon(getClass().getResource("/resources/delete.png")));
		last.setToolTipText("delete");
       delete.setSelected(true);
         delete.addActionListener(new ActionListener() 
       {
        	@Override
            public void actionPerformed(ActionEvent e) 
                {
                            int response = JOptionPane.showConfirmDialog(null, "Ben u zeker dat u dit gebouw wilt verwijderen?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
      
                            Gebouw Gebouw = new Gebouw();
                            Gebouw.setGebouwID(Integer.parseInt(txtGebouwID.getText()));
                            Gebouw.setNr(Integer.parseInt(txtNr.getText()));
                            Gebouw.setPostcode(txtPostcode.getText());
                            Gebouw.setGemeente(txtGemeente.getText());
                            Gebouw.setStraat(txtStraat.getText());
                            Gebouw.setComment(txtaComment.getText());
                            
                            conn.Gebouwdelete(Gebouw);
                            ophalen();
                            positie--;
                            vullen(positie);
                            
                }
              }
               
        });
         
         JButton refresh = new JButton(new ImageIcon(getClass().getResource("/resources/refresh.png")));
		 refresh.setToolTipText("refresh");
                 refresh.setSelected(true);
                 refresh.addActionListener(new ActionListener() 
       {
        	@Override
            public void actionPerformed(ActionEvent e) 
                {
                            ophalen();
                            positie = 0;
                            vullen(positie);
                                    
                            
                }
               
        });
        JButton search = new JButton(new ImageIcon(getClass().getResource("/resources/search.png")));
		search.setToolTipText("search");
                search.setSelected(true);
                search.addActionListener(new ActionListener() 
       {
        	@Override
            public void actionPerformed(ActionEvent e) 
                {
                    zoek.setVisible(true);       
                }
               
        });
         
         
       buttonbar.add(first);
       buttonbar.add(previous);
       buttonbar.add(add);
       buttonbar.add(save);
       buttonbar.add(delete);
       buttonbar.add(refresh);
       buttonbar.add(search);
       buttonbar.add(next);
       buttonbar.add(last);
       
       
       buttonbar.setRollover(true);

// Code of sub-components and layout - not shown here

    GridBagConstraints gbc_buttonbar = new GridBagConstraints();
    gbc_buttonbar .gridx = 0;
    gbc_buttonbar .gridy = 7;
    gbc_buttonbar .gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gbc_buttonbar .gridheight = java.awt.GridBagConstraints.REMAINDER;
    add(buttonbar, gbc_buttonbar );
	ophalen();
        vullen(positie);
        
        }
        public void ophalen()
        {

            gebouwlist = conn.Vulgebouw();
        }
        
        
        
        public void vullen(int positie)
        {       
              Gebouw Gebouw = new Gebouw();
              
              Gebouw = gebouwlist.get(positie);
              txtGebouwID.setText(Integer.toString(Gebouw.getGebouwID()));
              txtStraat.setText(Gebouw.getStraat());
              txtGemeente.setText(Gebouw.getGemeente());
              txtNr.setText(Integer.toString(Gebouw.getNr()));
              txtPostcode.setText(Gebouw.getPostcode());
              txtaComment.setText(Gebouw.getComment());
              
              
             
        }
        public void setgebouwlist(ArrayList<Gebouw> gebouwlist) {
		this.gebouwlist = gebouwlist;
                positie = 0;
                vullen(positie);
                zoek.setVisible(false);
	}
}
