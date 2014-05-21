package gui;



import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.*;

import connectie.ConnGebouw;
import connectie.ConnStudio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import programma.Studio;
import programma.Gebouw;

import java.util.List;
import java.util.Set;

public class GuiStudio extends JPanel {
	private JTextField txtStudioID;
	private JTextField txtOppervlakteStudio;
	private JTextArea txtInrichting;
	private JTextField txtHuurprijs;
        private JComboBox cboGebouw;
        
        private ArrayList<Studio> studlist;
        private ArrayList<Gebouw> gebouwlist;
        private ConnStudio connstud = new ConnStudio();
        private ConnGebouw conngeb = new ConnGebouw();
        private int positie;
        private boolean nieuw;

	/**
	 * Create the panel.
	 */
	public GuiStudio() {
            
                positie = 0;
                nieuw = false;
                
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.5, 0.1, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblStudioId = new JLabel("Studio ID:");
		GridBagConstraints gbc_lblStudioId = new GridBagConstraints();
		gbc_lblStudioId.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudioId.anchor = GridBagConstraints.EAST;
		gbc_lblStudioId.gridx = 0;
		gbc_lblStudioId.gridy = 0;
		add(lblStudioId, gbc_lblStudioId);
		
		txtStudioID = new JTextField();
		GridBagConstraints gbc_txtStudioID = new GridBagConstraints();
		gbc_txtStudioID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStudioID.insets = new Insets(0, 0, 5, 0);
		gbc_txtStudioID.gridx = 1;
		gbc_txtStudioID.gridy = 0;
		add(txtStudioID, gbc_txtStudioID);
		txtStudioID.setColumns(10);
                txtStudioID.setEditable(false);
		
		JLabel lblOppervlakte = new JLabel("Oppervlakte");
		GridBagConstraints gbc_lblOppervlakte = new GridBagConstraints();
		gbc_lblOppervlakte.anchor = GridBagConstraints.EAST;
		gbc_lblOppervlakte.insets = new Insets(0, 0, 5, 5);
		gbc_lblOppervlakte.gridx = 0;
		gbc_lblOppervlakte.gridy = 1;
		add(lblOppervlakte, gbc_lblOppervlakte);
		
		txtOppervlakteStudio = new JTextField();
		GridBagConstraints gbc_txtOppervlakteStudio = new GridBagConstraints();
		gbc_txtOppervlakteStudio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOppervlakteStudio.insets = new Insets(0, 0, 5, 0);
		gbc_txtOppervlakteStudio.gridx = 1;
		gbc_txtOppervlakteStudio.gridy = 1;
		add(txtOppervlakteStudio, gbc_txtOppervlakteStudio);
		txtOppervlakteStudio.setColumns(10);
		
		JLabel lblInrichting = new JLabel("Inrichting:");
		GridBagConstraints gbc_lblInrichting = new GridBagConstraints();
		gbc_lblInrichting.anchor = GridBagConstraints.EAST;
		gbc_lblInrichting.insets = new Insets(0, 0, 5, 5);
		gbc_lblInrichting.gridx = 0;
		gbc_lblInrichting.gridy = 3;
		add(lblInrichting, gbc_lblInrichting);
		
		txtInrichting = new JTextArea();
		GridBagConstraints gbc_txtInrichting = new GridBagConstraints();
		gbc_txtInrichting.fill = GridBagConstraints.BOTH;
		gbc_txtInrichting.insets = new Insets(0, 0, 5, 0);
		gbc_txtInrichting.gridx = 1;
		gbc_txtInrichting.gridy = 3;
		add(txtInrichting, gbc_txtInrichting);
		
		
		JLabel lblHuurprijs = new JLabel("Huurprijs:");
		GridBagConstraints gbc_lblHuurprijs = new GridBagConstraints();
		gbc_lblHuurprijs.anchor = GridBagConstraints.EAST;
		gbc_lblHuurprijs.insets = new Insets(0, 0, 5, 5);
		gbc_lblHuurprijs.gridx = 0;
		gbc_lblHuurprijs.gridy = 2;
		add(lblHuurprijs, gbc_lblHuurprijs);
		
		txtHuurprijs = new JTextField();
		GridBagConstraints gbc_txtHuurprijs = new GridBagConstraints();
		gbc_txtHuurprijs.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHuurprijs.insets = new Insets(0, 0, 5, 0);
		gbc_txtHuurprijs.gridx = 1;
		gbc_txtHuurprijs.gridy = 2;
		add(txtHuurprijs, gbc_txtHuurprijs);
		txtHuurprijs.setColumns(10);
		
		
                
                JLabel lblGebouw = new JLabel("gebouw");
                GridBagConstraints gbc_lblGebouw = new GridBagConstraints();
		gbc_lblGebouw.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGebouw.insets = new Insets(0, 0, 5, 0);
		gbc_lblGebouw.gridx = 0;
		gbc_lblGebouw.gridy = 4;
		add(lblGebouw, gbc_lblGebouw);
                
                cboGebouw = new JComboBox();
                GridBagConstraints gbc_cboGebouw = new GridBagConstraints();
		gbc_cboGebouw.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboGebouw.insets = new Insets(0, 0, 5, 0);
		gbc_cboGebouw.gridx = 1;
		gbc_cboGebouw.gridy = 4;
		add(cboGebouw, gbc_cboGebouw);

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
                    if((positie +1) > (studlist.size()-1))
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
                    positie = studlist.size() - 1;
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
                    Studio studio = new Studio();
                    int ID;
                   
                    studio = studlist.get(studlist.size()-1);
                    ID = studio.getstudioid() + 1;
                    txtStudioID.setText(Integer.toString(ID));
                    txtOppervlakteStudio.setText("");
                    txtInrichting.setText("");
                    txtHuurprijs.setText("");
                    int i = 0;
                    cboGebouw.removeAllItems();
                    Gebouw gebouw = new Gebouw();
                    
                    while(i <= gebouwlist.size() -1)
                    {
                       gebouw = gebouwlist.get(i);
                        cboGebouw.addItem(gebouw);
                        i++;
                    }
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
              
                    
                    
                    int ID = Integer.parseInt(txtStudioID.getText());
                    int studid;
                    int size = studlist.size();
                    int i = 0;
                    while (i <= size)
                    {
                        studid = studlist.get(i).getstudioid();
                        if(nieuw == true)
                        {
                            Studio studio = new Studio();
                            Gebouw gebouw = new Gebouw();
                            
                            studio.setstudioid(Integer.parseInt(txtStudioID.getText()));
                            studio.sethuurprijs(Double.parseDouble(txtHuurprijs.getText()));
                            studio.setinrichting(txtInrichting.getText());
                            studio.setoppervlakte(txtOppervlakteStudio.getText());
                            gebouw = gebouwlist.get(cboGebouw.getSelectedIndex());
                            studio.setgebouwid(gebouw.getGebouwID());
                            
                            connstud.studionieuwopslaan(studio);
                            ophalen();
                            positie = studlist.size()-1 ;
                            vullen(positie);
                            nieuw = false;
                            break; 
                        
                        }
                        if(ID == studid)
                        {
                            Studio studio = new Studio();
                            Gebouw gebouw = new Gebouw();
                            int gebouwid;
                            
                            studio.setstudioid(Integer.parseInt(txtStudioID.getText()));
                            studio.sethuurprijs(Double.parseDouble(txtHuurprijs.getText()));
                            studio.setinrichting(txtInrichting.getText());
                            studio.setoppervlakte(txtOppervlakteStudio.getText());                            
                            gebouw = gebouwlist.get(cboGebouw.getSelectedIndex());
                            gebouwid = gebouw.getGebouwID();
                            studio.setgebouwid(gebouwid);
                            connstud.studioaanpassen(studio);
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
                    int response = JOptionPane.showConfirmDialog(null, "Ben u zeker dat u deze studio wilt verwijderen?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
                            Studio studio = new Studio();
                            Gebouw gebouw = new Gebouw();
                            studio.setstudioid(Integer.parseInt(txtStudioID.getText()));
                            studio.sethuurprijs(Double.parseDouble(txtHuurprijs.getText()));
                            studio.setinrichting(txtInrichting.getText());
                            studio.setoppervlakte(txtOppervlakteStudio.getText());
                            
                            
                            studio.setgebouwid(gebouw.getGebouwID());
                            
                            connstud.studiodelete(studio);
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
            studlist = connstud.Vulstudio();
            gebouwlist = conngeb.Vulgebouw();
        }
        
        
        
        public void vullen(int positie)
        {       
              Studio studio = new Studio();
              
              studio = studlist.get(positie);
              txtStudioID.setText(Integer.toString(studio.getstudioid()));
              txtOppervlakteStudio.setText(studio.getoppervlakte());
              txtInrichting.setText(studio.getinrichting());
              txtHuurprijs.setText(Double.toString(studio.gethuurprijs()));
              
              int i = 0;
              int e = 0;
              Gebouw gebouw = new Gebouw();
              cboGebouw.removeAllItems();
              while (i <= (gebouwlist.size()-1))
                      {
                          gebouw = gebouwlist.get(i);
                          cboGebouw.addItem(gebouw.toString());
                      if (studio.getgebouwid() == gebouw.getGebouwID())
                      {
                            e = i;
                            
                      }
                      i++;
                        
                      }
              cboGebouw.setSelectedIndex(e);
        }

}
