package junit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import exception.SystemException;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class LoginTest {

	@Test
	public void customerLogin() {
		CustomerService customerService = new CustomerServiceImpl();
		boolean actualResult = false;
		
		try {
			actualResult = customerService.customerLogin(5, 1425);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		boolean expectedResult = true;
		assertTrue(actualResult);
	}
	
	@Test
	public void employeeLogin() {
		EmployeeService employeeService = new EmployeeServiceImpl();
		boolean actualResult = false;
		
		try {
			actualResult = employeeService.epLogin(1, 1234);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		boolean expectedResult = true;
		assertTrue(actualResult);
	}
}
