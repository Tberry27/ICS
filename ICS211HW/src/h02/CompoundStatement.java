package h02;

public abstract class CompoundStatement extends Statement {
	public boolean isCompound() {
		return true;
	}

	//creating number of parts method for other classes to implement
	public abstract int numberOfParts();

}
