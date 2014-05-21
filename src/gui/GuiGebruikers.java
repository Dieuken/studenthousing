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
import javax.swing.*;
import programma.Gebruiker;
import programma.Converter;
import connectie.ConnGebruiker;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class GuiGebruikers extends JPanel {

	
	private JTextField txtGebruikersnaam;
        private JLabel lblOudWachtwoord;
	private JLabel lblWachtwoord;
	private JLabel lblHerhaaldWachtwoord;
        private JPasswordField pwdOudWachtwoord;
	private JPasswordField pwdWachtwoord;
	private JPasswordField pwdHerhaaldWachtwoord;
        private ConnGebruiker conn = new ConnGebruiker();
        private Converter convert = new Converter();
	private JLabel lblAccounttype;
	private JComboBox cbxType;
        private int positie;
        private boolean nieuw;
        private boolean nieuwpasswoord;
        private ArrayList<Gebruiker> gebruikerlist;
        

	
	public GuiGebruikers() {
		
		setBounds(100, 100, 450, 300);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		JLabel lblGebruikersnaam = new JLabel("Gebruikersnaam: ");
		GridBagConstraints gbc_lblGebruikersnaam = new GridBagConstraints();
		gbc_lblGebruikersnaam.insets = new Insets(0, 0, 5, 5);
		gbc_lblGebruikersnaam.anchor = GridBagConstraints.EAST;
		gbc_lblGebruikersnaam.gridx = 0;
		gbc_lblGebruikersnaam.gridy = 0;
		add(lblGebruikersnaam, gbc_lblGebruikersnaam);
		
		txtGebruikersnaam = new JTextField();
		GridBagConstraints gbc_txtGebruikersnaam = new GridBagConstraints();
		gbc_txtGebruikersnaam.insets = new Insets(0, 0, 5, 0);
		gbc_txtGebruikersnaam.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGebruikersnaam.gridx = 1;
		gbc_txtGebruikersnaam.gridy = 0;
		add(txtGebruikersnaam, gbc_txtGebruikersnaam);
		txtGebruikersnaam.setColumns(10);
                txtGebruikersnaam.setEditable(false);
		
                lblOudWachtwoord = new JLabel("Oud Wachtwoord:");
		GridBagConstraints gbc_lblOudWachtwoord = new GridBagConstraints();
		gbc_lblOudWachtwoord.anchor = GridBagConstraints.EAST;
		gbc_lblOudWachtwoord.insets = new Insets(0, 0, 5, 5);
		gbc_lblOudWachtwoord.gridx = 0;
		gbc_lblOudWachtwoord.gridy = 1;
		add(lblOudWachtwoord, gbc_lblOudWachtwoord);
                lblOudWachtwoord.setVisible(false);
		
		pwdOudWachtwoord = new JPasswordField();
		GridBagConstraints gbc_pwdOudWachtwoord = new GridBagConstraints();
		gbc_pwdOudWachtwoord.insets = new Insets(0, 0, 5, 0);
		gbc_pwdOudWachtwoord.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdOudWachtwoord.gridx = 1;
		gbc_pwdOudWachtwoord.gridy = 1;
		add(pwdOudWachtwoord, gbc_pwdOudWachtwoord);
                pwdOudWachtwoord.setVisible(false);
                
		lblWachtwoord = new JLabel("Wachtwoord:");
		GridBagConstraints gbc_lblWachtwoord = new GridBagConstraints();
		gbc_lblWachtwoord.anchor = GridBagConstraints.EAST;
		gbc_lblWachtwoord.insets = new Insets(0, 0, 5, 5);
		gbc_lblWachtwoord.gridx = 0;
		gbc_lblWachtwoord.gridy = 2;
		add(lblWachtwoord, gbc_lblWachtwoord);
                lblWachtwoord.setVisible(false);
		
		pwdWachtwoord = new JPasswordField();
		GridBagConstraints gbc_pwdWachtwoord = new GridBagConstraints();
		gbc_pwdWachtwoord.insets = new Insets(0, 0, 5, 0);
		gbc_pwdWachtwoord.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdWachtwoord.gridx = 1;
		gbc_pwdWachtwoord.gridy = 2;
		add(pwdWachtwoord, gbc_pwdWachtwoord);
                pwdWachtwoord.setVisible(false);
		
		lblHerhaaldWachtwoord = new JLabel("Herhaal wachtwoord:");
		GridBagConstraints gbc_lblHerhaaldWachtwoord = new GridBagConstraints();
		gbc_lblHerhaaldWachtwoord.anchor = GridBagConstraints.EAST;
		gbc_lblHerhaaldWachtwoord.insets = new Insets(0, 0, 5, 5);
		gbc_lblHerhaaldWachtwoord.gridx = 0;
		gbc_lblHerhaaldWachtwoord.gridy = 3;
		add(lblHerhaaldWachtwoord, gbc_lblHerhaaldWachtwoord);
                lblHerhaaldWachtwoord.setVisible(false);
		
		pwdHerhaaldWachtwoord = new JPasswordField();
		GridBagConstraints gbc_pwdHerhaaldWachtwoord = new GridBagConstraints();
		gbc_pwdHerhaaldWachtwoord.insets = new Insets(0, 0, 5, 0);
		gbc_pwdHerhaaldWachtwoord.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdHerhaaldWachtwoord.gridx = 1;
		gbc_pwdHerhaaldWachtwoord.gridy = 3;
		add(pwdHerhaaldWachtwoord, gbc_pwdHerhaaldWachtwoord);
                pwdHerhaaldWachtwoord.setVisible(false);
		
		lblAccounttype = new JLabel("Accounttype:");
		GridBagConstraints gbc_lblAccounttype = new GridBagConstraints();
		gbc_lblAccounttype.anchor = GridBagConstraints.EAST;
		gbc_lblAccounttype.insets = new Insets(0, 0, 0, 5);
		gbc_lblAccounttype.gridx = 0;
		gbc_lblAccounttype.gridy = 4;
		add(lblAccounttype, gbc_lblAccounttype);
		
		cbxType = new JComboBox();
		GridBagConstraints gbc_cbxType = new GridBagConstraints();
		gbc_cbxType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxType.gridx = 1;
		gbc_cbxType.gridy = 4;
		add(cbxType, gbc_cbxType);
                
                
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
                                nieuwpasswoord = false;
                                txtGebruikersnaam.setEditable(false);
                                lblOudWachtwoord.setVisible(false);
                                pwdOudWachtwoord.setVisible(false);
                                lblWachtwoord.setVisible(false);
                                pwdWachtwoord.setVisible(false);
                                lblHerhaaldWachtwoord.setVisible(false);
                                pwdHerhaaldWachtwoord.setVisible(false);
			}
                });
		
                JButton previous = new JButton(new ImageIcon(getClass().getResource("/resources/previous.png")));
		previous.setToolTipText("Previous");
                 previous.setSelected(true);
                previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            if((positie -1)<0)
                            {
                                vullen(positie);
                                txtGebruikersnaam.setEditable(false);
                                lblOudWachtwoord.setVisible(false);
                                pwdOudWachtwoord.setVisible(false);
                                lblWachtwoord.setVisible(false);
                                pwdWachtwoord.setVisible(false);
                                lblHerhaaldWachtwoord.setVisible(false);
                                pwdHerhaaldWachtwoord.setVisible(false);
                            }       
                            else
                            {   
                                    positie--;
                                    vullen(positie);  
                                    
                                    nieuw = false;
                                    nieuwpasswoord = false;
                                    txtGebruikersnaam.setEditable(false);
                                    lblOudWachtwoord.setVisible(false);
                                pwdOudWachtwoord.setVisible(false);
                                lblWachtwoord.setVisible(false);
                                pwdWachtwoord.setVisible(false);
                                lblHerhaaldWachtwoord.setVisible(false);
                                pwdHerhaaldWachtwoord.setVisible(false);
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
                    if((positie +1) > (gebruikerlist.size()-1))
                            {
                                vullen(positie);
                                txtGebruikersnaam.setEditable(false);
                                lblOudWachtwoord.setVisible(false);
                                pwdOudWachtwoord.setVisible(false);
                                lblWachtwoord.setVisible(false);
                                pwdWachtwoord.setVisible(false);
                                lblHerhaaldWachtwoord.setVisible(false);
                                pwdHerhaaldWachtwoord.setVisible(false);
                            }       
                            else
                            {   
                                positie++;
                                vullen(positie);
                                
                                nieuw = false;
                                nieuwpasswoord = false;
                                txtGebruikersnaam.setEditable(false);
                                lblOudWachtwoord.setVisible(false);
                                pwdOudWachtwoord.setVisible(false);
                                lblWachtwoord.setVisible(false);
                                pwdWachtwoord.setVisible(false);
                                lblHerhaaldWachtwoord.setVisible(false);
                                pwdHerhaaldWachtwoord.setVisible(false);
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
                    positie = gebruikerlist.size() - 1;
                    vullen(positie);
                    
                    nieuw = false;
                    nieuwpasswoord = false;
                    txtGebruikersnaam.setEditable(false);
                    lblOudWachtwoord.setVisible(false);
                    pwdOudWachtwoord.setVisible(false);
                    lblWachtwoord.setVisible(false);
                    pwdWachtwoord.setVisible(false);
                    lblHerhaaldWachtwoord.setVisible(false);
                    pwdHerhaaldWachtwoord.setVisible(false);
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
                    txtGebruikersnaam.setText("");
                    txtGebruikersnaam.setEditable(true);
                    pwdWachtwoord.setText("");
                    pwdHerhaaldWachtwoord.setText("");
                    lblWachtwoord.setVisible(true);
                    pwdWachtwoord.setVisible(true);
                    lblHerhaaldWachtwoord.setVisible(true);
                    pwdHerhaaldWachtwoord.setVisible(true);
                    
                    nieuw = true;
                    nieuwpasswoord = false;
                }
               
        });
        
        JButton save = new JButton(new ImageIcon(getClass().getResource("/resources/save.png")));
		last.setToolTipText("save");
        last.setSelected(true);
       save.addActionListener(new ActionListener() 
        {
        	@Override
            public void actionPerformed(ActionEvent e) {
              String Passwoord = new String();
              String Herhaald = new String();
              Gebruiker gebruiker = new Gebruiker();
                        if(nieuw)
                        {
                             gebruiker.setGebruikersnaam(txtGebruikersnaam.getText());
                             Passwoord = pwdWachtwoord.getText();
                             Herhaald = pwdHerhaaldWachtwoord.getText();
                             if(Passwoord.equals(Herhaald))
                             {
                                try {
                                    gebruiker.setGebruikersnaam(txtGebruikersnaam.getText());
                                    gebruiker.setWachtwoord(convert.MD5(Passwoord));
                                    conn.Gebruikernieuwopslaan(gebruiker);
                                    ophalen();
                                    positie = gebruikerlist.size()-1 ;
                                    vullen(positie);
                                    nieuw = false;
                                    nieuwpasswoord = false;
                                    txtGebruikersnaam.setEditable(false);
                                    lblOudWachtwoord.setVisible(false);
                                    pwdOudWachtwoord.setVisible(false);
                                    lblWachtwoord.setVisible(false);
                                    pwdWachtwoord.setVisible(false);
                                    lblHerhaaldWachtwoord.setVisible(false);
                                    pwdHerhaaldWachtwoord.setVisible(false);
                                } catch (NoSuchAlgorithmException ex) {
                                    Logger.getLogger(GuiGebruikers.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (UnsupportedEncodingException ex) {
                                    Logger.getLogger(GuiGebruikers.class.getName()).log(Level.SEVERE, null, ex);
                                }
                             }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "De 2 passwoorden zijn niet hetzelfde");
                                    pwdWachtwoord.setText("");
                                    pwdHerhaaldWachtwoord.setText("");

                                }
                            
                        
                        }
                        else if(nieuwpasswoord)
                        {
                            String Gebruikersnaam = new String();
                                String Oudpasswoord = new String();
                                String NewPasswoord = new String();
                                String HerhaaldPasswoord = new String();
                                int i = 0;
                            try {
                                    Oudpasswoord = convert.MD5(pwdOudWachtwoord.getText());
                                } catch (NoSuchAlgorithmException ex) {
                                    Logger.getLogger(GuiGebruikers.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (UnsupportedEncodingException ex) {
                                    Logger.getLogger(GuiGebruikers.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            NewPasswoord = pwdWachtwoord.getText();
                            HerhaaldPasswoord = pwdHerhaaldWachtwoord.getText();
                            
                            for (Gebruiker g : gebruikerlist) 
                            {
                                
                                Gebruikersnaam = txtGebruikersnaam.getText();
                                txtGebruikersnaam.setEditable(false);
                                i++;
                                if(Gebruikersnaam.equals(g.getGebruikersnaam()) && Oudpasswoord.equals(g.getWachtwoord()))
                                {
                                   if(NewPasswoord.equals(HerhaaldPasswoord))
                                   {
                                        try {
                                            gebruiker.setGebruikersnaam(Gebruikersnaam);
                                            gebruiker.setWachtwoord(convert.MD5(NewPasswoord));
                                            conn.Wachtwoordaanpassen(gebruiker);
                                            ophalen();
                                            vullen(positie);
                                            nieuw = false;
                                            nieuwpasswoord = false;
                                            lblOudWachtwoord.setVisible(false);
                                            pwdOudWachtwoord.setVisible(false);
                                            lblWachtwoord.setVisible(false);
                                            pwdWachtwoord.setVisible(false);
                                            lblHerhaaldWachtwoord.setVisible(false);
                                            pwdHerhaaldWachtwoord.setVisible(false);
                                            JOptionPane.showMessageDialog(null, "Wachtwoord veranderd");
                                        } catch (NoSuchAlgorithmException ex) {
                                            Logger.getLogger(GuiGebruikers.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (UnsupportedEncodingException ex) {
                                            Logger.getLogger(GuiGebruikers.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                   }
                                  else
                                   {
                                       if(i == gebruikerlist.size())
                                       {
                                           JOptionPane.showMessageDialog(null, "Foutieve gegevens");
                                           pwdOudWachtwoord.setText("");
                                           pwdWachtwoord.setText("");
                                           pwdHerhaaldWachtwoord.setText("");
                                       }
                                   }
                                }
                                else
                                   {
                                       if(i == gebruikerlist.size())
                                       {
                                           JOptionPane.showMessageDialog(null, "Foutieve gegevens");
                                           pwdOudWachtwoord.setText("");
                                           pwdWachtwoord.setText("");
                                           pwdHerhaaldWachtwoord.setText("");
                                       }
                                   }
                                   
                            
                            }
                        
                        }
                        else
                        {
                            String Type = new String();
                            nieuw = false;
                            nieuwpasswoord = false;
                            txtGebruikersnaam.setEditable(false);
                            gebruiker.setGebruikersnaam(txtGebruikersnaam.getText());
                            gebruiker.setAccounttype(cbxType.getSelectedItem().toString());
                            conn.Gebruikeraanpassen(gebruiker);
                            ophalen();
                            vullen(positie);
                            lblOudWachtwoord.setVisible(false);
                            pwdOudWachtwoord.setVisible(false);
                            lblWachtwoord.setVisible(false);
                            pwdWachtwoord.setVisible(false);
                            lblHerhaaldWachtwoord.setVisible(false);
                            pwdHerhaaldWachtwoord.setVisible(false);
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
                    int response = JOptionPane.showConfirmDialog(null, "Ben u zeker dat u deze gebruiker wilt verwijderen?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
                           Gebruiker gebruiker = new Gebruiker();
                           gebruiker.setGebruikersnaam(txtGebruikersnaam.getText());
                            
                            conn.GebruikerDelete(gebruiker);
                            txtGebruikersnaam.setEditable(false);
                            ophalen();
                            positie--;
                            vullen(positie);
                            lblOudWachtwoord.setVisible(false);
                            pwdOudWachtwoord.setVisible(false);
                            lblWachtwoord.setVisible(false);
                            pwdWachtwoord.setVisible(false);
                            lblHerhaaldWachtwoord.setVisible(false);
                            pwdHerhaaldWachtwoord.setVisible(false);
                    
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
                    
                            positie = 0;
                            vullen(positie);
                                    
                            
                }
               
        });
        JButton search = new JButton(new ImageIcon(getClass().getResource("/resources/password.png")));
		search.setToolTipText("change password");
                search.setSelected(true);
                search.addActionListener(new ActionListener() 
       {
        	@Override
            public void actionPerformed(ActionEvent e) 
                {
                    nieuwpasswoord = true;
                    lblOudWachtwoord.setVisible(true);
                    pwdOudWachtwoord.setVisible(true);
                    lblWachtwoord.setVisible(true);
                    pwdWachtwoord.setVisible(true);
                    lblHerhaaldWachtwoord.setVisible(true);
                    pwdHerhaaldWachtwoord.setVisible(true);
                    
                            
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
    gbc_buttonbar .gridy = 12;
    gbc_buttonbar .gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gbc_buttonbar .gridheight = java.awt.GridBagConstraints.REMAINDER;
    add(buttonbar, gbc_buttonbar );
    
    
    positie = 0;
    ophalen();
    vullen(positie);
        }
        public void ophalen()
        {

            gebruikerlist = conn.Vulgebruiker();
        }
        
        
        
        public void vullen(int positie)
        {       
            Gebruiker gebruiker = new Gebruiker();
            cbxType.removeAllItems();
            cbxType.addItem("Admin");
            cbxType.addItem("Medewerker");
            
            
            gebruiker = gebruikerlist.get(positie);
            txtGebruikersnaam.setText(gebruiker.getGebruikersnaam());
            String type;
            type = gebruiker.getAccounttype();
            if(type.equals("Admin"))
            {
                cbxType.setSelectedIndex(0);

            }
            else if(type.equals("Medewerker"))
            {
                cbxType.setSelectedIndex(1);
            }
              
              
              
             
        }
        
}
