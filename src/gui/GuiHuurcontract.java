package gui;



import connectie.ConnGebouw;
import connectie.ConnStudio;
import connectie.ConnContract;
import connectie.ConnStudent;
import connectie.Connstudentcontract;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import programma.Gebouw;
import programma.Studenten;
import programma.Studio;
import programma.Huurcontract;
import programma.studentcontract;

public class GuiHuurcontract extends JPanel implements ItemListener{
	private JTextField txtContractID;
	private JFormattedTextField txtBegindatum;
	private JTextField txtHuurprijs;
	private JFormattedTextField txtEinddatum;
	private JTextField txtWaarborg;
        private JComboBox<Gebouw>  cboGebouw;
        private JComboBox<Studio>  cboStudio;
        private JList optie;
        private JList gekozen;
        private ArrayList<Studenten> studentlist;
        private DefaultListModel<Studenten> studentgekozen;
        private DefaultListModel<Studenten> studentoptie;
        private ArrayList<Gebouw> gebouwlist;
        private ArrayList<Studio> studiolist;
        private ArrayList<studentcontract> studconlist;
        private ArrayList<Huurcontract> contractlist;
        private ConnGebouw conngeb = new ConnGebouw();
        private ConnStudio connstud = new ConnStudio();
        private ConnContract conncon = new ConnContract();
        private ConnStudent connstudent = new ConnStudent();
        private Connstudentcontract connstudcon = new Connstudentcontract();
        
        private int positie;
        private boolean nieuw;
        private boolean aangepast;

