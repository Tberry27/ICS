package h02;

public class Conditional extends CompoundStatement {

	//constructor that verifies array meets qualifications of a conditional statement 
	Conditional(String[] tokens) {
		this.tokens= tokens;
	
		if (numberOfParts() != 2 || !tokens[0].equals("if") || !tokens[1].equals("(")
				|| !tokens[tokens.length - 1].equals("}")) {
			tokens = null;
		}

	}

	// Implementation of isCompound method
	public boolean isCompound() {
		return true;
	}
	
	//Implementation of numerOfParts method
	public int numberOfParts() {
		int numParts = 1;
		for (int i = 0, j = 1; i < tokens.length - 2; i++, j++) {
			if (tokens[i].equals("else") && tokens[j].equals("{")) {
				numParts++;
			}
		}
		return numParts;
	}
}
