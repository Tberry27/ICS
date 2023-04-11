package h07;

import java.util.Stack;

public class JavaStandardLibraryStack<E> extends Stack<E> implements StackInterface<E> {
	private static final long serialVersionUID = 1L;

	public JavaStandardLibraryStack() {
		super();
	}

	public E push(E value) {
		super.push(value);
		return value;
	}

	public E pop() throws java.util.EmptyStackException {
		E val = super.pop();
		return val;
	}

	public E peek() throws java.util.EmptyStackException {
		E val = super.peek();
		return val;
	}

	public boolean empty() {
		return super.empty();
	}
}