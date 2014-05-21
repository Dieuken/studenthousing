package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;

public class Hoofdmenu extends JFrame {

	private Backgroundpanel background = new Backgroundpanel();
	private GuiGebouw gebouw = new GuiGebouw();
	private JPanel contentPane = new JPanel(new CardLayout());
	private CardLayout cl =(CardLayout)(contentPane.getLayout());
	private GuiStudio studio = new GuiStudio();
        private GuiStudent student = new GuiStudent();
        private GuiHuurcontract contract = new GuiHuurcontract();
        private GuiGebruikers gebruikers = new GuiGebruikers();
        private Logon login;
        private String type;

        
	/**
	 * Launch the application.
	 */
	
	public Hoofdmenu(Logon logon)
	{
                
                login = logon;
                login.setHoofdmenu(this);
		try {
			setIconImage(ImageIO.read(getClass().getResource("/resources/logo1.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		contentPane.setLayout(cl);
		contentPane.add(background, "background");
		contentPane.add(gebouw, "gebouw");
		contentPane.add(student, "student");
                contentPane.add(studio, "studio");
                contentPane.add(contract, "contract");
                contentPane.add(gebruikers, "gebruiker");
		cl.show(contentPane,"background");
		add(contentPane);
		
		setTitle("Student Housing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
                
                
                
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
                
                JButton menuBackground = new JButton(new ImageIcon(getClass().getResource("/resources/logo1.png")));
		menuBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(contentPane, "background");
		        
			}
		});
		menuBar.add(menuBackground);
		
		JButton menuGebouwen = new JButton("Gebouwen");
		menuGebouwen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(contentPane, "gebouw");
		        
			}
		});
		menuBar.add(menuGebouwen);
		
		JButton menuStudios = new JButton("Studio's");
		menuBar.add(menuStudios);
		menuStudios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(contentPane, "studio");
			}
		});
		
		JButton menuStudenten = new JButton("Studenten");
		menuBar.add(menuStudenten);
                menuStudenten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(contentPane, "student");
			}
		});
		
		JButton menuHuurcontracten = new JButton("Huurcontracten");
		menuHuurcontracten.setMnemonic('H');
		menuBar.add(menuHuurcontracten);
                menuHuurcontracten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(contentPane, "contract");
			}
		});
                
                JButton menuGebruiker = new JButton("Gebruiker");
		menuGebruiker.setMnemonic('G');
		menuBar.add(menuGebruiker);
                menuGebruiker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                           
                            if(type.equals("Admin"))
                            {
                               cl.show(contentPane, "gebruiker");
                              
                            }
                            else if(type.equals("Medewerker"))
                            {
                               JOptionPane.showMessageDialog(null, "Onvoldoende machtiging");
                            }
			}
		});
                
		
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic('H');
		menuBar.add(menuHelp);
		
		JMenuItem menuitemHulp = new JMenuItem("Hulp");
		menuHelp.add(menuitemHulp);
		
		JMenuItem menuitemOver = new JMenuItem("Over");
		menuitemOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog( null, "Created by:\nDe Geest Kevin\nDieu Stef\nSeghers Matthias\n\n2012(c)");
			}
		});
                
                JMenuItem menuLog = new JMenuItem("Logout");
		menuHelp.setMnemonic('L');
		menuBar.add(menuLog);
                menuLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
                                cl.show(contentPane, "background");
                                login.setVisible(true);
                                
			}
		});
		
		menuHelp.add(menuitemOver);
		setSize(700,700);
        setVisible(false);
		
		
	}
        public void setType(String accounttype)
        {
            type = accounttype;
            
        }

}
