package h02;

public abstract class Statement {

	protected String[] tokens;

	public static void main(String[] args) {

	}

	//verify first token to check if it is java identifier
	public boolean isIdentifier(String token) {
		token = token.trim();
		char t1 = token.charAt(0);
		if (token.length() == 0) {
			return false;
		}
		if (!Character.isJavaIdentifierStart(t1)) {
			return false;
		}
		for (int i = 1; i != token.length(); i++) {
			if (!Character.isJavaIdentifierPart(token.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	//creating boolean for other classes to implement
	public abstract boolean isCompound();

	//Creating equals method to compare two objects array of tokens
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Statement obj2 = (Statement) obj;
		if (obj2.getClass() != this.getClass()) {
			return false;
		}
		if (obj2.tokens.length != this.tokens.length) {
			return false;
		}
		for (int i = 0; i != this.tokens.length; i++) {
			if (!obj2.tokens[i].equals(this.tokens[i])) {
				return false;
			}
		}
		return true;
	}

	//Overriding toString method
	public String toString() {
		String concatStatement = String.join(" ", tokens);
		return concatStatement;
	}

}