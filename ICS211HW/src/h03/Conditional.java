package h03;

public class Conditional extends CompoundStatement {

	// checks to see if the string of tokens contains else and is a 2 part
	// conditional
	private static boolean hasElse(String[] tokens) {
		for (String t : tokens) {
			if (t.equals("else")) {
				return true;
			}
		}
		return false;
	}

	// constructor that calls to super and checks to verify is criteria is met
	public Conditional(String[] newTokens) throws InvalidStatementException {
		super();
		if ((newTokens.length < 5) || (!newTokens[0].equals("if")) || (!newTokens[1].equals("("))
				|| (!hasElse(newTokens)) || (!newTokens[newTokens.length - 1].equals("}"))) {
			tokens = null;
			String error = "Not a conditional: " + concatenate(newTokens);
			throw new InvalidStatementException(error);
		}
		tokens = newTokens;
	}

	// constructor that takes 3 parameters and filles in the missing parts of a
	// conditional statement to create a fully formed conditional statement
	public Conditional(String[] condition, Statement[] thenPart, Statement[] elsePart)
			throws InvalidStatementException {
		String delim = "'";
		StringBuilder sb = new StringBuilder();
		sb.append("if");
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

		String[] thenTokens = tokenizeStatements(thenPart);
		// use a for loop to add in the thenTokens

		for (int i = 0; i < thenTokens.length; i++) {
			sb.append(thenTokens[i]);
			sb.append(delim);
		}
		sb.append("}");
		sb.append(delim);
		sb.append("else");
		sb.append(delim);
		sb.append("{");
		sb.append(delim);
		String[] elseTokens = tokenizeStatements(elsePart);

		// use a for loop to add in the elsetokens

		for (int i = 0; i < elseTokens.length; i++) {
			sb.append(elseTokens[i]);
			sb.append(delim);
		}
		sb.append("}");

		// add in the last token. no delimiter after last token
		tokens = sb.toString().split(delim);
	}

	// returns 2 for number of parts in a conditional
	public int numberOfParts() {
		return 2; // then part and else part
	}

}
