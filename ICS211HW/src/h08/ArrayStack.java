package h08;

import java.util.EmptyStackException;

public class ArrayStack<E> implements StackInterface<E> {

	// storing elements and tracking the top stack position
	private int top;
	private Object[] array;
	// creating int to track the current size of the stack
	private int size;

	// empty stack default construtor with 6 items
	public ArrayStack() {
		top = -1; // empty stack
		array = new Object[10]; // make room for at most 10 items
		size = 0;
		checkInvariants();
	}
	//size method to return current size of stack
	public int size() {
		return size;
	}

	// @return whether the stack is empty
	public boolean empty() {
		checkInvariants();
		boolean isEmpty = (top == -1);
		checkInvariants();
		return isEmpty;
	}

	// method to push items onto the stack
	public E push(E value) throws FullStackException {
		checkInvariants();
		// full Stack throws exception
		if (top == array.length - 1) {
			throw new FullStackException("Stack is already full");
		}
		// incrementing size, top positon and assigning new value to top of stack
		else {
			top++;
			array[top] = value;
			size++;
		}
		checkInvariants();
		return value;
	}

	/*
	 * removes top position item and returns removed value catches any out of bound
	 * calls to pop sets top value to null and reassigns top down 1 position
	 */
	@SuppressWarnings("unchecked")
	public E pop() throws EmptyStackException {
		checkInvariants();
		try {
			E value = (E) array[top];
			array[top] = null;
			top--;
			//decrementing the size
			size--;
			checkInvariants();
			return value;
		} catch (ArrayIndexOutOfBoundsException error) {
			top = -1;
			checkInvariants();
			throw new EmptyStackException();

		}
	}

	// takes a little peek at the peek of the stack returning top position item
	@SuppressWarnings("unchecked")
	public E peek() throws EmptyStackException {
		checkInvariants();
		E value = null;
		try {
			value = (E) array[top];

		} catch (ArrayIndexOutOfBoundsException error) {
			top = -1;
			checkInvariants();
			throw new EmptyStackException();
		}
		checkInvariants();
		return value;
	}

	/*
	 * convert the stack to a printable string
	 * 
	 * @return a string representing the stack
	 */
	public String toString() {
		checkInvariants();
		if (empty()) {
			return "Empty Stack";
		} else {
			checkInvariants();
			return recursiveToString(0);
		}
	}

	/*
	 * recursive method to print a non-empty stack and return printable string
	 * 
	 * @param the starting index in the array
	 */
	private String recursiveToString(int startPos) {
		checkInvariants();
		if (startPos > top) {
			return "";
		}
		String separator = "";
		if (startPos > 0) {
			separator = " :: ";
		}
		checkInvariants();
		return separator + array[startPos] + recursiveToString(startPos + 1);
	}

	// used by check invariants method to throw assertion errors for untrue
	// invariant checks
	 private void verify(boolean mustBeTrue) {
		if (!mustBeTrue) {
			throw new java.lang.AssertionError("assertion error"); 
		}
	}
	

	// verifies all Invariants associated with the array stack are true
	private void checkInvariants() {
		verify((top == -1) == (array[0] == null));
		if (top != -1) {
			verify(array[top] != null);
		//	verify(size > 0);
		}
		verify(top >= -1);
		verify(top <= array.length - 1);
		verify(array.length == 10);
		
	}

	// simple test
	public static void main(String[] args) {
		StackInterface<String> s = new ArrayStack<String>();
		System.out.println("before pushing anything, " + s);
		s.push("hello");
		s.push("world");
		System.out.println("after pushing hello and world, " + s);
		System.out.println("pop returns " + s.pop());
		System.out.println("after popping, " + s);
		StackInterface<Integer> si = new ArrayStack<Integer>();
		// push 100 values
		for (int i = 0; i < 6; i++) {
			si.push(i);
		}
		// now pop them and make sure the same values are returned
		// in LIFO order
		for (int i = 5; i >= 0; i--) {
			Integer returned = si.pop();
			if (!returned.equals(i)) {
				System.out.println("error: pop returns " + returned + ", expected " + i);
			}
		}
		s.push("a");
		s.push("beautiful");
		s.push("day");
		System.out.println("after pushing 'a beautiful day', " + s);
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("after popping, " + s);

	}
}