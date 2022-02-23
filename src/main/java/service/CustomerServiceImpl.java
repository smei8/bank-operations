package service;

import java.util.List;

import dao.CustomerDao;
import dao.CustomerJdbcDaoImpl;
import exception.LoginException;
import exception.SystemException;
import pojo.CustomerPojo;
import pojo.TransactionPojo;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;
	
	public CustomerServiceImpl() {
		customerDao = new CustomerJdbcDaoImpl();
	}
	@Override
	public boolean customerLogin(int userID, int userPin) throws SystemException{
		return customerDao.customerLogin(userID, userPin);
	}

//	@Override
//	public CustomerPojo viewAccount(int userID, int userPin) throws SystemException {
//		return customerDao.viewAccount(userID, userPin);
//	}

	@Override
	public TransactionPojo moneyTransfer(int fromAccNum, int toAccNum, int balance) throws SystemException {
		// TODO Auto-generated method stub
		return customerDao.moneyTransfer(fromAccNum, toAccNum, balance);
	}

	@Override
	public List<TransactionPojo> viewTransactionHist(int accNumber) throws SystemException {
		// TODO Auto-generated method stub
		return customerDao.viewTransactionHist(accNumber);

	}
	@Override
	public void exitApplication() throws SystemException {
		customerDao.exitApplication();
		
	}
	@Override
	public CustomerPojo fetchAAccount(int userID) throws SystemException {
		return customerDao.fetchAAccount(userID);
	}
}
	
