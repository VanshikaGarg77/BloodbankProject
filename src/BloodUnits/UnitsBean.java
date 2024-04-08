package BloodUnits;

public class UnitsBean
{
	String Ap;
	String Bp;
	String ABp;
	String Op;
	String An;
	String Bn;
	String ABn;
	String Onn;
	public String getAp() {
		return Ap;
	}
	public void setAp(String ap) {
		Ap = ap;
	}
	public String getBp() {
		return Bp;
	}
	public UnitsBean()
	{
		
	}
	public UnitsBean(String ap, String bp, String aBp, String op, String an, String bn, String aBn, String onn) {
		super();
		Ap = ap;
		Bp = bp;
		ABp = aBp;
		Op = op;
		An = an;
		Bn = bn;
		ABn = aBn;
		Onn = onn;
	}
	public void setBp(String bp) {
		Bp = bp;
	}
	public String getABp() {
		return ABp;
	}
	public void setABp(String aBp) {
		ABp = aBp;
	}
	public String getOp() {
		return Op;
	}
	public void setOp(String op) {
		Op = op;
	}
	public String getAn() {
		return An;
	}
	public void setAn(String an) {
		An = an;
	}
	public String getBn() {
		return Bn;
	}
	public void setBn(String bn) {
		Bn = bn;
	}
	public String getABn() {
		return ABn;
	}
	public void setABn(String aBn) {
		ABn = aBn;
	}
	public String getOnn() {
		return Onn;
	}
	public void setOnn(String onn) {
		Onn = onn;
	}
}