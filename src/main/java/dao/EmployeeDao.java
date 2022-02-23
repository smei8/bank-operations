package dao;

import java.util.List;

import exception.SystemException;
import pojo.CustomerPojo;
import pojo.EmployeePojo;

public interface EmployeeDao {
	
	List<CustomerPojo> fetchAllAccounts() throws SystemException;
	
	boolean epLogin(int epID, int epPassword) throws SystemException;
	
	CustomerPojo registerCustomer(CustomerPojo customerPojo) throws SystemException;
	
	CustomerPojo fetchaAccount(int userID) throws SystemException;

	EmployeePojo fetchAEPAcc(int epID) throws SystemException;
	
	default void exitApplication() throws SystemException {
		DBUtil.closeConnection();
	}
	
}
