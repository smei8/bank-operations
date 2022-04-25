package pojo;

public class EmployeePojo {
	
	private int epID;
	private int epPassword;
	private String epName; 
	private int epContact;
	private String epAddess;
	
	public EmployeePojo() {
		super();
	}

	public EmployeePojo(int epID, String epName, int epContact, String epAddess) {
		super();
		this.epID = epID;
		this.epName = epName;
		this.epContact = epContact;
		this.epAddess = epAddess;
	}

	public EmployeePojo(int epID, int epPassword, String epName, int epContact, String epAddess) {
		super();
		this.epID = epID;
		this.epName = epName;
		this.epPassword = epPassword;
		this.epContact = epContact;
		this.epAddess = epAddess;
	}

	public int getEpID() {
		return epID;
	}
	public void setEpID(int epID) {
		this.epID = epID;
	}
	public String getEpName() {
		return epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}
	public int getEpPassword() {
		return epPassword;
	}

	public void setEpPassword(int epPassword) {
		this.epPassword = epPassword;
	}

	public int getEpContact() {
		return epContact;
	}

	public void setEpContact(int epContact) {
		this.epContact = epContact;
	}

	public String getEpAddess() {
		return epAddess;
	}

	public void setEpAddess(String epAddess) {
		this.epAddess = epAddess;
	}

	@Override
	public String toString() {
		return "EmployeePojo [epID=" + epID + ", epName=" + epName + ", epContact="
				+ epContact + ", epAddess=" + epAddess + "]";
	}
}
