package h03;

public class MethodCall extends BasicStatement {

	// constructor to verify and call to super class for the parameter to be set to
	// super class variable token
	public MethodCall(String[] newTokens) throws InvalidStatementException {
		super(newTokens);
		if ((newTokens.length < 4) || (!isVariable(newTokens[0])) || (!newTokens[1].equals("("))
				|| (!newTokens[newTokens.length - 2].equals(")")) || (!newTokens[newTokens.length - 1].equals(";"))) {
			tokens = null;
			String error = "Not a method call: " + concatenate(newTokens);
			throw new InvalidStatementException(error);
		}
	}

	// constructor that takes in 2 parameters then builds missing parts around those
	// parameters to create a complete method call statement
	public MethodCall(String method, String[] parameters) throws InvalidStatementException {
		this(makeTokens("MethodCall", method, "(", parameters));
	}

	// returns index of tokens that holds the method
	public String getMethod() {
		return tokens[0];
	}
}
