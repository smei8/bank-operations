package exception;

public class LoginException extends Exception {

	@Override
	public String getMessage() {
		return "The User ID or Password you entered does not match our records!";
	}

	
}
