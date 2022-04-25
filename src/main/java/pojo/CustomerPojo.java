package pojo;

public class CustomerPojo {
	
	private int userID;
	private int userPin;
	private int accNumber;
	private String accName;	//customer name
	private double accBalance; //account balance
	private int customerContact;
	private String customerAddress;
	
	public CustomerPojo() {
		super();
	}

	public CustomerPojo(int userPin, String accName, double accBalance, int customerContact, String customerAddress) {
		super();
		this.userPin = userPin;
		this.accName = accName;
		this.accBalance = accBalance;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}
	
	public CustomerPojo(int userID, int accNumber, String accName, double accBalance, int customerContact,
			String customerAddress) {
		super();
		this.userID = userID;
		this.accNumber = accNumber;
		this.accName = accName;
		this.accBalance = accBalance;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}

	public CustomerPojo(int userID, int userPin, int accNumber, String accName, double accBalance,
			int customerContact, String customerAddress) {
		super();
		this.userID = userID;
		this.userPin = userPin;
		this.accNumber = accNumber;
		this.accName = accName;
		this.accBalance = accBalance;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getUserPin() {
		return userPin;
	}

	public void setUserPin(int userPin) {
		this.userPin = userPin;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public int getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(int customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "BankCustomerPojo [userID=" + userID + ", accNumber=" + accNumber + ", accName=" + accName
				+ ", accBalance=" + accBalance + ", customerContact=" + customerContact + ", customerAddress="
				+ customerAddress + "]";
	}
}
