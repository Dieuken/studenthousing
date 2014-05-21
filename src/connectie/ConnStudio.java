package connectie;

import java.sql.*;
import java.util.ArrayList;
import programma.Studio;


public class ConnStudio 
{   
   
    public void studiodelete(Studio studio)
    {
       int studioID;
     
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            studioID = studio.getstudioid();
            
            PreparedStatement StudioDelete = conn.prepareStatement("DELETE FROM Studio WHERE StudioID = ?");
            
            StudioDelete.setInt(1, studioID);
            StudioDelete.executeUpdate();
            
            
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }    
    }
    public void studioaanpassen(Studio studio)
    {
      int studioID;
        int gebouwID;
        String oppervlakte;
        String inrichting;
        double huurprijs;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            studioID = studio.getstudioid();
            gebouwID = studio.getgebouwid();
            oppervlakte = studio.getoppervlakte();
            inrichting = studio.getinrichting();
            huurprijs = studio.gethuurprijs();

            
            PreparedStatement GebouwIDaanpassen = conn.prepareStatement("UPDATE Studio SET GebouwID = ? WHERE StudioID = ?");
            PreparedStatement oppervlakteaanpassen = conn.prepareStatement("UPDATE Studio SET Oppervlakte = ? WHERE StudioID = ?");
            PreparedStatement inrichtingaanpassen = conn.prepareStatement("UPDATE Studio SET Inrichting = ? WHERE StudioID = ?");
            PreparedStatement huurprijsAanpassen = conn.prepareStatement("UPDATE Studio SET Huurprijs = ? WHERE StudioID = ?");
            
            
            GebouwIDaanpassen.setInt(1, gebouwID);
            GebouwIDaanpassen.setInt(2, studioID);
            GebouwIDaanpassen.executeUpdate();
            
            oppervlakteaanpassen.setString(1, oppervlakte);
            oppervlakteaanpassen.setInt(2, studioID);
            oppervlakteaanpassen.executeUpdate();
            
            inrichtingaanpassen.setString(1, inrichting);
            inrichtingaanpassen.setInt(2, studioID);
            inrichtingaanpassen.executeUpdate();
            
            huurprijsAanpassen.setDouble(1, huurprijs);
            huurprijsAanpassen.setInt(2, studioID);
            huurprijsAanpassen.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void studionieuwopslaan(Studio studio)
    {
        int studioID;
        int gebouwID;
        String oppervlakte;
        String inrichting;
        double huurprijs;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            studioID = studio.getstudioid();
            gebouwID = studio.getgebouwid();
            oppervlakte = studio.getoppervlakte();
            inrichting = studio.getinrichting();
            huurprijs = studio.gethuurprijs();

            
            PreparedStatement nieuwStudio = conn.prepareStatement("INSERT INTO Studio VALUES(?,?,?,?,?)");
            nieuwStudio.setInt(1, studioID);
            nieuwStudio.setInt(2, gebouwID);
            nieuwStudio.setString(3, oppervlakte);
            nieuwStudio.setString(4, inrichting);
            nieuwStudio.setDouble(5, huurprijs);
            
            nieuwStudio.executeUpdate();
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        } 
           
    }
    
    
    public ArrayList<Studio> Vulstudio()
    {
        ArrayList<Studio> studlist = new ArrayList<Studio>();
        int studioID;
        int gebouwID;
        String oppervlakte;
        String inrichting;
        double huurprijs;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            

            // Vervolgens voeren we een SELECT query uit om de tabel PRODUCT uit te lezen.
            // SELECT queries voer je uit met de methode executeQuery().
            // De returnwaarde is een ResultSet object dat het antwoord op de query (in tabelvorm) voorstelt.
            ResultSet rs = stat.executeQuery("SELECT * FROM Studio");

            // De ResultSet overlopen doe je met onderstaande lus.
            // De methode next() verplaatst de cursor van de ResultSet naar de volgende lijn en geeft terug of er nog een lijn was.
            // De cursor begint vÃ³Ã³r de eerste lijn, we moeten next() dus altijd gebruiken, ook als er maar 1 lijn is.
            while (rs.next()) {

                // Om de waarden op de huidige rij uit te lezen, gebruik je de methoden getXxx().
                // De Xxx vervang je door het gepaste datatype.
                // Als argument kan je zowel de kolomnaam als het kolomnummer (vanaf 1) meegeven.
                studioID = rs.getInt("StudioID");
                gebouwID = rs.getInt("GebouwID");
                oppervlakte = rs.getString("Oppervlakte");
                inrichting = rs.getString("Inrichting");
                huurprijs = rs.getDouble("Huurprijs");
                
               
               Studio studio = new Studio();
               studio.setstudioid(studioID);
               studio.setgebouwid(gebouwID);
               studio.sethuurprijs(huurprijs);
               studio.setoppervlakte(oppervlakte);
               studio.setinrichting(inrichting);
               
               studlist.add(studio);
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
        return studlist;   
    }
    
    
}
