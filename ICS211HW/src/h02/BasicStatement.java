package h02;

public class BasicStatement extends Statement {
	public BasicStatement(String[] tokens) {
		this.tokens = tokens;
	}

	//implementing statement method
	public boolean isCompound() {
		return false;
	}

}