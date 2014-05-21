
package connectie;

import java.sql.*;
import java.util.ArrayList;
import programma.Gebouw;

public class ConnGebouw 
{
     public ArrayList<Gebouw> Vulgebouw()
    {
        ArrayList<Gebouw> gebouwlist = new ArrayList<Gebouw>();
        int GebouwID;
        String straat;
        int nr;
        String postcode;
        String gemeente;
        String comment;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            

            // Vervolgens voeren we een SELECT query uit om de tabel PRODUCT uit te lezen.
            // SELECT queries voer je uit met de methode executeQuery().
            // De returnwaarde is een ResultSet object dat het antwoord op de query (in tabelvorm) voorstelt.
            ResultSet rs = stat.executeQuery("SELECT * FROM Gebouwen");

            // De ResultSet overlopen doe je met onderstaande lus.
            // De methode next() verplaatst de cursor van de ResultSet naar de volgende lijn en geeft terug of er nog een lijn was.
            // De cursor begint vÃ³Ã³r de eerste lijn, we moeten next() dus altijd gebruiken, ook als er maar 1 lijn is.
            while (rs.next()) {

                // Om de waarden op de huidige rij uit te lezen, gebruik je de methoden getXxx().
                // De Xxx vervang je door het gepaste datatype.
                // Als argument kan je zowel de kolomnaam als het kolomnummer (vanaf 1) meegeven.
                GebouwID = rs.getInt("GebouwID");
                straat = rs.getString("Straat");
                nr = rs.getInt("Nr");
                postcode = rs.getString("Postcode");
                gemeente = rs.getString("Gemeente");
                comment = rs.getString("Comment");

               Gebouw gebouw = new Gebouw(GebouwID, gemeente, postcode, straat, nr, comment);
               gebouwlist.add(gebouw);
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
        return gebouwlist;   
    }

    public void Gebouwnieuwopslaan(Gebouw gebouw)
    {
        int GebouwID;
        int nr;
        String gemeente;
        String straat;
        String postcode;
        String comment;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            GebouwID = gebouw.getGebouwID();
            nr = gebouw.getNr();
            gemeente = gebouw.getGemeente();
            straat = gebouw.getStraat();
            postcode = gebouw.getPostcode();
            comment = gebouw.getComment();

            
            PreparedStatement nieuwGebouw = conn.prepareStatement("INSERT INTO Gebouwen VALUES(?,?,?,?,?,?)");
            nieuwGebouw.setInt(1, GebouwID);
            nieuwGebouw.setString(2, straat);
            nieuwGebouw.setInt(3, nr);
            nieuwGebouw.setString(4, postcode);
            nieuwGebouw.setString(5, gemeente);
            nieuwGebouw.setString(6, comment);
            
            nieuwGebouw.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Gebouwaanpassen(Gebouw gebouw)
    {
        int GebouwID;
        int nr;
        String gemeente;
        String straat;
        String postcode;
        String comment;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            GebouwID = gebouw.getGebouwID();
            nr = gebouw.getNr();
            gemeente = gebouw.getGemeente();
            straat = gebouw.getStraat();
            postcode = gebouw.getPostcode();
            comment = gebouw.getComment();


            PreparedStatement Nraanpassen = conn.prepareStatement("UPDATE Gebouwen SET Nr = ? WHERE GebouwID = ?");
            PreparedStatement Gemeenteaanpassen = conn.prepareStatement("UPDATE Gebouwen SET Gemeente = ? WHERE GebouwID = ?");
            PreparedStatement straataanpassen = conn.prepareStatement("UPDATE Gebouwen SET Straat = ? WHERE GebouwID = ?");
            PreparedStatement postcodeAanpassen = conn.prepareStatement("UPDATE Gebouwen SET Postcode = ? WHERE GebouwID = ?");
            PreparedStatement commentAanpassen = conn.prepareStatement("UPDATE Gebouwen SET Comment = ? WHERE GebouwID = ?");
            
            Nraanpassen.setInt(1, nr);
            Nraanpassen.setInt(2, GebouwID);
            Nraanpassen.executeUpdate();
            
            Gemeenteaanpassen.setString(1, gemeente);
            Gemeenteaanpassen.setInt(2, GebouwID);
            Gemeenteaanpassen.executeUpdate();
            
            straataanpassen.setString(1, straat);
            straataanpassen.setInt(2, GebouwID);
            straataanpassen.executeUpdate();
            
            postcodeAanpassen.setString(1, postcode);
            postcodeAanpassen.setInt(2, GebouwID);
            postcodeAanpassen.executeUpdate();
            
            commentAanpassen.setString(1, comment);
            commentAanpassen.setInt(2, GebouwID);
            commentAanpassen.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Gebouwdelete(Gebouw gebouw)
    {
        int GebouwID;
     
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            GebouwID = gebouw.getGebouwID();
            
            
            PreparedStatement GebouwDelete = conn.prepareStatement("DELETE FROM Gebouwen WHERE GebouwID = ?");
            
            GebouwDelete.setInt(1, GebouwID);
            GebouwDelete.executeUpdate();
            
            
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }    
    }
      public ArrayList<Gebouw> ZoekGemeente(String zoekenop, String zoekennaar)
    {
        ArrayList<Gebouw> gebouwlist = new ArrayList<Gebouw>();
        int GebouwID;
        String straat;
        int nr;
        String postcode;
        String gemeente;
        String comment;
        String op = zoekenop;
        String naar = zoekennaar;
       
            try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {
                Statement stat = conn.createStatement();
                PreparedStatement Select = conn.prepareStatement("SELECT * FROM Gebouwen WHERE Gemeente = ?");
                Select.setString(1, naar);
                ResultSet rs = Select.executeQuery();
                while (rs.next()) {
                    GebouwID = rs.getInt("GebouwID");
                    straat = rs.getString("Straat");
                    nr = rs.getInt("Nr");
                    postcode = rs.getString("Postcode");
                    gemeente = rs.getString("Gemeente");
                    comment = rs.getString("Comment");
                Gebouw gebouw = new Gebouw(GebouwID, gemeente, postcode, straat, nr, comment);
                gebouwlist.add(gebouw);
                }
                rs.close();
            } catch (SQLException ex) {
                for (Throwable t : ex) {
                    t.printStackTrace();
                }
            } 
            return gebouwlist; 
        
        
        
    }
        public ArrayList<Gebouw> Zoekgebouwid(String zoekenop, String zoekennaar)
    {
        ArrayList<Gebouw> gebouwlist = new ArrayList<Gebouw>();
        int GebouwID;
        String straat;
        int nr;
        String postcode;
        String gemeente;
        String comment;
        String op = zoekenop;
        String naar = zoekennaar;
       
            try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {
                Statement stat = conn.createStatement();
                PreparedStatement Select = conn.prepareStatement("SELECT * FROM Gebouwen WHERE GebouwID = ?");
                Select.setString(1, naar);
                ResultSet rs = Select.executeQuery();
                while (rs.next()) {
                    GebouwID = rs.getInt("GebouwID");
                    straat = rs.getString("Straat");
                    nr = rs.getInt("Nr");
                    postcode = rs.getString("Postcode");
                    gemeente = rs.getString("Gemeente");
                    comment = rs.getString("Comment");
                Gebouw gebouw = new Gebouw(GebouwID, gemeente, postcode, straat, nr, comment);
                gebouwlist.add(gebouw);
                }
                rs.close();
            } catch (SQLException ex) {
                for (Throwable t : ex) {
                    t.printStackTrace();
                }
            } 
            return gebouwlist; 
        
        
        
    }
          public ArrayList<Gebouw> ZoekStraat(String zoekenop, String zoekennaar)
    {
        ArrayList<Gebouw> gebouwlist = new ArrayList<Gebouw>();
        int GebouwID;
        String straat;
        int nr;
        String postcode;
        String gemeente;
        String comment;
        String op = zoekenop;
        String naar = zoekennaar;
       
            try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {
                Statement stat = conn.createStatement();
                PreparedStatement Select = conn.prepareStatement("SELECT * FROM Gebouwen WHERE Straat = ?");
                Select.setString(1, naar);
                ResultSet rs = Select.executeQuery();
                while (rs.next()) {
                    GebouwID = rs.getInt("GebouwID");
                    straat = rs.getString("Straat");
                    nr = rs.getInt("Nr");
                    postcode = rs.getString("Postcode");
                    gemeente = rs.getString("Gemeente");
                    comment = rs.getString("Comment");
                Gebouw gebouw = new Gebouw(GebouwID, gemeente, postcode, straat, nr, comment);
                gebouwlist.add(gebouw);
                }
                rs.close();
            } catch (SQLException ex) {
                for (Throwable t : ex) {
                    t.printStackTrace();
                }
            } 
            return gebouwlist; 
        
        
        
    }
    public ArrayList<Gebouw> ZoekNr(String zoekenop, String zoekennaar)
    {
        ArrayList<Gebouw> gebouwlist = new ArrayList<Gebouw>();
        int GebouwID;
        String straat;
        int nr;
        String postcode;
        String gemeente;
        String comment;
        String op = zoekenop;
        String naar = zoekennaar;
       
            try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {
                Statement stat = conn.createStatement();
                PreparedStatement Select = conn.prepareStatement("SELECT * FROM Gebouwen WHERE Nr = ?");
                Select.setString(1, naar);
                ResultSet rs = Select.executeQuery();
                while (rs.next()) {
                    GebouwID = rs.getInt("GebouwID");
                    straat = rs.getString("Straat");
                    nr = rs.getInt("Nr");
                    postcode = rs.getString("Postcode");
                    gemeente = rs.getString("Gemeente");
                    comment = rs.getString("Comment");
                Gebouw gebouw = new Gebouw(GebouwID, gemeente, postcode, straat, nr, comment);
                gebouwlist.add(gebouw);
                }
                rs.close();
            } catch (SQLException ex) {
                for (Throwable t : ex) {
                    t.printStackTrace();
                }
            } 
            return gebouwlist; 
        
        
        
    }
      public ArrayList<Gebouw> ZoekPostcode(String zoekenop, String zoekennaar)
    {
        ArrayList<Gebouw> gebouwlist = new ArrayList<Gebouw>();
        int GebouwID;
        String straat;
        int nr;
        String postcode;
        String gemeente;
        String comment;
        String op = zoekenop;
        String naar = zoekennaar;
       
            try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {
                Statement stat = conn.createStatement();
                PreparedStatement Select = conn.prepareStatement("SELECT * FROM Gebouwen WHERE Postcode = ?");
                Select.setString(1, naar);
                ResultSet rs = Select.executeQuery();
                while (rs.next()) {
                    GebouwID = rs.getInt("GebouwID");
                    straat = rs.getString("Straat");
                    nr = rs.getInt("Nr");
                    postcode = rs.getString("Postcode");
                    gemeente = rs.getString("Gemeente");
                    comment = rs.getString("Comment");
                Gebouw gebouw = new Gebouw(GebouwID, gemeente, postcode, straat, nr, comment);
                gebouwlist.add(gebouw);
                }
                rs.close();
            } catch (SQLException ex) {
                for (Throwable t : ex) {
                    t.printStackTrace();
                }
            } 
            return gebouwlist; 
        
        
        
    }
        public ArrayList<Gebouw> ZoekComment(String zoekenop, String zoekennaar)
    {
        ArrayList<Gebouw> gebouwlist = new ArrayList<Gebouw>();
        int GebouwID;
        String straat;
        int nr;
        String postcode;
        String gemeente;
        String comment;
        String op = zoekenop;
        String naar = zoekennaar;
       
            try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {
                Statement stat = conn.createStatement();
                PreparedStatement Select = conn.prepareStatement("SELECT * FROM Gebouwen WHERE Comment = ?");
                Select.setString(1, naar);
                ResultSet rs = Select.executeQuery();
                while (rs.next()) {
                    GebouwID = rs.getInt("GebouwID");
                    straat = rs.getString("Straat");
                    nr = rs.getInt("Nr");
                    postcode = rs.getString("Postcode");
                    gemeente = rs.getString("Gemeente");
                    comment = rs.getString("Comment");
                Gebouw gebouw = new Gebouw(GebouwID, gemeente, postcode, straat, nr, comment);
                gebouwlist.add(gebouw);
                }
                rs.close();
            } catch (SQLException ex) {
                for (Throwable t : ex) {
                    t.printStackTrace();
                }
            } 
            return gebouwlist; 
        
        
        
    }
    
}
