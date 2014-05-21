    package gui;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.io.UnsupportedEncodingException;
    import java.sql.*;
    import java.security.*;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import programma.Converter;
    import connectie.ConnGebruiker;
    import java.text.ParseException;
    import java.util.ArrayList;
    import programma.Gebruiker;


    public class Logon extends JFrame
    {

        private ConnGebruiker conn = new ConnGebruiker();
        private ArrayList<Gebruiker> gebruikerlist;
        private Hoofdmenu hoofdmenu;
        private Converter convert = new Converter();
        private JTextField text1 = new JTextField();
        private JPasswordField text2 = new JPasswordField();

        public static void main(String arg[]){
                Logon logon = new Logon(); 
            }

        public Logon() {
            JButton SUBMIT;
            

            JLabel label1,label2;
            final JTextField text1;
            final JPasswordField text2;


            new Hoofdmenu(this);

            setResizable(false);
            GridBagLayout gridBagLayout = new GridBagLayout();
            gridBagLayout.columnWidths = new int[]{0, 100, 0};
            gridBagLayout.rowHeights = new int[]{0, 20, 20, 20, 0};
            gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
            gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
            setLayout(gridBagLayout);

            label1 = new JLabel();
            label1.setText("Gebruikersnaam:");
            GridBagConstraints gbc_label1 = new GridBagConstraints();
            gbc_label1.fill = GridBagConstraints.BOTH;
            gbc_label1.insets = new Insets(0, 0, 5, 5);
            gbc_label1.gridx = 0;
            gbc_label1.gridy = 0;
            add(label1, gbc_label1);

            text1 = new JTextField(25);
            GridBagConstraints gbc_text1 = new GridBagConstraints();
            gbc_text1.anchor = GridBagConstraints.NORTH;
            gbc_text1.fill = GridBagConstraints.HORIZONTAL;
            gbc_text1.insets = new Insets(0, 0, 5, 0);
            gbc_text1.gridx = 1;
            gbc_text1.gridy = 0;
            add(text1, gbc_text1);

            label2 = new JLabel();
            label2.setText("Wachtwoord:");
            GridBagConstraints gbc_label2 = new GridBagConstraints();
            gbc_label2.fill = GridBagConstraints.BOTH;
            gbc_label2.insets = new Insets(0, 0, 5, 5);
            gbc_label2.gridx = 0;
            gbc_label2.gridy = 1;
            add(label2, gbc_label2);

            text2 = new JPasswordField(25);
            GridBagConstraints gbc_text2 = new GridBagConstraints();
            gbc_text2.anchor = GridBagConstraints.NORTH;
            gbc_text2.fill = GridBagConstraints.HORIZONTAL;
            gbc_text2.insets = new Insets(0, 0, 5, 0);
            gbc_text2.gridx = 1;
            gbc_text2.gridy = 1;
            add(text2, gbc_text2);

            SUBMIT=new JButton("Login");
            GridBagConstraints gbc_SUBMIT = new GridBagConstraints();
            gbc_SUBMIT.insets = new Insets(0, 0, 5, 0);
            gbc_SUBMIT.fill = GridBagConstraints.BOTH;
            gbc_SUBMIT.gridx = 1;
            gbc_SUBMIT.gridy = 2;
            add(SUBMIT, gbc_SUBMIT);

            gebruikerlist = conn.Vulgebruiker();

            SUBMIT.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent login){
                            String value1=text1.getText();
                            String value2=text2.getText();


                        if (value1.length() > 0)
                        {
                            if (value2.length() > 0)
                            {
                                if (value2.length()>6)
                                {
                                    try {
                                        value2 = convert.MD5(value2);
                                            } catch (NoSuchAlgorithmException ex) {
                                                Logger.getLogger(Logon.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (UnsupportedEncodingException ex) {
                                                Logger.getLogger(Logon.class.getName()).log(Level.SEVERE, null, ex);
                                            }





                                    for (Gebruiker g : gebruikerlist) 
                                    {


                                            


                                            if(value1.equals(g.getGebruikersnaam())&& value2.equals(g.getWachtwoord()))
                                            {
                                                    
                                                    JOptionPane.showMessageDialog(null, "Welcome "+value1+".");
                                                    setVisible(false);
                                                    text1.setText("");
                                                    text2.setText("");
                                                    hoofdmenu.setVisible(true);
                                                    hoofdmenu.setType(g.getAccounttype());
                                            }
                                            
                                    }
//                                    JOptionPane.showMessageDialog(null, "Foutieve gebruikersnaam of wachtwoord.","ERROR",JOptionPane.ERROR_MESSAGE);
//                                                    text2.setText("");
                                    }
                                    else
                                    {
                                      JOptionPane.showMessageDialog(null, "Het wachtwoord moet minstens 6 tekens bevatten!");  
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Gelieve een wachtwoord in te vullen.");
                                }
                            
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Gelieve een gebruikersnaam in te vullen.");
                            }
                        }
                    });
            this.setSize(332,165);
            this.setVisible(true);

            }
            public void setHoofdmenu(Hoofdmenu hoofdmenu) {
                    this.hoofdmenu = hoofdmenu;
            }
            

    }


