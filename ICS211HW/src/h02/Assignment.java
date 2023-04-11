package h02;

public class Assignment extends BasicStatement {
	Assignment(String[] tokens) {
		super(tokens);
		if (tokens.length < 4 || !isIdentifier(tokens[0]) || !tokens[1].equals("=")
				|| !tokens[tokens.length - 1].equals(";")) {
			tokens = null;
		}

	}

	//creating method to retrieve variable token
	public String getVariable() {
		String variable = tokens[0];
		return variable;
	}

}
