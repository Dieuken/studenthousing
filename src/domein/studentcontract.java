package programma;


public class studentcontract 
{
    int studentid;
    int contractid;
    
    public studentcontract(int studentid, int contractid)
    {
        setstudentid(studentid);
        setcontractid(contractid);
    }
    
    public studentcontract()
    {
        
    }
    
    public int getstudentid()
    {
        return studentid;
    }
    
    public int getcontractid()
    {
        return contractid;
    }
    
    public void setstudentid(int studentid)
    {
        this.studentid = studentid;
    }
    
    public void setcontractid(int contractid)
    {
        this.contractid = contractid;
    }
    public String toString()
    {
		return getcontractid()+ " | " +getstudentid();
    }
}
