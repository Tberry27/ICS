package h02;

public class WhileLoop extends CompoundStatement {

	//while loop constructor verifying array
	WhileLoop(String[] tokens) {
		this.tokens=tokens;
		if (numberOfParts() != 1 || !tokens[0].equals("while") || !tokens[1].equals("("))
			tokens = null;
	}

	//Implementing both super class methods
	public boolean isCompound() {
		return true;
	}
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

