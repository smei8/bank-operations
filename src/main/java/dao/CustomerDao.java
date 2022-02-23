package dao;

import java.util.List;

import exception.LoginException;
import exception.SystemException;
import pojo.CustomerPojo;
import pojo.TransactionPojo;

public interface CustomerDao {
	
	boolean customerLogin(int userID, int userPin) throws SystemException;
	
	CustomerPojo viewAccount(int userID, int userPin) throws SystemException;
	
	CustomerPojo fetchAAccount(int userID) throws SystemException;
	
	TransactionPojo moneyTransfer(int fromAccNum, int toAccNum, int balance) throws SystemException;
	
	List<TransactionPojo> viewTransactionHist(int accNumber) throws SystemException;
	
	default void exitApplication() throws SystemException {
		DBUtil.closeConnection();
	}
	
	//void customerLogout();
	
}
