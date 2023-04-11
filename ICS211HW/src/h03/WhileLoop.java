package h03;

public class WhileLoop extends CompoundStatement {

	// constructor that verifies that parameter meets requirements of a while loop
	public WhileLoop(String[] newTokens) throws InvalidStatementException {
		super();
		if ((newTokens.length < 6) || (!newTokens[0].equals("while")) || (!newTokens[1].equals("("))
				|| (!newTokens[newTokens.length - 1].equals("}"))) {
			tokens = null;
			String error = "Not a while loop: " + concatenate(newTokens);
			throw new InvalidStatementException(error);
		}
		tokens = newTokens;
	}

	// constructor that takes in 2 parameters and uses string builder to add any
	// missing tokens to create a fully formed while loop statement
	public WhileLoop(String[] condition, Statement[] loopBody) throws InvalidStatementException {
		String delim = "'";
		StringBuilder sb = new StringBuilder();
		sb.append("while");
		sb.append(delim);
		sb.append("(");
		sb.append(delim);
		for (int i = 0; i < condition.length; i++) {
			sb.append(condition[i]);
			sb.append(delim);
		}
		sb.append(")");
		sb.append(delim);
		sb.append("{");
		sb.append(delim);
		String[] statementTokens = tokenizeStatements(loopBody);
		for (int i = 0; i < statementTokens.length; i++) {
			sb.append(statementTokens[i]);
			sb.append(delim);
		}
		sb.append("}");
		tokens = sb.toString().split(delim);
	}

	// returns number of parts of a while loop as 1
	public int numberOfParts() {
		return 1;
	}

}
