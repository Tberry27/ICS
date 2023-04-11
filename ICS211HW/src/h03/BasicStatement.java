package h03;

public class BasicStatement extends Statement {

	// constructor that calls to super and checks to verify is criteria is met
	public BasicStatement(String[] newTokens) {
		tokens = newTokens;
	}

	public boolean isCompound() {
		return false;
	}

}
