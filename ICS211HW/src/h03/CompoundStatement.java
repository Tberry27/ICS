package h03;

public abstract class CompoundStatement extends Statement {

	// returns true that a compound statement is compound
	public boolean isCompound() {
		return true;
	}

	// creates method for sub classes it use
	public abstract int numberOfParts();

}
