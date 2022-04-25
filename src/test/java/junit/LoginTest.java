package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import exception.SystemException;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class LoginTest {

	@Test
	public void testCustomerLogin() throws SystemException {
		CustomerService customerService = new CustomerServiceImpl();
		
		boolean actualResult = customerService.customerLogin(11, 8021);
		boolean expectedResult = true;
		
		//assertTrue(actualResult);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testEmployeeLogin() throws SystemException {
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		boolean actualResult = employeeService.epLogin(1, 1234);
		boolean expectedResult = true;
		
		//assertTrue(actualResult);
		assertEquals(expectedResult, actualResult);	
	}
}
