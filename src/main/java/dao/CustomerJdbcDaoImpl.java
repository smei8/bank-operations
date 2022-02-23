package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.LoginException;
import exception.SystemException;
import pojo.CustomerPojo;
import pojo.EmployeePojo;
import pojo.TransactionPojo;

public class CustomerJdbcDaoImpl implements CustomerDao {

	public static final Logger LOG = LogManager.getLogger(CustomerJdbcDaoImpl.class);
	@Override
	public boolean customerLogin(int userID, int userPin) throws SystemException{
		LOG.info("Entered customerLogin() in CustomerDAO");

		boolean login = false;
		Connection conn = DBUtil.obtainConnection();
		int id = 0;
		int password = 0;
		
		try {
			Statement stmt = conn.createStatement();
			//String query = "SELECT ep_id, ep_password FROM employee_details";
			String query = "SELECT * FROM customer_details WHERE user_id=" + userID;
			ResultSet rs = stmt.executeQuery(query);
			//System.out.println("this is rs from epDAOImpl: " + rs);
			if(rs.next()) {
				id = rs.getInt(1);
				password = rs.getInt(2);
				//System.out.println("this is id from epdao: " + id);
				//System.out.println("this is password from epdao: " + password);
				if(id == userID && password == userPin) {
					login = true;
					//break;
					
				}
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited customerLogin() in CustomerDAO");
		return login;
	}

	@Override
	public CustomerPojo viewAccount(int userID, int userPin) throws SystemException {
		LOG.info("Entered viewAccount() in CustomerDAO");

		CustomerPojo customerPojo = null;
		Connection conn = DBUtil.obtainConnection();
		int password = 0;
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM customer_details WHERE user_id=" + userID;
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				password = rs.getInt(2);
				if (password == userPin) {
					customerPojo = new CustomerPojo();
					customerPojo.setUserID(rs.getInt(1));
					customerPojo.setAccNumber(rs.getInt(3));
					customerPojo.setAccName(rs.getString(4));
					customerPojo.setAccBalance(rs.getInt(5));
					customerPojo.setCustomerContact(rs.getInt(6));
					customerPojo.setCustomerAddress(rs.getString(7));
				}
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited viewAccount() in CustomerDAO");
		return customerPojo;
	}

	@Override
	public TransactionPojo moneyTransfer(int fromAccNum, int toAccNum, int balance) throws SystemException {
		LOG.info("Entered moneyTransfer() in CustomerDAO");
		//TransactionPojo transactionPojo = null;
		//CustomerPojo user1 = null;
		//CustomerPojo user2 = null;
		
		Connection conn = DBUtil.obtainConnection();
		int from = 0;
		int to = 0;
		//int transferMoney = 0;
		
		Statement stmt;
		try {
			stmt = conn.createStatement();

			String query1 = "SELECT * FROM customer_details WHERE acc_number=" + fromAccNum;
			ResultSet rs1 = stmt.executeQuery(query1);
			if(rs1.next()) { from = rs1.getInt(3); }
			
			String query2 = "SELECT * FROM customer_details WHERE acc_number=" + toAccNum;
			ResultSet rs2 = stmt.executeQuery(query2);
			if(rs2.next()) { to = rs2.getInt(3); }
			
			String query3 = "UPDATE customer_details SET acc_balance=acc_balance-"+balance+"WHERE acc_number="+from;
			String query4 = "UPDATE customer_details SET acc_balance=acc_balance+"+balance+"WHERE acc_number="+to;
			String query5 = "INSERT INTO transaction_details(from_acc_number, to_acc_number, transfer_amount) VALUES("+fromAccNum+","+toAccNum+","+balance+")";  

			conn.setAutoCommit(false);
			int row1 = stmt.executeUpdate(query3);
			int row2 = stmt.executeUpdate(query4);	
			int row3 = stmt.executeUpdate(query5);
			conn.commit();
			
			//System.out.println("Money transfered successfully!");
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new SystemException();
			}
			throw new SystemException();
//		} finally {
//			try {
//				conn.close();
//				System.out.println("Transaction failed! Try again later!");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		}
	
		LOG.info("Exited moneyTransfer() in CustomerDAO");
		return null;
	}

	@Override
	public List<TransactionPojo> viewTransactionHist(int accNumber) throws SystemException {
		LOG.info("Entered viewTransactionHist() in CustomerDAO");
		System.out.println("entered transaction history");
		
		List<TransactionPojo> allTransaction = new ArrayList<TransactionPojo>();
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT transaction_id, acc_name, acc_number, to_acc_number, transfer_amount, acc_balance, transfer_date FROM customer_details INNER JOIN transaction_details ON transaction_details.from_acc_number=customer_details.acc_number WHERE acc_number="+accNumber;
			ResultSet rs = stmt.executeQuery(query);
			
			//System.out.println("query executed");
			
			while(rs.next()) {
				//System.out.println("rs is not null");
				TransactionPojo transactionPojo = new TransactionPojo();
				transactionPojo.setTransactionId(rs.getInt(1)); 
				transactionPojo.setAccName(rs.getString(2));
				transactionPojo.setFromAccNum(rs.getInt(3));
				transactionPojo.setToAccNum(rs.getInt(4));
				transactionPojo.setTransferAmount(rs.getInt(5));
				transactionPojo.setAccBalance(rs.getInt(6));
				transactionPojo.setTransferDate(rs.getString(7));
				allTransaction.add(transactionPojo);
			}
			
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		
		
		LOG.info("Exited viewTransactionHist() in CustomerDAO");
		
		return allTransaction;
	}

	@Override
	public CustomerPojo fetchAAccount(int userID) throws SystemException {
		LOG.info("Entered fetchAAccount() in CustomerDAO");

		CustomerPojo customerPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM customer_details WHERE user_id=" + userID;
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				customerPojo = new CustomerPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
			}
			
		} catch (SQLException e) {
			throw new SystemException();
		}
		
		LOG.info("Exited fetchAAccount() in CustomerDAO");
		return customerPojo;
	}

}
