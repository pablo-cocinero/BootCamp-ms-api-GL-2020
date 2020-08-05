package mockito.example.services.exceptions;

public class ZeroDivisionException extends Exception{

	
	private static final long serialVersionUID = -6854465678932811956L;
	String message;
	
	public ZeroDivisionException() {}
	
	public ZeroDivisionException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
