package pojo;

public class TransactionPojo {

	private int transactionId;
	private String accName;
	private int fromAccNum;
	private int toAccNum;
	private int transferAmount;
	private int newBalance;
	private String transferDate;
	
	public TransactionPojo() {
		super();
	}

	public TransactionPojo(int transactionId, int fromAccNum, int toAccNum, int transferAmount, String transferDate) {
		super();
		this.transactionId = transactionId;
		this.fromAccNum = fromAccNum;
		this.toAccNum = toAccNum;
		this.transferAmount = transferAmount;
		this.transferDate = transferDate;
	}

	
	public TransactionPojo(int fromAccNum, int toAccNum, int transferAmount, String transferDate) {
		super();
		this.fromAccNum = fromAccNum;
		this.toAccNum = toAccNum;
		this.transferAmount = transferAmount;
		this.transferDate = transferDate;
	}


	public TransactionPojo(int transactionId, int fromAccNum, int toAccNum, int transferAmount, int newBalance,
			String accName, String transferDate) {
		super();
		this.transactionId = transactionId;
		this.fromAccNum = fromAccNum;
		this.toAccNum = toAccNum;
		this.transferAmount = transferAmount;
		this.newBalance = newBalance;
		this.accName = accName;
		this.transferDate = transferDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getFromAccNum() {
		return fromAccNum;
	}

	public void setFromAccNum(int fromAccNum) {
		this.fromAccNum = fromAccNum;
	}

	public int getToAccNum() {
		return toAccNum;
	}

	public void setToAccNum(int toAccNum) {
		this.toAccNum = toAccNum;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public int getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(int newBalance) {
		this.newBalance = newBalance;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	@Override
	public String toString() {
		return "TransactionPojo [transactionId=" + transactionId + ", fromAccNum=" + fromAccNum + ", toAccNum="
				+ toAccNum + ", transferAmount=" + transferAmount + ", newBalance=" + newBalance + ", accName="
				+ accName + ", transferDate=" + transferDate + "]";
	}
}
