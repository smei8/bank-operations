package junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import exception.SystemException;
import pojo.CustomerPojo;
import pojo.EmployeePojo;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class FetchAccountTest {

	@Test
	public void testFetchCustomerAccount() throws SystemException {
		
		CustomerService customerService = new CustomerServiceImpl();
		
		CustomerPojo actualResult = customerService.fetchAAccount(12);
		CustomerPojo expectedResult = new CustomerPojo(12, 111, "Levi Ackerman", 7500, 45678, "90 attack st");
		
		assertArrayEquals(expectedResult, actualResult);
		assertEquals(12, actualResult.getUserID());
		
	}
	
	@Test
	public void testFetchEmployeeAccount() throws SystemException {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		EmployeePojo actualResult = employeeService.fetchAEPAcc(1);
		EmployeePojo expectedResult = new EmployeePojo(1, "JASON L", 24652, "65 UP ST");
		
		assertArrayEquals(expectedResult, actualResult);
		assertEquals(1, actualResult.getEpID());
	}

	private void assertArrayEquals(EmployeePojo expectedResult, EmployeePojo actualResult) {		
	}

	private void assertArrayEquals(CustomerPojo expectedResult, CustomerPojo actualResult) {
	}

}
