package h06;

import java.util.Iterator;

/**
 * @author Tanner Berry
 */

public class ICS211LinkedList<E> implements Iterable<E> {

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

		/**
		 * constructor to build a node with specified (maybe null) successor
		 *
		 * @param the value to be stored by this node
		 * @param the next field for this node
		 */
		private LinkedNode(T value, LinkedNode<T> reference) {
			item = value;
			next = reference;
		}
	}

	// this is the start of the linked list. If the list is empty, it is null
	protected LinkedNode<E> head;
	// this is the end of the linked list. If the list is empty, it is null
	protected LinkedNode<E> tail;
	// this is to keep a running count on amount of nodes
	protected int size;
	// this is the placekeeper for the previous node positon
	protected LinkedNode<E> prev;

	private void verify(boolean mustBeTrue) {
		if (!mustBeTrue) {
			throw new java.lang.AssertionError("assertion error");
		}
	}

	/**
	 * checks class invariants
	 *
	 * @throws java.lang.AssertionError if the invariant is violated
	 */
	private void checkInvariants() {
		// either head and tail are both null, or neither is null.
		// size is zero if and only if they are null, and otherwise is positive
		verify((head == null) == (tail == null));
		verify((size == 0) == (head == null));
		verify(size >= 0);
		// if the list only has one element, head should be the same as tail
		// (and also if the list has no elements), otherwise they should differ
		verify((head == tail) == (size <= 1));
		// a non-null tail variable should always have a null "next" field
		verify((tail == null) || (tail.next == null));
		// check to make sure size is the same as the length of the list.
		// this code takes O(n), so comment it out if performance is important
		int measuredSize = 0;
		LinkedNode<E> node = head;
		// if visitedLast is null, the list is empty, and tail should also be null
		LinkedNode<E> visitedLast = null;
		while (node != null) {
			visitedLast = node;
			node = node.next;
			measuredSize++;
		}
		verify(measuredSize == size);
		// also make sure "last" really is the last node in the linked list
		verify(visitedLast == tail);
	}

	/**
	 * initializes an empty linked list
	 */
	public ICS211LinkedList() {
		head = null;
		tail = null;
		prev = null;
		size = 0;
		// one of the constructor's jobs is to make sure that the invariants hold.
		checkInvariants();
	}

	/**
	 * adds at the head of the list
	 *
	 * @param the value to be added
	 */
	private void addAtFront(E value) {
		head = new LinkedNode<E>(value, head);
		if (tail == null) {
			tail = head;
		}
	}

	/**
	 * adds at the tail of the list. Assumes (and checks) that tail is not null
	 *
	 * @param the value to be added
	 * @throws RuntimeException
	 */
	private void addAtEnd(E value) {
		if (tail == null) {
			throw new RuntimeException("invalid call to addAtEnd, tail is null");
		}
		// creates new node then assigns it to the tail nodes next position then makes
		// new node the new tail at end of the list
		LinkedNode<E> newNode = new LinkedNode<E>(value);
		tail.next = newNode;
		tail = newNode;
	}

	/**
	 * adds a value to the list after the given node
	 *
	 * @param the node after which the new value is added
	 * @param the value to be added
	 */
	private void addAfter(LinkedNode<E> reference, E value) {
		LinkedNode<E> newNode = new LinkedNode<E>(value, reference.next);
		// sets new node to the positon after the reference
		reference.next = newNode;
		// if adding after the tail reassigns tail to the new node
		if (reference == tail) {
			tail = newNode;
		}
	}

	/**
	 * adds a value to the end of the list
	 *
	 * @param the value to be added
	 * @return true (the add always succeeds)
	 */
	public boolean add(E value) {
		checkInvariants(); // useful for debugging
		if (head != null) {
			addAtEnd(value);
		} else {
			addAtFront(value);
		}
		size++;
		checkInvariants(); // invariants valid at start, are they still valid?
		// i.e., did this method break the invariants?
		return true;
	}

	/**
	 * returns the node at the requested position, may take time O(n)
	 *
	 * @param the position of the requested node, 0 for the head node
	 * @return the requested node
	 * @throws NullPointerException if the index is larger than the linked list
	 */
	private LinkedNode<E> nodeAtPosition(int index) {
		verify(index >= 0);
		LinkedNode<E> result = head;
		while (index > 0) {
			result = result.next;
			index--;
		}
		verify(result != null);
		return result;
	}

	/**
	 * adds a value to the list, in the given position
	 *
	 * @param the position at which to add: 0 to add at the start
	 * @param the value to be added
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than
	 *                                   the number of elements in the linked list
	 */
	public void add(int index, E value) {
		checkInvariants();
		if ((index < 0) || (index > size)) {
			String badIndex = new String("index " + index + " must be between 0 and " + size);
			throw new IndexOutOfBoundsException(badIndex);
		}
		if (index == 0) {
			addAtFront(value);
		} else {
			addAfter(nodeAtPosition(index - 1), value);
		}
		size++;
		checkInvariants();
	}

	// jump method and remove for ICS211LinkedList Class
	private LinkedNode<E> jump(int numJumps) {
		if (numJumps < 0) {
			return null;
		}
		LinkedNode<E> node = head;
		// for loop to loop through list until number of nodes in list to jump is met
		// and returns that node
		for (int i = 0; i < numJumps; i++) {
			node = node.next;
		}
		return node;
	}

	public E remove(int index) {
		checkInvariants();
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E removeValue = null;
		// if only one node after removal head and tail are both null
		if (size == 1) {
			removeValue = head.item;
			head = null;
			tail = null;
			// removing head node then assigning the next node after one removed as new head
		} else if (index == 0) {
			removeValue = head.item;
			head = head.next;
			// removing tail node, then setting the previous node of current tail to new
			// tail
		} else if (index == size - 1) {
			removeValue = tail.item;
			prev = jump(index - 1);
			prev.next = null;
			tail = prev;
			// general case where setting the removed nodes previous nodes "next" to the
			// node after one
			// to be removes essentially skipping removed node
		} else {
			prev = jump(index - 1);
			removeValue = prev.next.item;
			prev.next = prev.next.next;
		}
		// adjust size, check invariants and return removed value
		size--;
		checkInvariants();
		return removeValue;
	}

	/**
	 * concatenates the elements of the linked list, separated by " ==> "
	 *
	 * @return the string representation of the list
	 */
	public String toString() {
		checkInvariants();
		LinkedNode<E> node = head;
		StringBuffer result = new StringBuffer();
		while (node != null) {
			result.append(node.item.toString());
			node = node.next;
			if (node != null) {
				result.append(" ==> ");
			}
		}
		checkInvariants(); // make sure we didn't break anything
		return result.toString();
	}

	/**
	 * unit test method -- basic testing of the functionality
	 *
	 * @param required, ignored
	 */
	public static void main(String[] arguments) {
		ICS211LinkedList<String> ll = new ICS211LinkedList<String>();
		System.out.println(ll);
		ll.add("foo");
		System.out.println(ll);
		ll.add(1, "bar");
		System.out.println(ll);
		ll.add("baz");
		System.out.println(ll);
		ll.add(0, "hello");
		System.out.println(ll);
		ll.add(1, "world");
		System.out.println(ll);

	}

	@Override
	public Iterator<E> iterator() {
		checkInvariants();
		return new LinkedListIterator();
	}

	/**
	 * A linked list iterator that does not support remove
	 *
	 * @author Edo Biagioni
	 * @lecture ICS 211 Feb 3 (or later)
	 * @date February 1, 2011
	 */

	private class LinkedListIterator implements java.util.Iterator<E> {
		private LinkedNode<E> current;
		private LinkedNode<E> previous;// need this to keep track of the previous link so that you can remove in O(1)
										// time

		private LinkedListIterator() {
			current = head; // head is declared in the enclosing class
			previous = null; // initializes previous to null

		}

		public boolean hasNext() {
			return (current != null);
		}

		public E next() {
			if (hasNext()) {
				E result = current.item;
				if (current == head) {
					previous = null;
				} else if (current == head.next) {
					previous = head;
				} else {
					previous = previous.next;
				}
				current = current.next; // may be null
				return result;
			} // else: no next element
			throw new java.util.NoSuchElementException("linked list.next");
		}

		public void remove() {
			// dont remove since previous is a null
			if (current == head) {
				throw new IllegalStateException();
			}
			// removing the head
			else if (current == head.next) {
				head = current;
				size--;
			}
			// removing tail
			else if (current == null) {
				tail = previous;
				tail.next = null;
				size--;
			}
			// removed node is inside head and tail
			else {
				previous.next = current;
				size--;
			}
			// removing if only one node
			if (size == 0) {
				head = null;
				tail = null;
			}
		}

	}

}
