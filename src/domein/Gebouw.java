package programma;

public class Gebouw 
{
	private int gebouwID;
	private String gemeente;
	private String postcode;
	private String straat;
	private int nr;
	private String comment;
	
	public Gebouw(int gebouwID, String gemeente, String postcode, String straat, int nr, String comment)
	{
		setGebouwID(gebouwID);
		setGemeente(gemeente);
		setPostcode(postcode);
		setStraat(straat);
		setNr(nr);
                setComment(comment);
	}
	
	public Gebouw()
	{
		this(0,"gemeente","0000","straat",0,"comment");
	}

	public int getGebouwID() {
		return gebouwID;
	}

	public void setGebouwID(int gebouwID) {
		this.gebouwID = gebouwID;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
        public String toString()
	{
		return getGebouwID()+ " | " +getStraat()+ " | " +getNr()+ " | " +getPostcode()+ " | " +getGemeente();
	}
}
