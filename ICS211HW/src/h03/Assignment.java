package h03;

public class Assignment extends BasicStatement {

	// constructor that calls to super and checks to verify is criteria is met
	public Assignment(String[] newTokens) throws InvalidStatementException {
		super(newTokens); // tokens = newTokens
		if ((newTokens.length < 3) || (!isVariable(newTokens[0])) || (!newTokens[1].equals("="))
				|| (!newTokens[newTokens.length - 1].equals(";"))) {
			tokens = null; // reset tokens to null
			String error = "Not an assignment: " + concatenate(newTokens);
			throw new InvalidStatementException(error);
		}
	}

	// Constructor that takes in 2 parameters and creates a usable assignment
	// statement
	public Assignment(String variable, String[] expression) throws InvalidStatementException {
		this(makeTokens("Assignment", variable, "=", expression));
	}

	// returns the variable of the instance
	public String getVariable() {
		return tokens[0];
	}
}
