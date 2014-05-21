package connectie;

import java.sql.*;
import java.util.ArrayList;
import programma.Huurcontract;

public class ConnContract 
{
    public ArrayList<Huurcontract> VulContract()
    {
        ArrayList<Huurcontract> Huurcontractlist = new ArrayList<Huurcontract>();
        int HuurcontractID;
        Date begindatum;
        double waarborg;
        Date einddatum;
        double huurprijs;
        int studioid;
        
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            

            // Vervolgens voeren we een SELECT query uit om de tabel PRODUCT uit te lezen.
            // SELECT queries voer je uit met de methode executeQuery().
            // De returnwaarde is een ResultSet object dat het antwoord op de query (in tabelvorm) voorstelt.
            ResultSet rs = stat.executeQuery("SELECT * FROM Huurcontract");

            // De ResultSet overlopen doe je met onderstaande lus.
            // De methode next() verplaatst de cursor van de ResultSet naar de volgende lijn en geeft terug of er nog een lijn was.
            // De cursor begint vÃ³Ã³r de eerste lijn, we moeten next() dus altijd gebruiken, ook als er maar 1 lijn is.
            while (rs.next()) {

                // Om de waarden op de huidige rij uit te lezen, gebruik je de methoden getXxx().
                // De Xxx vervang je door het gepaste datatype.
                // Als argument kan je zowel de kolomnaam als het kolomnummer (vanaf 1) meegeven.
                HuurcontractID = rs.getInt("ContractID");
                begindatum = rs.getDate("begindatum");
                waarborg = rs.getDouble("waarborg");
                einddatum = rs.getDate("einddatum");
                huurprijs = rs.getDouble("huurprijs");
                studioid = rs.getInt("StudioID");
                
                
               Huurcontract contract = new Huurcontract(HuurcontractID, huurprijs, waarborg, studioid);
               contract.setbegindatum(begindatum);
               contract.seteinddatum(einddatum);
               Huurcontractlist.add(contract);
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
        return Huurcontractlist;   
    }

    public void Huurcontractnieuwopslaan(Huurcontract huurcontract)
    {
        int contractID;
        double waarborg;
        double huurprijs;
        Date begindatum;
        Date einddatum;
        int studioid;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            contractID = huurcontract.getcontractID();
            waarborg = huurcontract.getwaarborg();
            huurprijs = huurcontract.gethuurprijs();
            begindatum =huurcontract.getbegindatum();
            einddatum = huurcontract.geteinddatum();
            studioid = huurcontract.getstudioid();
            
            PreparedStatement nieuwHuurcontract = conn.prepareStatement("INSERT INTO Huurcontract VALUES(?,?,?,?,?,?)");
            nieuwHuurcontract.setInt(1, contractID);
            nieuwHuurcontract.setDate(2, begindatum);
            nieuwHuurcontract.setDate(3, einddatum);
            nieuwHuurcontract.setDouble(4, huurprijs);
            nieuwHuurcontract.setDouble(5, waarborg);
            nieuwHuurcontract.setInt(6, studioid);
            
            nieuwHuurcontract.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Huurcontractaanpassen(Huurcontract huurcontract)
    {
        int contractID;
        double waarborg;
        double huurprijs;
        Date begindatum;
        Date einddatum;
        int studioid;
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            contractID = huurcontract.getcontractID();
            waarborg = huurcontract.getwaarborg();
            huurprijs = huurcontract.gethuurprijs();
            begindatum = huurcontract.getbegindatum();
            einddatum = huurcontract.geteinddatum();
            studioid = huurcontract.getstudioid();

            PreparedStatement waarborgaanpassen = conn.prepareStatement("UPDATE Huurcontract SET Waarborg = ? WHERE ContractID = ?");
            PreparedStatement huurprijsaanpassen = conn.prepareStatement("UPDATE Huurcontract SET Huurprijs = ? WHERE ContractID = ?");
            PreparedStatement begindatumaanpassen = conn.prepareStatement("UPDATE Huurcontract SET Begindatum = ? WHERE ContractID = ?");
            PreparedStatement einddatumAanpassen = conn.prepareStatement("UPDATE Huurcontract SET Einddatum = ? WHERE ContractID = ?");
            PreparedStatement studioaanpassen = conn.prepareStatement("UPDATE Huurcontract SET StudioID = ? WHERE ContractID = ?");
            
            waarborgaanpassen.setDouble(1, waarborg);
            waarborgaanpassen.setInt(2, contractID);
            waarborgaanpassen.executeUpdate();
            
            huurprijsaanpassen.setDouble(1, huurprijs);
            huurprijsaanpassen.setInt(2, contractID);
            huurprijsaanpassen.executeUpdate();
            
            begindatumaanpassen.setDate(1, begindatum);
            begindatumaanpassen.setInt(2, contractID);
            begindatumaanpassen.executeUpdate();
            
            einddatumAanpassen.setDate(1, einddatum);
            einddatumAanpassen.setInt(2, contractID);
            einddatumAanpassen.executeUpdate();
            
            studioaanpassen.setInt(1, studioid);
            studioaanpassen.setInt(2, contractID);
            studioaanpassen.executeQuery();
            
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }   
    }
    public void Huurcontractdelete(Huurcontract huurcontract)
    {
        int contractID;
     
        
        try (Connection conn = DriverManager.getConnection("jdbc:odbc:DBC")) {

            // Om SQL queries te kunnen uitvoeren, vragen we een Statement object aan de Connection.
            // Dit Statement kan allerlei queries uitvoeren en is bovendien herbruikbaar.
            Statement stat = conn.createStatement();

            contractID = huurcontract.getcontractID();
            
            
            PreparedStatement HuurcontractDelete = conn.prepareStatement("DELETE FROM Huurcontract WHERE ContractID = ?");
            
            HuurcontractDelete.setInt(1, contractID);
            HuurcontractDelete.executeUpdate();
            
            
            
            
            
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }    
    }
}
