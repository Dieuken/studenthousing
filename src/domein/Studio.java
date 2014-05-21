
package programma;
public class Studio 
{
    private int studioid;
    private int gebouwid;
    private String oppervlakte;
    private String inrichting;
    private double huurprijs;
    
    
    public Studio(int studioid, int gebouwid, String oppervlakte, String inrichting, double huurprijs)
    {
        
        setstudioid(studioid);
        setgebouwid(gebouwid);
        setoppervlakte(oppervlakte);
        setinrichting(inrichting);
        sethuurprijs(huurprijs);
    }
    public Studio()
    {
        this(0, 0, "oppervlakte", "inrichting", 0.00);
    }
    public int getstudioid() {
		return studioid;
	}

	public void setstudioid(int studioid) {
		this.studioid = studioid;
	}
        public int getgebouwid(){
            return gebouwid;
        }
        public void setgebouwid(int gebouwid) {
            this.gebouwid = gebouwid;
        }

	public String getoppervlakte() {
		return oppervlakte;
	}

	public void setoppervlakte(String oppervlakte) {
		this.oppervlakte = oppervlakte;
	}

	public String getinrichting() {
		return inrichting;
	}

	public void setinrichting(String inrichting) {
		this.inrichting = inrichting;
	}

	public double gethuurprijs() {
		return huurprijs;
	}

	public void sethuurprijs(double huurprijs) {
		this.huurprijs = huurprijs;
	}
         public String toString()
	{
		return getstudioid()+ " | " +getgebouwid()+ " | " +getoppervlakte()+ " | " +getinrichting()+ " | " +gethuurprijs();
	}
}

