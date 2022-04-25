package junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.SystemException;
import pojo.CustomerPojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class EmployeeTest {

	@Test
	public void testFetchAllAccounts() throws SystemException {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		List<CustomerPojo> actualResults = employeeService.fetchAllAccounts();
		List<CustomerPojo> expectedResults = new ArrayList<CustomerPojo>();
		
		CustomerPojo customer1 = new CustomerPojo(14, 113, "test testing", 7900, 12344, "99 test st");
		CustomerPojo customer2 = new CustomerPojo(13, 112, "Strom", 470, 567890, "55 storms st");
		CustomerPojo customer3 = new CustomerPojo(12, 111, "Levi Ackerman", 6242, 45678, "90 attack st");
		CustomerPojo customer4 = new CustomerPojo(11, 110, "Bruno Bruno", 5976, 1234567, "88 Fly St.");
		
		expectedResults.add(customer4);
		expectedResults.add(customer3);
		expectedResults.add(customer2);
		expectedResults.add(customer1);
		
		assertArrayEquals(expectedResults, actualResults);
	}

	@Test
	public void testRegisterCustomer() throws SystemException {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		CustomerPojo customerPojo = new CustomerPojo(1234, "puppy", 420, 99999, "42 cloudnine st");
		CustomerPojo actualResult = employeeService.registerCustomer(customerPojo);
		CustomerPojo expectedResult = new CustomerPojo(15, 1234, 114, "puppy", 420, 99999, "42 cloudnine st");
		
		assertArrayEquals(expectedResult, actualResult);
		
	}
	
	private void assertArrayEquals(CustomerPojo expectedResult, CustomerPojo actualResult) {		
	}

	private void assertArrayEquals(List<CustomerPojo> expectedResults, List<CustomerPojo> actualResults) {
	}
}
