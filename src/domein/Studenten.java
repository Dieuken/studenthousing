package programma;

/**
 *
 * @author Stef
 */
public class Studenten 
{
    private int studentid;
    private String voornaam;
    private String naam;
    private String geboortedatum;
    private String school;
    private String schooljaar;
    private String telefoon;
    private String email;
    private String telefoonouders;
    
    public Studenten(int studentid, String voornaam, String naam, String geboortedatum, String school, String schooljaar, String telefoon, String email, String telefoonouders)
    {
        setstudentid(studentid);
        setvoornaam(voornaam);
        setnaam(naam);
        setgeboortedatum(geboortedatum);
        setschool(school);
        setschooljaar(schooljaar);
        settelefoon(telefoon);
        setemail(email);
        settelefoonouders(telefoonouders);
    }
    
    public Studenten()
    {
        
    }
    
    public int getstudentid() {
		return studentid;
	}

	public void setstudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getvoornaam() {
		return voornaam;
	}

	public void setvoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getnaam() {
		return naam;
	}

	public void setnaam(String naam) {
		this.naam = naam;
	}

	public String getgeboortedatum() {
		return geboortedatum;
	}

	public void setgeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public String getschool() {
		return school;
	}

	public void setschool(String school) {
		this.school = school;
	}

	public String getschooljaar() {
		return schooljaar;
	}

	public void setschooljaar(String schooljaar) {
		this.schooljaar = schooljaar;
	}
        public String gettelefoon() {
		return telefoon;
	}

	public void settelefoon(String telefoon) {
		this.telefoon = telefoon;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String gettelefoonouders() {
		return telefoonouders;
	}

	public void settelefoonouders(String telefoonouders) {
		this.telefoonouders = telefoonouders;
	}
        
        public String toString()
	{
		return getstudentid()+ " | " +getvoornaam()+ " | " +getnaam();
	}
        
        public String testschool()
        {
            return getstudentid()+ " | " +getvoornaam()+ " | " +getnaam()+ " | " +getschool()+ " | " +getschooljaar()+ " | " +gettelefoon()+ " | " +getemail()+ " | " +gettelefoonouders();
        }

}
