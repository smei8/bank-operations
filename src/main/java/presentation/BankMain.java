package presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.SystemException;
import pojo.CustomerPojo;
import pojo.EmployeePojo;
import pojo.TransactionPojo;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class BankMain {

	public static final Logger LOG = LogManager.getLogger(BankMain.class);
	
	public static void main(String[] args) {

		// object var pointing to employee serviceimpl
		EmployeeService employeeService = new EmployeeServiceImpl();
		// object var pointing to customer serviceimpl
		CustomerService customerService = new CustomerServiceImpl();

		Scanner scan = new Scanner(System.in);
		char ch = 'y';
		while (ch == 'y') {
			// Main menu
			System.out.println("********************************************************************");
			System.out.println("Welcome to Bank of Suzanna!");
			System.out.println("********************************************************************");
			System.out.println("1. Login as Employee");
			System.out.println("2. Login as Customer");
			System.out.println("3. Exit");
			System.out.println("********************************************************************");
			System.out.println("Please select an option:");

			// get options from input
			int option = scan.nextInt();
			scan.nextLine();

			switch (option) {
			case 1:
				// employee login
				System.out.println("Employee ID: ");
				int epID = scan.nextInt();
				System.out.println("Password: ");
				int epPassword = scan.nextInt();

				// System.out.println("this is from main" + employeeService.epLogin(epID,
				// epPassword));
				try {
					while (employeeService.epLogin(epID, epPassword) == false) {
						System.out.println("Employee ID or Password does not match our records!");
						System.out.println("Please try again!");
						System.out.println("Employee ID: ");
						epID = scan.nextInt();
						System.out.println("Password: ");
						epPassword = scan.nextInt();
					}
				} catch (SystemException e) {
					LOG.error(e);
					e.printStackTrace();
				}
				char ch1 = 'y';
				while (ch1 == 'y') {
					// entering the employee menu after logging in if eplogin returns true
					try {
						if (employeeService.epLogin(epID, epPassword) == true) {

							System.out.println("--------------------------------------------------------------------");
							System.out.println("Employee Menu");
							System.out.println("--------------------------------------------------------------------");
							System.out.println("1. Register new customer account");
							System.out.println("2. View all account information");
							System.out.println("3. Logout");
							System.out.println("--------------------------------------------------------------------");
							System.out.println("Please select an option:");

							int selection = scan.nextInt();
							scan.nextLine();

							switch (selection) {
							case 1: // register new customer account
								CustomerPojo newCustomer = new CustomerPojo();

								System.out.println("Enter Customer's First and Last Name: ");
								newCustomer.setAccName(scan.nextLine());
								System.out.println("Enter a pin number: ");
								newCustomer.setUserPin(scan.nextInt());
								System.out.println("Enter the amount you want to deposit: ");
								newCustomer.setAccBalance(scan.nextInt());
								System.out.println("Enter Customer's Phone Number: ");
								newCustomer.setCustomerContact(scan.nextInt());
								System.out.println("Enter Customer's Address: ");
								scan.nextLine();
								newCustomer.setCustomerAddress(scan.nextLine());
								// scan.next();

								// EmployeePojo addedCustomer = employeeService.registerCustomer(newCustomer);
								CustomerPojo addedCustomer;

								addedCustomer = employeeService.registerCustomer(newCustomer);
								System.out.println("Account successfully created!");
								break;

							case 2: // fetch all account information
								List<CustomerPojo> allCustomers;

								allCustomers = employeeService.fetchAllAccounts();
								Iterator<CustomerPojo> itr = allCustomers.iterator();
								// System.out.println("this is all customer from main! " + allCustomers);
								System.out.println(
										"--------------------------------------------------------------------------------------------------------------");
								System.out.printf("%20s %20s %20s %20s %20s %20s\n",
										"User ID", "Account Number", "Customer Name", "Account Balance", "Customer Contact", "Customer Address");
								System.out.println(
										"--------------------------------------------------------------------------------------------------------------");
								while (itr.hasNext()) {
									CustomerPojo customer = itr.next();
									System.out.format("%20s %20s %20s %20s %20s %20s\n",
											customer.getUserID(), customer.getAccNumber(), customer.getAccName(), customer.getAccBalance(),
											customer.getCustomerContact(), customer.getCustomerAddress());
								}
								// System.out.println("this is all customer from main! " + allCustomers);
								break;
//								
//							case 3:	//logout
//								System.out.println("--------------------------------------------------------------------");
//								System.out.println("Logging out ... ");
//								System.out.println("Successfully Logged Out !");
//								System.out.println("--------------------------------------------------------------------");
//
//								break;
							}
						}
					} catch (SystemException e) {
						LOG.error(e);
						System.out.println(e.getMessage());
					}

					System.out.println("Do you want to continue? (y/n): ");
					ch1 = scan.next().charAt(0);
				
				}
				if (ch1 == 'n') {
					// case 3: // logout return to employee menu
					System.out.println("--------------------------------------------------------------------");
					System.out.println("Logging out ... ");
					System.out.println("Successfully Logged Out !");
					System.out.println("--------------------------------------------------------------------");

					break;
				}
				break;

			case 2:

				// customer login
				System.out.println("User ID: ");
				int userID = scan.nextInt();
				System.out.println("Password: ");
				int userPin = scan.nextInt();
				
				CustomerPojo customerLogin = new CustomerPojo();
				try {
					customerLogin = customerService.fetchAAccount(userID);
				} catch (SystemException e1) {
					LOG.error(e1);
					System.out.println(e1.getMessage());
				}

				try {
					while (customerService.customerLogin(userID, userPin) == false) {
						System.out.println("User ID or Pin does not match our records");
						System.out.println("Please try again!");
						System.out.println("User ID: ");
						userID = scan.nextInt();
						System.out.println("Password: ");
						userPin = scan.nextInt();
					}
				} catch (SystemException e) {
					LOG.error(e);
					System.out.println(e.getMessage());
				}

				char ch2 = 'y';
				while (ch2 == 'y') {

					// entering the customer menu after logging in
					try {
						if (customerService.customerLogin(userID, userPin) == true) {
							System.out.println("Hello, " + customerLogin.getAccName());
							System.out.println("-------------------------------------------------------------------------------");
							System.out.println("Customer Menu");
							System.out.println("-------------------------------------------------------------------------------");
							System.out.println("1. View account detail");
							System.out.println("2. Transfer Money");
							System.out.println("3. View transaction history");
							// System.out.println("4. Logout");
							System.out.println("-------------------------------------------------------------------------------");
							System.out.println("Please select an option:");
							int selection = scan.nextInt();
							scan.nextLine();

							switch (selection) {
							case 1: // view account detail
								// List<CustomerPojo> allCustomers;
								CustomerPojo customer = new CustomerPojo();

								System.out.println("Enter your pin number: ");
								int pin = scan.nextInt();
								customer = customerService.viewAccount(userID, pin);

								System.out.println("User ID: " + customer.getUserID());
								System.out.println("Account Number: " + customer.getAccNumber());
								System.out.println("Account Name: " + customer.getAccName());
								System.out.println("Account Balance: " + customer.getAccBalance());
								System.out.println("Contact Number: " + customer.getCustomerContact());
								System.out.println("Address: " + customer.getCustomerAddress());

								break;

							case 2: // transfer money
								// List<CustomerPojo> allCustomers = customer
								CustomerPojo moneyTransfer = new CustomerPojo();
						
								System.out.println("Account Number you want to transfer money to: ");
								int toAccNum = scan.nextInt();
								System.out.println("Transfer amount: ");
								int amount = scan.nextInt();
								
								moneyTransfer = customerService.fetchAAccount(userID);
								int fromAccNum = moneyTransfer.getAccNumber();
								
								customerService.moneyTransfer(fromAccNum, toAccNum, amount);
								System.out.println("Money Transfered Successfully!");
								double updatedBalance = moneyTransfer.getAccBalance() - amount;
								System.out.println("You new balance is " + updatedBalance);
								
								break;
							case 3: // view transaction history
								List<TransactionPojo> allTransaction;
								CustomerPojo customer1 = new CustomerPojo();
								
								customer1 = customerService.fetchAAccount(userID);
								int accNumber = customer1.getAccNumber(); 
								allTransaction = customerService.viewTransactionHist(accNumber);
								Iterator<TransactionPojo> itr = allTransaction.iterator();
								
								System.out.println(
										"--------------------------------------------------------------------------------------------------------------");
								System.out.printf("%20s %20s %20s %20s %20s %20s\n",
										"Transaction ID", "Account", "Transfered To", "Balance", "Transfered Amount", "Transfer Date");
								System.out.println(
										"--------------------------------------------------------------------------------------------------------------");
								while (itr.hasNext()) {
									TransactionPojo transaction = itr.next();
									System.out.format("%20s %20s %20s %20s %20s %20s\n",
											transaction.getTransactionId(), transaction.getAccName(),
											transaction.getToAccNum(), transaction.getAccBalance(), transaction.getTransferAmount(), 
											transaction.getTransferDate());
								}
								// System.out.println("this is all customer from main! " + allCustomers);
								break;
							}
						}
					} catch (SystemException e) {
						LOG.error(e);
						System.out.println(e.getMessage());
					}
					System.out.println("Do you want to continue? (y/n): ");
					ch2 = scan.next().charAt(0);
				}

				// case 4: // logout
				if (ch2 == 'n') {
					System.out.println("--------------------------------------------------------------------");
					System.out.println("Logging out ... ");
					System.out.println("Successfully Logged Out !");
					System.out.println("--------------------------------------------------------------------");

					break;
				}
				// System.out.println("Do you want to continue? (y/n): ");
				// ch2 = scan.next().charAt(0);
				break;
				
			case 3:
				System.out.println(
						"*********************************************************************************************************");
				System.out.println("Exiting the system ... ");
				System.out.println("Thank you for using Bank of Suzanna!");
				System.out.println(
						"*********************************************************************************************************");
				try {
					employeeService.exitApplication();
				} catch (SystemException e) {
					LOG.error(e);
					System.out.println(e.getMessage());
				}
				
				System.exit(0);

			}

			System.out.println("Would you like to return to the main menu? (y/n): ");
			ch = scan.next().charAt(0);
			
			if(ch == 'n') {
				System.out.println(
						"*********************************************************************************************************");
				System.out.println("Exiting the system ... ");
				System.out.println("Thank you for using Bank of Suzanna!");
				System.out.println(
						"*********************************************************************************************************");
				
				try {
					employeeService.exitApplication();
				} catch (SystemException e) {
					LOG.error(e);
					System.out.println(e.getMessage());
				}
				
				
				System.exit(0);
			
			}
		}
	}
}

