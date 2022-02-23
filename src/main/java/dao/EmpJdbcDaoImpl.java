package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.SystemException;
import pojo.CustomerPojo;
import pojo.EmployeePojo;

public class EmpJdbcDaoImpl implements EmployeeDao {
	
	public static final Logger LOG = LogManager.getLogger(EmpJdbcDaoImpl.class);

	@Override
	public List<CustomerPojo> fetchAllAccounts() throws SystemException {
		LOG.info("Entered fetchAllAcounts() in EmployeeDAO");
		
		List<CustomerPojo> allCustomers = new ArrayList<CustomerPojo>();
		Connection conn = DBUtil.obtainConnection();	
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM customer_details";
			ResultSet rs = stmt.executeQuery(query);
			//System.out.println("this is rs from em dao: " + rs);
			while(rs.next()) {
				//System.out.println("entered while in ep dao" + rs.next());
				CustomerPojo customerPojo = new CustomerPojo();
				customerPojo.setUserID(rs.getInt(1));
				customerPojo.setAccNumber(rs.getInt(3));
				customerPojo.setAccName(rs.getString(4));
				customerPojo.setAccBalance(rs.getInt(5));
				customerPojo.setCustomerContact(rs.getInt(6));
				customerPojo.setCustomerAddress(rs.getString(7));
				allCustomers.add(customerPojo);
				//System.out.println("this is customer info from ep dao: " + allCustomers);
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited fetchAllAcounts() in EmployeeDAO");
		return allCustomers;
	}

	@Override
	public boolean epLogin(int epID, int epPassword) throws SystemException {
		LOG.info("Entered epLogin() in EmployeeDAO");

		boolean login = false;
		Connection conn = DBUtil.obtainConnection();
		int id = 0;
		int password = 0;
		
		try {
			Statement stmt = conn.createStatement();
			//String query = "SELECT ep_id, ep_password FROM employee_details";
			String query = "SELECT * FROM employee_details WHERE ep_id=" + epID;
			ResultSet rs = stmt.executeQuery(query);
			//System.out.println("this is rs from epDAOImpl: " + rs);
			if(rs.next()) {
				id = rs.getInt(1);
				password = rs.getInt(2);
				//System.out.println("this is id from epdao: " + id);
				//System.out.println("this is password from epdao: " + password);
				if(id == epID && password == epPassword) {
					login = true;
					//break;
				}
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited epLogin() in EmployeeDAO");
		return login;
	}


	@Override
	public CustomerPojo registerCustomer(CustomerPojo customerPojo) throws SystemException {
		LOG.info("Entered registerCustomer() in EmployeeDAO");

		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			
			String query = "INSERT INTO customer_details(user_pin, acc_name, acc_balance, customer_contact, customer_add) VALUES("+customerPojo.getUserPin()+",'"+customerPojo.getAccName()+"',"+customerPojo.getAccBalance()+","+customerPojo.getCustomerContact()+",'"+customerPojo.getCustomerAddress()+"')";         
			int rows = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited registerCustomer() in EmployeeDAO");
		return customerPojo;
	}

	@Override
	public CustomerPojo fetchaAccount(int userID) throws SystemException {
		LOG.info("Entered fetchaAccount() in EmployeeDAO");

		CustomerPojo customerPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM customer_details WHERE useid=" + userID;
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				customerPojo = new CustomerPojo();
				customerPojo.setUserID(rs.getInt(1));
				customerPojo.setAccNumber(rs.getInt(3));
				customerPojo.setAccName(rs.getString(4));
				customerPojo.setAccBalance(rs.getInt(5));
				customerPojo.setCustomerContact(rs.getInt(6));
				customerPojo.setCustomerAddress(rs.getString(7));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited fetchaAccount() in EmployeeDAO");
		return customerPojo;
	}

	@Override
	public EmployeePojo fetchAEPAcc(int epID) throws SystemException {
		LOG.info("Entered fetchAEPAccount() in EmployeeDAO");

		EmployeePojo employeePojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM employee_details WHERE ep_id=" + epID;
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				employeePojo = new EmployeePojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
			
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited fetchAEPAccount() in EmployeeDAO");
		return employeePojo;
	}



}
