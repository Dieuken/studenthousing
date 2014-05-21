package connectie;

import java.sql.*;
import java.util.ArrayList;
import programma.Gebruiker;

public class ConnGebruiker 
{
    public ArrayList<Gebruiker> Vulgebruiker()
    {
        ArrayList<Gebruiker> Gebruikerlist = new ArrayList<Gebruiker>();
        String gebruikersnaam;
        String wachtwoord;
        String accounttype;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            

            // Vervolgens voeren we een SELECT query uit om de tabel PRODUCT uit te lezen.
            // SELECT queries voer je uit met de methode executeQuery().
            // De returnwaarde is een ResultSet object dat het antwoord op de query (in tabelvorm) voorstelt.
            ResultSet rs = stat.executeQuery("SELECT * FROM Gebruiker");

            // De ResultSet overlopen doe je met onderstaande lus.
            // De methode next() verplaatst de cursor van de ResultSet naar de volgende lijn en geeft terug of er nog een lijn was.
            // De cursor begint vÃƒÂ³ÃƒÂ³r de eerste lijn, we moeten next() dus altijd gebruiken, ook als er maar 1 lijn is.
            while (rs.next()) {

                // Om de waarden op de huidige rij uit te lezen, gebruik je de methoden getXxx().
                // De Xxx vervang je door het gepaste datatype.
                // Als argument kan je zowel de kolomnaam als het kolomnummer (vanaf 1) meegeven.
                gebruikersnaam = rs.getString("Gebruiker");
                wachtwoord = rs.getString("Wachtwoord");
                accounttype = rs.getString("Accounttype");

               Gebruiker gebruiker = new Gebruiker(gebruikersnaam, wachtwoord, accounttype);
               
               Gebruikerlist.add(gebruiker);
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
        return Gebruikerlist;   
    }

    public void Gebruikernieuwopslaan(Gebruiker gebruiker)
    {
        String gebruikersnaam;
        String wachtwoord;
        String accounttype;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            gebruikersnaam = gebruiker.getGebruikersnaam();
            wachtwoord = gebruiker.getWachtwoord();
            accounttype = gebruiker.getAccounttype();

            
            PreparedStatement nieuwHuurcontract = conn.prepareStatement("INSERT INTO Gebruiker VALUES(?,?,?)");
            nieuwHuurcontract.setString(1, gebruikersnaam);
            nieuwHuurcontract.setString(2, wachtwoord);
            nieuwHuurcontract.setString(3, accounttype);
            
            nieuwHuurcontract.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Gebruikeraanpassen(Gebruiker gebruiker)
    {
        String gebruikersnaam;
        String accounttype;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            gebruikersnaam = gebruiker.getGebruikersnaam();
            accounttype = gebruiker.getAccounttype();
            
            PreparedStatement accounttypeAanpassen = conn.prepareStatement("UPDATE Gebruiker SET Accounttype = ? WHERE Gebruiker = ?");
            
            accounttypeAanpassen.setString(1, accounttype);
            accounttypeAanpassen.setString(2, gebruikersnaam);
            accounttypeAanpassen.executeUpdate();
         
            
           
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Wachtwoordaanpassen(Gebruiker gebruiker)
    {
        String gebruikersnaam;
        String wachtwoord;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            gebruikersnaam = gebruiker.getGebruikersnaam();
            wachtwoord = gebruiker.getWachtwoord();
            
            PreparedStatement WachtwoordAanpassen = conn.prepareStatement("UPDATE Gebruiker SET Wachtwoord = ? WHERE Gebruiker = ?");
            
            WachtwoordAanpassen.setString(1, wachtwoord);
            WachtwoordAanpassen.setString(2, gebruikersnaam);
            WachtwoordAanpassen.executeUpdate();
         
            
           
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void GebruikerDelete(Gebruiker gebruiker)
    {
        String gebruikersnaam;
     
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            gebruikersnaam = gebruiker.getGebruikersnaam();
            
            
            PreparedStatement GebruikerDelete = conn.prepareStatement("DELETE FROM Gebruiker WHERE Gebruiker = ?");
            
            GebruikerDelete.setString(1, gebruikersnaam);
            GebruikerDelete.executeUpdate();
            
            
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }    
    }
}