	/**
	 * Create the panel.
	 */
	public GuiHuurcontract(){
        try {
            GridBagLayout gridBagLayout = new GridBagLayout();
            gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
            gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
            gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
            gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
            setLayout(gridBagLayout);
            
            JLabel lblContractId = new JLabel("Contract ID:");
            GridBagConstraints gbc_lblContractId = new GridBagConstraints();
            gbc_lblContractId.anchor = GridBagConstraints.EAST;
            gbc_lblContractId.insets = new Insets(0, 0, 5, 5);
            gbc_lblContractId.gridx = 0;
            gbc_lblContractId.gridy = 0;
            add(lblContractId, gbc_lblContractId);
            
            
            txtContractID = new JTextField();
            GridBagConstraints gbc_txtContractID = new GridBagConstraints();
            gbc_txtContractID.insets = new Insets(0, 0, 5, 5);
            gbc_txtContractID.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtContractID.gridx = 1;
            gbc_txtContractID.gridy = 0;
            add(txtContractID, gbc_txtContractID);
            txtContractID.setColumns(10);
            txtContractID.setEditable(false);
            
            JLabel lblBegindatum = new JLabel("Begindatum:");
            GridBagConstraints gbc_lblBegindatum = new GridBagConstraints();
            gbc_lblBegindatum.insets = new Insets(0, 0, 5, 5);
            gbc_lblBegindatum.anchor = GridBagConstraints.EAST;
            gbc_lblBegindatum.gridx = 0;
            gbc_lblBegindatum.gridy = 1;
            add(lblBegindatum, gbc_lblBegindatum);
            
            
            MaskFormatter mf1 = new MaskFormatter("####-##-##");
            mf1.setPlaceholderCharacter('_');
            
            txtBegindatum = new JFormattedTextField(mf1);
            GridBagConstraints gbc_txtBegindatum = new GridBagConstraints();
            gbc_txtBegindatum.insets = new Insets(0, 0, 5, 5);
            gbc_txtBegindatum.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtBegindatum.gridx = 1;
            gbc_txtBegindatum.gridy = 1;
            add(txtBegindatum, gbc_txtBegindatum);
            txtBegindatum.setColumns(10);
            
            
            JLabel lblEinddatum = new JLabel("Einddatum:");
            GridBagConstraints gbc_lblEinddatum = new GridBagConstraints();
            gbc_lblEinddatum.anchor = GridBagConstraints.EAST;
            gbc_lblEinddatum.insets = new Insets(0, 0, 5, 5);
            gbc_lblEinddatum.gridx = 2;
            gbc_lblEinddatum.gridy = 1;
            add(lblEinddatum, gbc_lblEinddatum);
            
            MaskFormatter mf2 = new MaskFormatter("####-##-##");
            mf1.setPlaceholderCharacter('_');
            
            txtEinddatum = new JFormattedTextField(mf2);
            GridBagConstraints gbc_txtEinddatum = new GridBagConstraints();
            gbc_txtEinddatum.insets = new Insets(0, 0, 5, 0);
            gbc_txtEinddatum.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtEinddatum.gridx = 3;
            gbc_txtEinddatum.gridy = 1;
            add(txtEinddatum, gbc_txtEinddatum);
            txtEinddatum.setColumns(10);
            
            JLabel lblHuurprijs = new JLabel("Huurprijs: ");
            GridBagConstraints gbc_lblHuurprijs = new GridBagConstraints();
            gbc_lblHuurprijs.anchor = GridBagConstraints.EAST;
            gbc_lblHuurprijs.insets = new Insets(0, 0, 5, 5);
            gbc_lblHuurprijs.gridx = 0;
            gbc_lblHuurprijs.gridy = 2;
            add(lblHuurprijs, gbc_lblHuurprijs);
            
            txtHuurprijs = new JTextField();
            GridBagConstraints gbc_txtHuurprijs = new GridBagConstraints();
            gbc_txtHuurprijs.insets = new Insets(0, 0, 5, 5);
            gbc_txtHuurprijs.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtHuurprijs.gridx = 1;
            gbc_txtHuurprijs.gridy = 2;
            add(txtHuurprijs, gbc_txtHuurprijs);
            txtHuurprijs.setColumns(10);
            txtHuurprijs.setEditable(false);
            
            JLabel lblWaarborg = new JLabel("Waarborg:");
            GridBagConstraints gbc_lblWaarborg = new GridBagConstraints();
            gbc_lblWaarborg.anchor = GridBagConstraints.EAST;
            gbc_lblWaarborg.insets = new Insets(0, 0, 5, 5);
            gbc_lblWaarborg.gridx = 0;
            gbc_lblWaarborg.gridy = 3;
            add(lblWaarborg, gbc_lblWaarborg);
            
            txtWaarborg = new JTextField();
            GridBagConstraints gbc_txtWaarborg = new GridBagConstraints();
            gbc_txtWaarborg.insets = new Insets(0, 0, 5, 5);
            gbc_txtWaarborg.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtWaarborg.gridx = 1;
            gbc_txtWaarborg.gridy = 3;
            add(txtWaarborg, gbc_txtWaarborg);
            txtWaarborg.setColumns(10);
            
            JLabel lblGebouw = new JLabel("Gebouw:");
            GridBagConstraints gbc_lblGebouw = new GridBagConstraints();
            gbc_lblGebouw.anchor = GridBagConstraints.EAST;
            gbc_lblGebouw.insets = new Insets(0, 0, 5, 5);
            gbc_lblGebouw.gridx = 0;
            gbc_lblGebouw.gridy = 4;
            add(lblGebouw, gbc_lblGebouw);
            
            
            cboGebouw = new JComboBox();
            cboGebouw.addItemListener(this);
            GridBagConstraints gbc_cbogebouw = new GridBagConstraints();
            gbc_cbogebouw.anchor = GridBagConstraints.EAST;
            gbc_cbogebouw.insets = new Insets(0, 0, 5, 5);
            gbc_cbogebouw.gridx = 1;
            gbc_cbogebouw.gridy = 4;
            add(cboGebouw, gbc_cbogebouw);
            
            JLabel lblStudio = new JLabel("Studio:");
            GridBagConstraints gbc_lblStudio = new GridBagConstraints();
            gbc_lblStudio.anchor = GridBagConstraints.EAST;
            gbc_lblStudio.insets = new Insets(0, 0, 5, 5);
            gbc_lblStudio.gridx = 2;
            gbc_lblStudio.gridy = 4;
            add(lblStudio, gbc_lblStudio);
            
            cboStudio = new JComboBox();
            cboStudio.addItemListener(this);
            GridBagConstraints gbc_cbostudio = new GridBagConstraints();
            gbc_cbostudio.anchor = GridBagConstraints.EAST;
            gbc_cbostudio.insets = new Insets(0, 0, 5, 5);
            gbc_cbostudio.gridx = 3;
            gbc_cbostudio.gridy = 4;
            add(cboStudio, gbc_cbostudio);
            
            JLabel lbloptie = new JLabel("studenten die deze studio niet huren");
            GridBagConstraints gbc_lbloptie= new GridBagConstraints();
            gbc_lbloptie.anchor = GridBagConstraints.EAST;
            gbc_lbloptie.insets = new Insets(0, 0, 5, 5);
            gbc_lbloptie.gridx = 1;
            gbc_lbloptie.gridy = 5;
            add(lbloptie, gbc_lbloptie);
            
            optie = new JList();
            optie.setVisibleRowCount(10);
            GridBagConstraints gbc_optie= new GridBagConstraints();
            gbc_optie.anchor = GridBagConstraints.EAST;
            gbc_optie.insets = new Insets(0, 0, 5, 5);
            gbc_optie.gridx = 1;
            gbc_optie.gridy = 6;
            add(optie, gbc_optie);
            
            JLabel lblgekozen = new JLabel("studenten die deze studio huren");
            GridBagConstraints gbc_lblgekozen= new GridBagConstraints();
            gbc_lblgekozen.anchor = GridBagConstraints.EAST;
            gbc_lblgekozen.insets = new Insets(0, 0, 5, 5);
            gbc_lblgekozen.gridx = 3;
            gbc_lblgekozen.gridy = 5;
            add(lblgekozen, gbc_lblgekozen);
            
            gekozen = new JList();
            gekozen.setVisibleRowCount(10);
            GridBagConstraints gbc_gekozen= new GridBagConstraints();
            gbc_gekozen.anchor = GridBagConstraints.EAST;
            gbc_gekozen.insets = new Insets(0, 0, 5, 5);
            gbc_gekozen.gridx = 3;
            gbc_gekozen.gridy = 6;
            add(gekozen, gbc_gekozen);
            
            JPanel overdracht = new JPanel();
            GridBagConstraints gbc_overdracht= new GridBagConstraints();
            gbc_overdracht.anchor = GridBagConstraints.EAST;
            gbc_overdracht.insets = new Insets(0, 0, 5, 5);
            gbc_overdracht.gridx = 2;
            gbc_overdracht.gridy = 6;
            add(overdracht, gbc_overdracht);
            
            studentgekozen = new DefaultListModel();
            
            studentoptie = new DefaultListModel();
            

            JButton left = new JButton(new ImageIcon(getClass().getResource("/resources/previous.png")));
            left.setToolTipText("left");
            left.setSelected(true);
   left.addActionListener(new ActionListener() 
    {
            @Override
        public void actionPerformed(ActionEvent e) {
                if (gekozen.getSelectedValue() == null)
                        {
                        }
                else
                {
                    int i;
                    i = 0;
                    Studenten student = new Studenten();
                    i = gekozen.getSelectedIndex();
                    student = studentgekozen.get(i);
                    studentgekozen.remove(i);
                    studentoptie.addElement(student);
                    optie.setModel(studentoptie);
                    gekozen.setModel(studentgekozen);
                }
               }
    }
           );
            
    JButton right = new JButton(new ImageIcon(getClass().getResource("/resources/next.png")));
            right.setToolTipText("right");
            right.setSelected(true);
    right.addActionListener(new ActionListener() 
    {
            @Override
        public void actionPerformed(ActionEvent e) {
                
                if (optie.getSelectedValue() == null)
                        {
                        }
                else
                {
                int i;
                i = 0;
                Studenten student = new Studenten();
                i =  optie.getSelectedIndex();
                student = studentoptie.get(i);
                studentoptie.remove(i);
                studentgekozen.addElement(student);
                optie.setModel(studentoptie);
                gekozen.setModel(studentgekozen);
               }
               }
    }
            );
    
            overdracht.add(left, BorderLayout.NORTH);
            overdracht.add(right, BorderLayout.SOUTH);
            
            
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
                if((positie +1) > (contractlist.size()-1))
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
                positie = contractlist.size() - 1;
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
                Huurcontract contract = new Huurcontract();
                Date datum ;
                int ID;
                studentgekozen.removeAllElements();
                studentoptie.removeAllElements();
                
                Studio studio = new Studio();
                studio = cboStudio.getItemAt(0);
                   
                
                contract = contractlist.get(contractlist.size()-1);
                ID = contract.getcontractID() + 1;
                contract = contractlist.get(positie);
                txtContractID.setText(Integer.toString(ID)); 
                datum = contract.getbegindatum();
                txtBegindatum.setText("");
                txtHuurprijs.setText(Double.toString(studio.gethuurprijs()));
                datum = contract.geteinddatum();
                txtEinddatum.setText("");
                txtWaarborg.setText("");
                
                for (Studenten s: studentlist)
                {
                    studentoptie.addElement(s);
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
          
                
                
                int ID = Integer.parseInt(txtContractID.getText());
                int gebid;
                int size = gebouwlist.size();
                int i = 0;
                int a = 0;
                studentcontract studcon = new studentcontract();
                studcon.setcontractid(Integer.parseInt(txtContractID.getText()));
                        connstudcon.Huurcontractdelete(studcon);
                while (i <= size)
                {
                    gebid = contractlist.get(i).getcontractID();
                    if(nieuw == true)
                    {
                        Huurcontract contract = new Huurcontract();
                        int o;
                        Studio studio = new Studio();
                        studcon = new studentcontract();
                        
                        
                        contract.setcontractID(Integer.parseInt(txtContractID.getText()));
                        contract.setbegindatum(Date.valueOf(txtBegindatum.getText()));
                        contract.seteinddatum(Date.valueOf(txtEinddatum.getText()));
                        contract.sethuurprijs(Double.parseDouble(txtHuurprijs.getText()));
                        contract.setwaarborg(Double.parseDouble(txtWaarborg.getText()));
                        o = cboStudio.getSelectedIndex();
                        studio = studiolist.get(o);
                        contract.setstudioid(studio.getstudioid());
                        conncon.Huurcontractnieuwopslaan(contract);
                        studcon.setcontractid(Integer.parseInt(txtContractID.getText()));
                        
                         while (a <= (studentgekozen.size()-1))
                        {
                            
                            Studenten student = new Studenten();
                            student = studentgekozen.get(a);
                            studcon.setcontractid(contract.getcontractID());
                            studcon.setstudentid(student.getstudentid());
                            connstudcon.Huurcontractnieuwopslaan(studcon);
                            a++;
                        }
                        
                        positie = contractlist.size()-1;
                        
                        ophalen();
                        vullen(positie);
                        nieuw = false;
                        break; 
                    
                    }
                    if(ID == gebid)
                    {
                        int o;
                        Studio studio = new Studio();
                        Huurcontract contract = new Huurcontract();
                        studcon = new studentcontract();
                        
                        contract.setcontractID(Integer.parseInt(txtContractID.getText()));
                        contract.setbegindatum(Date.valueOf(txtBegindatum.getText()));
                        contract.seteinddatum(Date.valueOf(txtEinddatum.getText()));
                        contract.sethuurprijs(Double.parseDouble(txtHuurprijs.getText()));
                        contract.setwaarborg(Double.parseDouble(txtWaarborg.getText()));
                        o = cboStudio.getSelectedIndex();
                        studio = studiolist.get(o);                        

                        studcon.setcontractid(Integer.parseInt(txtContractID.getText()));
                        conncon.Huurcontractaanpassen(contract);
                        
                         while (a <= (studentgekozen.size()-1))
                        {
                            studcon = new studentcontract();
                            Studenten student = new Studenten();
                            student = studentgekozen.get(a);
                            studcon.setcontractid(contract.getcontractID());
                            studcon.setstudentid(student.getstudentid());
                            connstudcon.Huurcontractnieuwopslaan(studcon);
                            a++;
                        }
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
                int response = JOptionPane.showConfirmDialog(null, "Ben u zeker dat u dit contract wilt verwijderen?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
  
                        Huurcontract contract = new Huurcontract();
                        contract.setcontractID(Integer.parseInt(txtContractID.getText()));
                        contract.setbegindatum(Date.valueOf(txtBegindatum.getText()));
                        contract.seteinddatum(Date.valueOf(txtEinddatum.getText()));
                        contract.sethuurprijs(Double.parseDouble(txtHuurprijs.getText()));
                        contract.setwaarborg(Double.parseDouble(txtWaarborg.getText()));
                        conncon.Huurcontractdelete(contract);
                        studentcontract studcon = new studentcontract();
                        studcon.setcontractid(Integer.parseInt(txtContractID.getText()));
                        connstudcon.Huurcontractdelete(studcon);
                        
                        
                        
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
gbc_buttonbar .gridy = 8;
gbc_buttonbar .gridwidth = java.awt.GridBagConstraints.REMAINDER;
gbc_buttonbar .gridheight = java.awt.GridBagConstraints.REMAINDER;
add(buttonbar, gbc_buttonbar );
    
    ophalen();
    vullen(positie);
    cbogebouwvullen();
        } catch (ParseException ex) {
            Logger.getLogger(GuiHuurcontract.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
        public void ophalen()
        {
            studconlist = connstudcon.VulStudContract();
            studentlist = connstudent.VulStudent();
            contractlist = conncon.VulContract();
            gebouwlist = conngeb.Vulgebouw();
            studiolist = connstud.Vulstudio();
        }
        
        
        
        public void vullen(int positie)
        {       
              Gebouw Gebouw = new Gebouw();
              Studenten student = new Studenten();
              Studio studio = new Studio();
              Huurcontract contract = new Huurcontract();
              studentcontract studcon = new studentcontract();
              Date datum;
              int i;
              int e;
             
             
              
              i = 0;
              e = 0;
              
              
              contract = contractlist.get(positie);
              
              txtContractID.setText(Integer.toString(contract.getcontractID())); 
              datum = contract.getbegindatum();
              txtBegindatum.setText(datum.toString());
              txtHuurprijs.setText(Double.toString(contract.gethuurprijs()));
              datum = contract.geteinddatum();
              txtEinddatum.setText(datum.toString());
              txtWaarborg.setText(Double.toString(contract.getwaarborg()));
              
                for(Studio c: studiolist)
              {
                  if(contract.getstudioid() == c.getstudioid())
                  {
                      
                      studio = c;
                  }
              }
              
              for(Gebouw g: gebouwlist)
              {
                  if(studio.getgebouwid() == g.getGebouwID())
                  {
                      cboGebouw.setSelectedItem(g);
                      cboStudio.setSelectedItem(studio);
                  }
              }     
              
              
              studentgekozen.removeAllElements();
              studentoptie.removeAllElements();
              
              for (Studenten s : studentlist) {
                  boolean opContract = false;
                  for (studentcontract c : studconlist)
                  {
                      if (contract.getcontractID() == c.getcontractid() && c.getstudentid() == s.getstudentid()) {
                          opContract = true;
                          break;
                      }
                  }
                  if (opContract)
                      studentgekozen.addElement(s);
                  else
                      studentoptie.addElement(s);
              }
 
             optie.setModel(studentoptie);
             gekozen.setModel(studentgekozen);
              
        }
        
        
    @Override
        public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource() == cboGebouw)
                {
                    
                    int i;
                    i = 0;
                    int o;
                    o = 0;
                    cboStudio.removeAllItems();
                    aangepast = true;
                    while(i<=(studiolist.size()-1))
                    {
                      
                       
                        Studio studio = new Studio();
                        Gebouw gebouw  = new Gebouw();
                        studio = studiolist.get(i);
                        o = cboGebouw.getSelectedIndex();
                        gebouw = cboGebouw.getItemAt(o);
                        if(gebouw.getGebouwID() == studio.getgebouwid())
                        {
                            cboStudio.addItem(studio);
                        }
                       
                       
                      i++;
                    }
                    if(nieuw)
                    {
                       Studio studio = new Studio();
                       studio = cboStudio.getItemAt(0);
                       txtHuurprijs.setText(Double.toString(studio.gethuurprijs()));
                    }
                    
                }
                if(e.getSource() == cboStudio)
                {
                    
                    if(nieuw && cboStudio.getSelectedItem() != null)
                    {
                        int ID;
                        Studio studio = new Studio();
                        ID = cboStudio.getSelectedIndex();
                        studio = cboStudio.getItemAt(ID);
                        txtHuurprijs.setText(Double.toString(studio.gethuurprijs()));
                    }
                    
                    
                }
			
	}
    
    public void cbogebouwvullen()
    {
        int i;
        cboGebouw.removeAllItems();
        i = 0;
              while (i <= (gebouwlist.size()-1))
              {
                  Gebouw gebouw = new Gebouw();
                  gebouw = gebouwlist.get(i);
                  cboGebouw.addItem(gebouw);
                  i++;
              }
    }
        
}
