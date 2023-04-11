package h02;

public class InvalidStatementException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 2 constructors w/ no parameters w/ String paramenter both call super class
	 */
	public InvalidStatementException() {
		super("An InvalidStatementException occurred");

	}

	public InvalidStatementException(String msg) {
		super(msg);
	}
}
