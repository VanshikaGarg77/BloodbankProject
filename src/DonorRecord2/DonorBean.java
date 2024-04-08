package DonorRecord2;

public class DonorBean
{
	String mobile;
	String dod;
	String bgroup;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDod() {
		return dod;
	}
	public void setDod(String dod) {
		this.dod = dod;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public DonorBean()
	{
		
	}
	public DonorBean(String mobile, String dod, String bgroup) {
		super();
		this.mobile = mobile;
		this.dod = dod;
		this.bgroup = bgroup;
	}
	
}