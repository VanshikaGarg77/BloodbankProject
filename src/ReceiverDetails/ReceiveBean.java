package ReceiverDetails;

public class ReceiveBean
{
	String rname;
	String doi;
	String bgroup;
	String units;
	String hospital;
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public ReceiveBean()
	{
		
	}
	
	public ReceiveBean(String rname, String doi, String bgroup, String units, String hospital) {
		super();
		this.rname = rname;
		this.doi = doi;
		this.bgroup = bgroup;
		this.units = units;
		this.hospital = hospital;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
}