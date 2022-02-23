package service;

import java.util.List;

import exception.SystemException;
import pojo.CustomerPojo;
import pojo.EmployeePojo;

public interface EmployeeService {
	List<CustomerPojo> fetchAllAccounts() throws SystemException;
	
	boolean epLogin(int epID, int epPassword) throws SystemException;
	
	CustomerPojo registerCustomer(CustomerPojo customerPojo) throws SystemException;
	
	CustomerPojo fetchaAccount(int userID) throws SystemException;
	
	void epLogout() throws SystemException;
	
	//exit system close connection
	void exitApplication() throws SystemException;
}
