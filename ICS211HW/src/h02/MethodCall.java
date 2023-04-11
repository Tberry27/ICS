package h02;

public class MethodCall extends BasicStatement {

	//constructor that verifies statement meets qualifications of a methodcall
	MethodCall(String[] tokens) {
		super(tokens);
		if (!isIdentifier(tokens[0]) || !tokens[1].equals("(") || !tokens[tokens.length - 2].equals(")")
				|| !tokens[tokens.length - 1].equals(";")) {
			tokens = null;
		}

	}

	//creating method to retrieve method name token
	public String getMethodName() {
		String methodName = tokens[0];
		return methodName;
	}
}
