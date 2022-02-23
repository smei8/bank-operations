package service;

import java.util.List;

import dao.EmpJdbcDaoImpl;
import dao.EmployeeDao;
import exception.SystemException;
import pojo.CustomerPojo;
import pojo.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new EmpJdbcDaoImpl();
	}
	@Override
	public List<CustomerPojo> fetchAllAccounts() throws SystemException {
		return employeeDao.fetchAllAccounts();
	}

	@Override
	public boolean epLogin(int epID, int epPassword) throws SystemException {
		return employeeDao.epLogin(epID, epPassword);
	}

	@Override
	public CustomerPojo registerCustomer(CustomerPojo customerPojo) throws SystemException {
		return employeeDao.registerCustomer(customerPojo);
		
	}

	@Override
	public CustomerPojo fetchaAccount(int userID) throws SystemException {
		return employeeDao.fetchaAccount(userID);
	}

	@Override
	public void epLogout() {
		// TODO Auto-generated method stub

	}
	@Override
	public void exitApplication() throws SystemException {
		employeeDao.exitApplication();
	}

}
