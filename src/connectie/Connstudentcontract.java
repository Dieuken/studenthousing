package connectie;

import java.sql.*;
import java.util.ArrayList;
import programma.studentcontract;

public class Connstudentcontract 
{
     public ArrayList<studentcontract> VulStudContract()
    {
        ArrayList<studentcontract> studcontractlist = new ArrayList<studentcontract>();
        int contractID;
        int studentID;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            

            // Vervolgens voeren we een SELECT query uit om de tabel PRODUCT uit te lezen.
            // SELECT queries voer je uit met de methode executeQuery().
            // De returnwaarde is een ResultSet object dat het antwoord op de query (in tabelvorm) voorstelt.
            ResultSet rs = stat.executeQuery("SELECT * FROM studentcontract");

            // De ResultSet overlopen doe je met onderstaande lus.
            // De methode next() verplaatst de cursor van de ResultSet naar de volgende lijn en geeft terug of er nog een lijn was.
            // De cursor begint vÃ³Ã³r de eerste lijn, we moeten next() dus altijd gebruiken, ook als er maar 1 lijn is.
            while (rs.next()) {

                // Om de waarden op de huidige rij uit te lezen, gebruik je de methoden getXxx().
                // De Xxx vervang je door het gepaste datatype.
                // Als argument kan je zowel de kolomnaam als het kolomnummer (vanaf 1) meegeven.
                contractID = rs.getInt("ContractID");
                studentID = rs.getInt("StudentID");
                
               studentcontract studcontract = new studentcontract(studentID, contractID);
               
                studcontractlist.add(studcontract);
            }

            // Een ResultSet sluiten we onmiddelijk af wanneer we er klaar mee zijn.
            // Dit kan het beste d.m.v. de try-with-resources, zoals bij het aanmaken van de Connection.
            // Om het voorbeeld eenvoudig te houden, hebben we deze techniek hier niet opnieuw toegepast.
            // Dit is wel het geval in de volgende voorbeelden.
            rs.close();

            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } 
        return studcontractlist;   
    }

    public void Huurcontractnieuwopslaan(studentcontract studcontract)
    {
        int contractID;
        int studentID;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            contractID = studcontract.getcontractid();
            studentID = studcontract.getstudentid();

            
            PreparedStatement nieuwstudentcontract = conn.prepareStatement("INSERT INTO studentcontract VALUES(?,?)");
            nieuwstudentcontract.setInt(1, contractID);
            nieuwstudentcontract.setInt(2, studentID);
          
            
            nieuwstudentcontract.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Huurcontractaanpassen(studentcontract studcontract)
    {
        int contractID;
        int studentID;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            contractID = studcontract.getcontractid();
            studentID = studcontract.getstudentid();
            


            PreparedStatement studentIDaanpassen = conn.prepareStatement("UPDATE studentcontract SET studentID = ? WHERE ContractID = ?");
            
            
            
           studentIDaanpassen.setDouble(1, studentID);
            studentIDaanpassen.setInt(2, contractID);
            studentIDaanpassen.executeUpdate();
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Huurcontractdelete(studentcontract studcontract)
    {
        int contractID;
     
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            contractID = studcontract.getcontractid();
            
            
            PreparedStatement HuurcontractDelete = conn.prepareStatement("DELETE FROM studentcontract WHERE ContractID = ?");
            
            HuurcontractDelete.setInt(1, contractID);
            HuurcontractDelete.executeUpdate();
            
            
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }    
    }
}
