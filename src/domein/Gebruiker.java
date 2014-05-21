package programma;

public class Gebruiker 
{
    private String gebruikersnaam;
    private String wachtwoord;
    private String accounttype;
    
    public Gebruiker(String gebruikersnaam, String wachtwoord, String accounttype)
	{
		setGebruikersnaam(gebruikersnaam);
		setWachtwoord(wachtwoord);
		setAccounttype(accounttype);
	}
    public Gebruiker()
    {
        this("gebruiker", "passwoord", "accounttype");
    }

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

        public String toString()
	{
		return getGebruikersnaam()+ " | " + getWachtwoord()+ " | " + getAccounttype();

	}
}
