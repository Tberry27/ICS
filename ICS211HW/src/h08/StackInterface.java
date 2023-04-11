package h08;

public interface StackInterface<E> {
	/*
	 * These are used to push pop and peek the stack *param value to push pop or
	 * peek with the stack *returns the inputed value
	 */
	E push(E value);

	E pop() throws java.util.EmptyStackException;

	E peek() throws java.util.EmptyStackException;

	/*
	 * USed to ID empty stack returns true or false based on emptiness of stack
	 */
	boolean empty();

	int size();
}
