/*
 * author: Tanner Berry
 * ICS 211 HW5
 * ( O() Analysis in Interface
 */

package h05;

public class SortedLinkedList<E extends Comparable<E>> implements SortedLinkedListInterface<E> {

	private static class LinkedNode<T> {
		private T item;
		private LinkedNode<T> next;

		// allows creation of Linked Node
		private LinkedNode(T value) {
			item = value;
			next = null;
		}

		// allows creation of linked Node with reference
		private LinkedNode(T value, LinkedNode<T> reference) {
			item = value;
			next = reference;
		}

		// toString override
		public String toString() {
			return this.item.toString();
		}
	}

	// instance variables for SortedLinkedList class
	protected LinkedNode<E> head;
	protected LinkedNode<E> tail;
	protected int size;

	// verification after adding and removing
	private void verify(boolean mustBeTrue) {
		if (!mustBeTrue) {
			throw new java.lang.AssertionError("assertion error");
		}
	}

	// verification tools and checks
	private void checkInvariants() {
		verify((head == null) == (tail == null));
		verify((size == 0) == (head == null));
		verify(size >= 0);
		verify((head == tail) == (size <= 1));
		verify((tail == null) || (tail.next == null));
		int measuredSize = 0;
		LinkedNode<E> visitedLast = null;
		verify(measuredSize == size);
		verify(visitedLast == tail);
	}

	// constructor for sorted link lists
	public SortedLinkedList() {
		head = null;
		tail = null;
		size = 0;
		checkInvariants();
	}

	/**
	 * helper method to add node to replace head
	 * @param the value to be added
	 */
	private void addAtFront(E value) {
		head = new LinkedNode<E>(value, head);
		if (tail == null) {
			tail = head;
		}
	}

	/**
	 * helper method to add node to replace tail
	 * @param the value to be added
	 * @throws RuntimeException
	 */
	private void addAtEnd(E value) {
		if (tail == null) {
			throw new RuntimeException("invalid call to addAtEnd, tail is null");
		}
		LinkedNode<E> newNode = new LinkedNode<E>(value);
		tail.next = newNode;
		tail = newNode;
	}

	/**
	 * helper method to add node after referenced position
	 * @param the node after which the new value is added
	 * @param the value to be added
	 */
	private void addAfter(LinkedNode<E> reference, E value) {
		if (reference == tail) { // if added at end, update tail value
			addAtEnd(value);
		} else {
			LinkedNode<E> newNode = new LinkedNode<E>(value, reference.next);
			reference.next = newNode;

		}
	}

	private LinkedNode<E> jump(int numJumps) {
		if (numJumps < 0) {
			return null;
		}
		LinkedNode<E> node = head;
		for (int i = 0; i < numJumps; i++) {
			node = node.next;
		}
		return node;
	}

	// returns size of linked list
	@Override
	public int size() {
		// this must be fixed.
		return size;
	}

	// returns value of node at specified node
	@Override
	public E get(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index to get node from");
		}
		LinkedNode<E> node = jump(index);
		return node.item;
	}

	// add method to add nodes to linked list in order using helper methods if not duplicate
	@Override
	public boolean add(E value) {
		if (size == 0) {
			addAtFront(value);
			size++;
			return true;
		} else {
			// finding the correct pos to insert value after
			LinkedNode<E> current = head;
			LinkedNode<E> prev = null;
			while (current != null && current.item.compareTo(value) < 0) {
				prev = current;
				current = current.next;
			}
			// of value is already in list returns false
			if (current != null && current.item.compareTo(value) == 0) {
				return false;
			}
			if (prev != null) {
				addAfter(prev, value);
				if (prev.next.next == null) {
					tail = prev.next;
				}

			} else {// for prev equal to null
				LinkedNode<E> newNode = new LinkedNode<E>(value);
				newNode.next = head;
				head = newNode;
			}
			size++;
			verify(true);
			return true;
		}
	}

	// remove method to get rid of node in linked list using helper methods if node exists
	@Override
	public boolean remove(E value) {
		int index = indexOf(value);
		if (index == -1) {
			return false;
		}
		LinkedNode<E> prev = jump(index - 1);
		if (prev == null) {// link to remove at head
			head = head.next;
		} else {
			prev.next = prev.next.next;
			if (prev.next == null) {
				tail = prev;
			}
		}
		size--;
		verify(true);
		return true;
	}

	// returns index int of specified value
	@Override
	public int indexOf(E value) {
		int index = -1;
		LinkedNode<E> node = head;
		for (int i = 0; i < size; i++) {
			// add code here to check if there is a match
			// if a match is found update index and break the loop
			if (node.item.compareTo(value) == 0) {
				index = i;
				break;
			}
			node = node.next;
		}
		return index;
	}

	// toString builder method
	public String toString() {
		String temp = "";
		LinkedNode<E> node = head;
		for (int i = 0; i < size; i++) {
			temp = temp + "" + node;
			if (i < size - 1) {
				temp += " ";
			}
			node = node.next;
		}
		temp.strip();
		return temp;
	}
}