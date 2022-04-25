package exception;

public class AccountNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "No Account Added in the Collection yet!";
	}
	
	
}
