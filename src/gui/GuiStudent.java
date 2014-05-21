package gui;



import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import programma.Studenten;
import connectie.ConnStudent;
import java.util.ArrayList;


public class GuiStudent extends JPanel {
	private JTextField txtStudentID;
	private JTextField txtNaam;
	private JTextField txtVoornaam;
	private JTextField txtGeboortedatum;
	private JTextField txtSchool;
	private JTextField txtSchooljaar;
	private JTextField txtTelefoon;
	private JTextField txtEmail;
	private JTextField txtTelefoonOuders;
        
         private ArrayList<Studenten> studentenlist;
        private ConnStudent conn = new ConnStudent();
        private int positie;
        private boolean nieuw;
        
        
	/**
	 * Create the panel.
	 */
	public GuiStudent() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 28, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		GridBagConstraints gbc_lblStudentId = new GridBagConstraints();
		gbc_lblStudentId.insets = new Insets(0, 0, 5, 5);
		gbc_lblStudentId.anchor = GridBagConstraints.EAST;
		gbc_lblStudentId.gridx = 0;
		gbc_lblStudentId.gridy = 0;
		add(lblStudentId, gbc_lblStudentId);
		
		txtStudentID = new JTextField();
		GridBagConstraints gbc_txtStudentID = new GridBagConstraints();
		gbc_txtStudentID.insets = new Insets(0, 0, 5, 5);
		gbc_txtStudentID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStudentID.gridx = 1;
		gbc_txtStudentID.gridy = 0;
		add(txtStudentID, gbc_txtStudentID);
		txtStudentID.setColumns(10);
                txtStudentID.setEditable(false);
		
		JLabel lblNaam = new JLabel("Naam: ");
		GridBagConstraints gbc_lblNaam = new GridBagConstraints();
		gbc_lblNaam.anchor = GridBagConstraints.EAST;
		gbc_lblNaam.insets = new Insets(0, 0, 5, 5);
		gbc_lblNaam.gridx = 0;
		gbc_lblNaam.gridy = 1;
		add(lblNaam, gbc_lblNaam);
		
		txtNaam = new JTextField();
		GridBagConstraints gbc_txtNaam = new GridBagConstraints();
		gbc_txtNaam.insets = new Insets(0, 0, 5, 5);
		gbc_txtNaam.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNaam.gridx = 1;
		gbc_txtNaam.gridy = 1;
		add(txtNaam, gbc_txtNaam);
		txtNaam.setColumns(10);
		
		JLabel lblVoornaam = new JLabel("Voornaam: ");
		GridBagConstraints gbc_lblVoornaam = new GridBagConstraints();
		gbc_lblVoornaam.anchor = GridBagConstraints.EAST;
		gbc_lblVoornaam.insets = new Insets(0, 0, 5, 5);
		gbc_lblVoornaam.gridx = 2;
		gbc_lblVoornaam.gridy = 1;
		add(lblVoornaam, gbc_lblVoornaam);
		
		txtVoornaam = new JTextField();
		GridBagConstraints gbc_txtVoornaam = new GridBagConstraints();
		gbc_txtVoornaam.insets = new Insets(0, 0, 5, 5);
		gbc_txtVoornaam.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVoornaam.gridx = 3;
		gbc_txtVoornaam.gridy = 1;
		add(txtVoornaam, gbc_txtVoornaam);
		txtVoornaam.setColumns(10);
		
		JLabel lblGeboortejaar = new JLabel("Geboortejaar:");
		GridBagConstraints gbc_lblGeboortejaar = new GridBagConstraints();
		gbc_lblGeboortejaar.anchor = GridBagConstraints.EAST;
		gbc_lblGeboortejaar.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeboortejaar.gridx = 0;
		gbc_lblGeboortejaar.gridy = 2;
		add(lblGeboortejaar, gbc_lblGeboortejaar);
		
