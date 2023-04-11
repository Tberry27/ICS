package h07;

import java.util.EmptyStackException;

public class LinkedStack<E> implements StackInterface<E> {
	/**
	 * @author Tanner Berry Homework 07
	 */

	private static class LinkedNode<T> {
		private T item;
		private LinkedNode<T> next;

		/**
		 * constructor to build a node with no successor
		 * 
		 * @param the value to be stored by this node
		 */
		private LinkedNode(T value) {
			item = value;
			next = null;
		}

		// constructor that creates nodes using the value to be stored and the reference
		// of the next node in list
		private LinkedNode(T value, LinkedNode<T> reference) {
			item = value;
			next = reference;
		}
	}

	// creating top node and size variable to track amount of nodes
	protected LinkedNode<E> top;
	private int size;

	// no-arguments default constructor creates an empty stack
	public LinkedStack() {
		top = null;
		size = 0;
		checkInvariants();
	}

	// @return whether the stack is empty
	public boolean empty() {
		checkInvariants();
		return (top == null);
	}

	// adds new value to the top of stack and reassigns top to new addition
	public E push(E value) {
		top = new LinkedNode<E>(value, top);
		size++;
		checkInvariants();
		return value;
	}

	// removes top node by setting top to next node in link then decrements size of
	// linklist variable
	public E pop() throws EmptyStackException {
		checkInvariants();
		if (empty()) {
			throw new EmptyStackException();
		}
		E result = top.item;
		top = top.next;
		size--;
		checkInvariants();
		return result;
	}

	// returns value of top position node
	public E peek() throws EmptyStackException {
		checkInvariants();
		if (empty()) {
			throw new EmptyStackException();
		}
		checkInvariants();
		return top.item;
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
			return recursiveToString(top);
		}
	}

	/*
	 * recursive method to print a non-empty stack
	 * 
	 * @param the starting index in the array
	 * 
	 * @return a string representing the stack
	 */
	private String recursiveToString(LinkedNode<E> startNode) {
		if (startNode == null) {
			return "";
		}
		String separator = "";
		if (startNode != top) { // add :: after each item (but not at start)
			separator = " :: ";
		}
		return separator + startNode.item + recursiveToString(startNode.next);
	}

	// used by check invariants method to throw assertion errors for untrue
	// invariant checks
	private void verify(boolean mustBeTrue) {
		if (!mustBeTrue) {
			throw new java.lang.AssertionError("assertion error");
		}
	}

	// verifies all Invariants associated with the Linked stack are true
	private void checkInvariants() {
		verify((top == null) == (size == 0));
		verify(size >= 0);
		int measuredSize = 0;
		LinkedNode<E> current = top;
		while (current != null) {
			measuredSize++;
			current = current.next;
		}
		verify(measuredSize == size);
	}

// simple test
	public static void main(String[] args) {
		StackInterface<String> s = new LinkedStack<String>();

		System.out.println("before pushing anything, " + s);
		s.push("one");
		s.push("two");
		System.out.println("after pushing one and two, " + s);
		System.out.println("pop returns " + s.pop());
		System.out.println("after popping, " + s);
		StackInterface<Integer> si = new LinkedStack<Integer>();
// push 100 values -- this is fine for LinkedStack
		for (int i = 0; i < 100; i++) {
			si.push(i);
		}
// now pop them and make sure the same values are returned
// in LIFO order
		for (int i = 99; i >= 0; i--) {
			Integer returned = si.pop();
			if (!returned.equals(i)) {
				System.out.println("error: pop returns " + returned + ", expected " + i);
			}
		}
		s.push("a");
		s.push("dreadful");
		s.push("night");
		System.out.println("after pushing 'a dreadful night', " + s);
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("pop returns " + s.pop());
		System.out.println("after popping, " + s);
	}

}