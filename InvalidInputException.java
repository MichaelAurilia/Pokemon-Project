//Class that allows errors to be thrown in case of invalid inputs by the user.
public class InvalidInputException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String message) {
		super(message);
	}
}