		txtGeboortedatum = new JTextField();
		GridBagConstraints gbc_txtGeboortedatum = new GridBagConstraints();
		gbc_txtGeboortedatum.insets = new Insets(0, 0, 5, 5);
		gbc_txtGeboortedatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGeboortedatum.gridx = 1;
		gbc_txtGeboortedatum.gridy = 2;
		add(txtGeboortedatum, gbc_txtGeboortedatum);
		txtGeboortedatum.setColumns(10);
		
		JLabel lblSchool = new JLabel("School:");
		GridBagConstraints gbc_lblSchool = new GridBagConstraints();
		gbc_lblSchool.anchor = GridBagConstraints.EAST;
		gbc_lblSchool.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchool.gridx = 0;
		gbc_lblSchool.gridy = 3;
		add(lblSchool, gbc_lblSchool);
		
		txtSchool = new JTextField();
		GridBagConstraints gbc_txtSchool = new GridBagConstraints();
		gbc_txtSchool.insets = new Insets(0, 0, 5, 5);
		gbc_txtSchool.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSchool.gridx = 1;
		gbc_txtSchool.gridy = 3;
		add(txtSchool, gbc_txtSchool);
		txtSchool.setColumns(10);
		
		JLabel lblSchooljaar = new JLabel("Schooljaar:");
		GridBagConstraints gbc_lblSchooljaar = new GridBagConstraints();
		gbc_lblSchooljaar.anchor = GridBagConstraints.EAST;
		gbc_lblSchooljaar.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchooljaar.gridx = 2;
		gbc_lblSchooljaar.gridy = 3;
		add(lblSchooljaar, gbc_lblSchooljaar);
		
		txtSchooljaar = new JTextField();
		GridBagConstraints gbc_txtSchooljaar = new GridBagConstraints();
		gbc_txtSchooljaar.insets = new Insets(0, 0, 5, 5);
		gbc_txtSchooljaar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSchooljaar.gridx = 3;
		gbc_txtSchooljaar.gridy = 3;
		add(txtSchooljaar, gbc_txtSchooljaar);
		txtSchooljaar.setColumns(10);
		
		JLabel lblTelefoon = new JLabel("Telefoon Student: ");
		GridBagConstraints gbc_lblTelefoon = new GridBagConstraints();
		gbc_lblTelefoon.anchor = GridBagConstraints.EAST;
		gbc_lblTelefoon.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefoon.gridx = 0;
		gbc_lblTelefoon.gridy = 4;
		add(lblTelefoon, gbc_lblTelefoon);
		
		txtTelefoon = new JTextField();
		GridBagConstraints gbc_txtTelefoon = new GridBagConstraints();
		gbc_txtTelefoon.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefoon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefoon.gridx = 1;
		gbc_txtTelefoon.gridy = 4;
		add(txtTelefoon, gbc_txtTelefoon);
		txtTelefoon.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 5;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefoonOuders = new JLabel("Telefoon Ouders:");
		GridBagConstraints gbc_lblTelefoonOuders = new GridBagConstraints();
		gbc_lblTelefoonOuders.anchor = GridBagConstraints.EAST;
		gbc_lblTelefoonOuders.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefoonOuders.gridx = 0;
		gbc_lblTelefoonOuders.gridy = 6;
		add(lblTelefoonOuders, gbc_lblTelefoonOuders);
		
		txtTelefoonOuders = new JTextField();
		GridBagConstraints gbc_txtTelefoonOuders = new GridBagConstraints();
		gbc_txtTelefoonOuders.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefoonOuders.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefoonOuders.gridx = 1;
		gbc_txtTelefoonOuders.gridy = 6;
		add(txtTelefoonOuders, gbc_txtTelefoonOuders);
		txtTelefoonOuders.setColumns(10);
		
		

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
                    if((positie +1) > (studentenlist.size()-1))
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
                    positie = studentenlist.size() - 1;
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
              int ID;
              Studenten student = new Studenten();
              student = studentenlist.get(studentenlist.size()-1);
              ID = student.getstudentid() + 1;
              txtStudentID.setText(Integer.toString(ID));
              txtVoornaam.setText("");
              txtNaam.setText("");
              txtGeboortedatum.setText("");
              txtSchool.setText("");
              txtSchooljaar.setText("");
              txtTelefoon.setText("");
              txtEmail.setText("");
              txtTelefoonOuders.setText("");
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
              
