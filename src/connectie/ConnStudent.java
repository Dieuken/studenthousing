package connectie;

import java.sql.*;
import java.util.ArrayList;
import programma.Studenten;

public class ConnStudent 
{
    public ArrayList<Studenten> VulStudent()
    {
        ArrayList<Studenten> studentenlist = new ArrayList<Studenten>();
        int studentID;
        String voornaam;
        String naam;
        String geboortedatum;
        String school;
        String schooljaar;
        String telefoon;
        String email;
        String telefoonouders;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            
            Statement stat = conn.createStatement();

            
            ResultSet rs = stat.executeQuery("SELECT * FROM Student");

            
            while (rs.next()) {

                
                studentID = rs.getInt("StudentID");
                voornaam = rs.getString("Voornaam");
                naam = rs.getString("Naam");
                geboortedatum = rs.getString("Geboortedatum");
                school = rs.getString("School");
                schooljaar = rs.getString("Jaar");
                telefoon = rs.getString("telefoon");
                email = rs.getString("Email");
                telefoonouders = rs.getString("TelefoonOuders");
                
                
               

               Studenten student = new Studenten(studentID, voornaam, naam, geboortedatum, school, schooljaar, telefoon, email, telefoonouders);
               
               studentenlist.add(student);
            }

           
            rs.close();

            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } 
        return studentenlist;   
    }

    public void Studentnieuwopslaan(Studenten student)
    {
        int studentID;
        String voornaam;
        String naam;
        String geboortedatum;
        String school;
        String schooljaar;
        String telefoon;
        String email;
        String telefoonouders;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            studentID = student.getstudentid();
            voornaam = student.getvoornaam();
            naam = student.getnaam();
            geboortedatum = student.getgeboortedatum();
            school = student.getschool();
            schooljaar = student.getschooljaar();
            telefoon = student.gettelefoon();
            email = student.getemail();
            telefoonouders = student.gettelefoonouders();
            
           
            
            PreparedStatement nieuwstudent = conn.prepareStatement("INSERT INTO Student VALUES(?,?,?,?,?,?,?,?,?)");
            nieuwstudent.setInt(1, studentID);
            nieuwstudent.setString(2, voornaam);
            nieuwstudent.setString(3, naam);
            nieuwstudent.setString(4, geboortedatum);
            nieuwstudent.setString(5, school);
            nieuwstudent.setString(6, schooljaar);
            nieuwstudent.setString(7, telefoon);
            nieuwstudent.setString(8, email);
            nieuwstudent.setString(9, telefoonouders);
            
            
            
            nieuwstudent.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Studentaanpassen(Studenten student)
    {
        int studentID;
        String voornaam;
        String naam;
        String geboortedatum;
        String school;
        String schooljaar;
        String telefoon;
        String email;
        String telefoonouders;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            studentID = student.getstudentid();
            voornaam = student.getvoornaam();
            naam = student.getnaam();
            geboortedatum = student.getgeboortedatum();
            school = student.getschool();
            schooljaar = student.getschooljaar();
            telefoon = student.gettelefoon();
            email = student.getemail();
            telefoonouders = student.gettelefoonouders();
            

            PreparedStatement voornaamaanpassen = conn.prepareStatement("UPDATE Student SET Voornaam = ? WHERE StudentID = ?");
            PreparedStatement naamaanpassen = conn.prepareStatement("UPDATE Student SET Naam = ? WHERE StudentID = ?");
            PreparedStatement geboortedatumaanpassen = conn.prepareStatement("UPDATE Student SET Geboortedatum = ? WHERE StudentID = ?");
            PreparedStatement schoolaanpassen = conn.prepareStatement("UPDATE Student SET School = ? WHERE StudentID = ?");
            PreparedStatement schooljaaraanpassen = conn.prepareStatement("UPDATE Student SET Schooljaar = ? WHERE StudentID = ?");
            PreparedStatement telefoonaanpassen = conn.prepareStatement("UPDATE Student SET Telefoon = ? WHERE StudentID = ?");
            PreparedStatement emailaanpassen = conn.prepareStatement("UPDATE Student SET Email = ? WHERE StudentID = ?");
            PreparedStatement telefoonoudersaanpassen = conn.prepareStatement("UPDATE Student SET TelefoonOuders = ? WHERE StudentID = ?");
            
            voornaamaanpassen.setString(1, voornaam);
            voornaamaanpassen.setInt(2, studentID);
            voornaamaanpassen.executeUpdate();
            
            naamaanpassen.setString(1, naam);
            naamaanpassen.setInt(2, studentID);
            naamaanpassen.executeUpdate();
            
            geboortedatumaanpassen.setString(1, geboortedatum);
            geboortedatumaanpassen.setInt(2, studentID);
            geboortedatumaanpassen.executeUpdate();
            
            schoolaanpassen.setString(1, school);
            schoolaanpassen.setInt(2, studentID);
            schoolaanpassen.executeUpdate();
            
            schooljaaraanpassen.setString(1, schooljaar);
            schooljaaraanpassen.setInt(2, studentID);
            schooljaaraanpassen.executeUpdate();
            
            telefoonaanpassen.setString(1, telefoon);
            telefoonaanpassen.setInt(2, studentID);
            telefoonaanpassen.executeUpdate();
            
            emailaanpassen.setString(1, email);
            emailaanpassen.setInt(2,studentID);
            emailaanpassen.executeUpdate();
            
            telefoonoudersaanpassen.setString(1, telefoonouders);
            telefoonoudersaanpassen.setInt(2, studentID);
            telefoonoudersaanpassen.executeUpdate();
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Studentdelete(Studenten student)
    {
        int studentID;
     
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            studentID = student.getstudentid();
            
            
            PreparedStatement studentDelete = conn.prepareStatement("DELETE FROM Student WHERE StudentID = ?");
            
            studentDelete.setInt(1, studentID);
            studentDelete.executeUpdate();
            
            
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }    
    }
    
}
