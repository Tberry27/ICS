package h03;

public abstract class Statement {

	protected String[] tokens;

	public abstract boolean isCompound();

	// used by toString and also by subclasses
	protected static String concatenate(String[] args) {
		String result = "";
		String separator = ""; // initially no separator
		for (String t : args) {
			result = result + separator + t;
			separator = " "; // blank separator thereafter
		}
		return result;
	}

	// overrides toString method using the concatenate method to create a string of
	// the tokens
	public String toString() {
		return concatenate(tokens);
	}

	// compares two objects to verify if they are equal to one another
	public boolean equals(Object obj) {
		if (obj == null) { // guaranteed: this != null
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Statement st = (Statement) obj; // should never throw exception
		if ((st.tokens == null) != (this.tokens == null)) {
			return false; // only one of the two tokens is null
		}
		if (st.tokens == null) {
			return true; // both of the tokens are null
		}
		if (st.tokens.length != this.tokens.length) {
			return false;
		}
		for (int i = 0; i < this.tokens.length; i++) {
			// invariant: none of the tokens should be null
			if (!st.tokens[i].equals(this.tokens[i])) {
				return false;
			}
		}
		return true;
	}

	// used by subclasses to verify the tokens first char and body are correct for
	// being a java identifier
	protected static boolean isVariable(String var) {
		if (var.length() <= 0) { // empty strings are not variables
			return false;
		}
		// if any character fails to satisfy the requirements, return false
		if (!Character.isJavaIdentifierStart(var.charAt(0))) {
			return false;
		}
		for (int i = 1; i < var.length(); i++) {
			if (!Character.isJavaIdentifierPart(var.charAt(i))) {
				return false;
			}
		}
		// all requirements satisfied
		return true;
	}

	// method that combines the strings with ' to an array then adds any needed
	// tokens and then removes added delimiter to return created string
	protected static String[] makeTokens(String className, String first, String second, String[] list) {
		String delim = "'"; // used to split StringBuilder output into String[]
		StringBuilder sb = new StringBuilder();
		sb.append(first);
		sb.append(delim);
		sb.append(second);
		sb.append(delim);
		for (int i = 0; i < list.length; i++) {
			sb.append(list[i]);
			sb.append(delim);
		}
		if (className.equals("MethodCall")) {
			sb.append(")");
			sb.append(delim);
		}
		sb.append(";");

		return sb.toString().split(delim);
	}

	// uses string builder to add delimiter between statements array
	protected static String[] tokenizeStatements(Statement[] statements) {
		String delim = "'";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < statements.length; i++) {
			for (int j = 0; j < statements[i].tokens.length; j++) {
				sb.append(statements[i].tokens[j]);
				if (i < statements.length - 1) {
					sb.append(delim);
				}
			}
		}
		return sb.toString().split(delim);
	}

}