                    int ID = Integer.parseInt(txtStudentID.getText());
                    int studid;
                    int size = studentenlist.size();
                    int i = 0;
                    while (i <= size)
                    {
                        studid = studentenlist.get(i).getstudentid();
                        if(nieuw == true)
                        {
                             Studenten student = new Studenten();
                            student.setstudentid(Integer.parseInt(txtStudentID.getText()));
                            student.setvoornaam(txtVoornaam.getText());
                            student.setnaam(txtNaam.getText());
                            student.setgeboortedatum(txtGeboortedatum.getText());
                            student.setschool(txtSchool.getText());
                            student.setschooljaar(txtSchooljaar.getText());
                            student.settelefoon(txtTelefoon.getText());
                            student.setemail(txtEmail.getText());
                            student.settelefoonouders(txtTelefoonOuders.getText());
                            
                            conn.Studentnieuwopslaan(student);
                            
                            ophalen();
                            positie = studentenlist.size()-1 ;
                            vullen(positie);
                            nieuw = false;
                            break; 
                        
                        }
                        if(ID == studid)
                        {
                             Studenten student = new Studenten();
                            student.setstudentid(Integer.parseInt(txtStudentID.getText()));
                            student.setvoornaam(txtVoornaam.getText());
                            student.setnaam(txtNaam.getText());
                            student.setgeboortedatum(txtGeboortedatum.getText());
                            student.setschool(txtSchool.getText());
                            student.setschooljaar(txtSchooljaar.getText());
                            student.settelefoon(txtTelefoon.getText());
                            student.setemail(txtEmail.getText());
                            student.settelefoonouders(txtTelefoonOuders.getText());
                            
                            conn.Studentaanpassen(student);
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
                    int response = JOptionPane.showConfirmDialog(null, "Ben u zeker dat u deze student wilt verwijderen?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
                            Studenten student = new Studenten();
                            student.setstudentid(Integer.parseInt(txtStudentID.getText()));
                            student.setvoornaam(txtVoornaam.getText());
                            student.setnaam(txtNaam.getText());
                            student.setgeboortedatum(txtGeboortedatum.getText());
                            student.setschool(txtSchool.getText());
                            student.setschooljaar(txtSchooljaar.getText());
                            student.settelefoon(txtTelefoon.getText());
                            student.setemail(txtEmail.getText());
                            student.settelefoonouders(txtTelefoonOuders.getText());
                            
                            conn.Studentdelete(student);
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
    gbc_buttonbar .gridy = 12;
    gbc_buttonbar .gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gbc_buttonbar .gridheight = java.awt.GridBagConstraints.REMAINDER;
    add(buttonbar, gbc_buttonbar );
	
        positie = 0;
        
        ophalen();
        vullen(positie);
        nieuw = false;
        }

        
        public void ophalen()
        {

            studentenlist = conn.VulStudent();
        }
        
        
        
        public void vullen(int positie)
        {       
              Studenten student = new Studenten();
              
              student = studentenlist.get(positie);
              txtStudentID.setText(Integer.toString(student.getstudentid()));
              txtVoornaam.setText(student.getvoornaam());
              txtNaam.setText(student.getnaam());
              txtGeboortedatum.setText(student.getgeboortedatum());
              txtSchool.setText(student.getschool());
              txtSchooljaar.setText(student.getschooljaar());
              txtTelefoon.setText(student.gettelefoon());
              txtEmail.setText(student.getemail());
              txtTelefoonOuders.setText(student.gettelefoonouders());
              
              
             
        }
}
