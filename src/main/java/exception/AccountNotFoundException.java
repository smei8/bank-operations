package exception;

public class AccountNotFoundException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No Account Added in the Collection yet!";
	}
	
	
}
