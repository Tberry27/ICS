package h03;

public class InvalidStatementException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidStatementException() {
		super();
	}

	public InvalidStatementException(String message) {
		super(message);
	}

}