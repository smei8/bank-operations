package junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.SystemException;
import pojo.TransactionPojo;
import service.CustomerService;
import service.CustomerServiceImpl;

public class CustomerTest {

	@Test
	public void testMoneyTransfer() throws SystemException {
		
		CustomerService customerService = new CustomerServiceImpl();
		
		TransactionPojo actualResult = customerService.moneyTransfer(111, 110, 42);
		//System.out.println(actualResult);
		TransactionPojo expectedResult = new TransactionPojo(111, 110, 42, "2022-04-25");
		
		assertArrayEquals(expectedResult, actualResult);
		assertEquals(expectedResult.getTransferAmount(), actualResult.getTransferAmount());
		
	}
	
	@Test
	public void testViewTransactionHis() throws SystemException {
		
		CustomerService customerService = new CustomerServiceImpl();
		
		List<TransactionPojo> actualResult = customerService.viewTransactionHist(112);
		List<TransactionPojo> expectedResult = new ArrayList<TransactionPojo>();
		
		TransactionPojo transactionPojo = new TransactionPojo(113, 112, 12, "2022-04-25");
		expectedResult.add(transactionPojo);
		
		assertArrayEquals(expectedResult, actualResult);
		
	}

	private void assertArrayEquals(List<TransactionPojo> expectedResult, List<TransactionPojo> actualResult) {		
	}

	private void assertArrayEquals(TransactionPojo expectedResult, TransactionPojo actualResult) {		
	}
}
