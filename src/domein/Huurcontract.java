package programma;

import java.sql.Date;

public class Huurcontract 
{
    private int contractid;
    private int studioid;
    private Date begindatum;
    private Date einddatum;
    private double huurprijs;
    private double waarborg;
    
    public Huurcontract(int contractid, double huurprijs, double waarborg, int studioid)
	{
		setcontractID(contractid);
		setbegindatum(begindatum);
		seteinddatum(einddatum);
		sethuurprijs(huurprijs);
		setwaarborg(waarborg);
                setstudioid(studioid);
	}
	
	public Huurcontract()
	{
		this(0, 0.00, 0.00, 0);
	}

	public int getcontractID() {
		return contractid;
	}

	public void setcontractID(int contractID) {
		this.contractid = contractID;
	}

	public Date getbegindatum() {
		return begindatum;
	}

	public void setbegindatum(Date begindatum) {
		this.begindatum = begindatum;
	}

	public Date geteinddatum() {
		return einddatum;
	}

	public void seteinddatum(Date einddatum) {
		this.einddatum = einddatum;
	}

	public Double gethuurprijs() {
		return huurprijs;
	}

	public void sethuurprijs(double huurprijs) {
		this.huurprijs = huurprijs;
	}

	public Double getwaarborg() {
		return waarborg;
	}

	public void setwaarborg(double waarborg) {
		this.waarborg = waarborg;
	}
        public int getstudioid(){
            return studioid;
        }
        
        public void setstudioid(int studioid){
            this.studioid = studioid;
        }

        public String toString()
	{
		return getcontractID()+ " | " +gethuurprijs()+ " | " +getwaarborg()+ " | " +geteinddatum()+ " | " +getbegindatum();
	}
}
