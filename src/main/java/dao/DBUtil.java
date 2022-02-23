package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.SystemException;


public class DBUtil {
	
	static Connection conn;
	
	static {
		//step 1
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static Connection obtainConnection() throws SystemException { //throws SystemException { //by making it static, i dont have to create an object of the class to call this method 
										   // i could just call 
		//design pattern - singleton design1pattern(making sure there is only one connection we are obtaining)
		
		//step 2
		String connectionURL = "jdbc:postgresql://localhost:5432/bank_management";
		String userName = "postgres";
		String password = "Aug211997!";

		if(conn == null) { //if the connection is not open
			try {
				conn = DriverManager.getConnection(connectionURL, userName, password);
			} catch (SQLException e) {
				throw new SystemException();
			}
		}
		
		return conn;
	}
	
	static void closeConnection() throws SystemException { //throws SystemException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new SystemException();
		}
	}
}
