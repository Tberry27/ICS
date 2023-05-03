package h06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ICS211LinkedListTest {

	ICS211LinkedList<String> myList;
	final static String[] strArray = { "Jane", "Bob", "Alice", "Frank" };

	@BeforeEach
	void setUp() throws Exception {
		myList = new ICS211LinkedList<String>();
		for (int i = 0; i < strArray.length; i++) {
			myList.add(strArray[i]);
		}
	}

	@Test
	void testICS211LinkedListForEach() {
		String temp = "";
		int count = 0;
		for (Object name : myList) {
			temp += name;
			if (count < myList.size - 1) {
				temp += " ==> ";
			}
			count++;
		}
		assertEquals(temp, myList.toString(), "generated String should be \"Jane ==> Bob ==> Alice ==> Frank\"");
	}

	@Test
	void testICS211LinkedListCheckCorrectValues() {
		Iterator<String> myIterator = myList.iterator();
		for (int i = 0; i < myList.size; i++) {
			assert (myIterator.next().equals(strArray[i]));
			System.out.println("Correct value passed for " + strArray[i]);
		}
	}

	@Test
	void testICS211LinkedListRemoveHead() {
		myList.remove(0);
		assertEquals("Bob ==> Alice ==> Frank", myList.toString(),
				"toString() should return \"Bob ==> Alice ==> Frank\"");
	}

	@Test
	void testICS211LinkedListRemoveTail() {
		myList.remove(myList.size - 1);
		assertEquals("Jane ==> Bob ==> Alice", myList.toString(),
				"toString() should return \"Jane ==> Bob ==> Alice\"");
	}

	@Test
	void testICS211LinkedListRemoveInBetween() {
		myList.remove(1);
		assertEquals("Jane ==> Alice ==> Frank", myList.toString(),
				"toString() should return \"Jane ==> Alice ==> Frank\"");
	}

	@Test
	void testICS211LinkedListRemoveIndexNegativeOne() {
		try {
			myList.remove(-1);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
		}

	}

	@Test
	void testICS211LinkedListRemoveIndexEqualsSize() {
		try {
			myList.remove(myList.size);
			fail("Should have thrown IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
		}

	}

	@Test
	void testLinkedListIteratorRemoveHead() {
		Iterator<String> myIterator = myList.iterator();
		myIterator.next();
		myIterator.remove();
		assertEquals("Bob ==> Alice ==> Frank", myList.toString(),
				"toString() should return \"Bob ==> Alice ==> Frank\"");
	}

	@Test
	void testLinkedListIteratorRemoveTail() {
		Iterator<String> myIterator = myList.iterator();
		while (myIterator.hasNext()) {
			myIterator.next();

		}
		myIterator.remove();
		assertEquals("Jane ==> Bob ==> Alice", myList.toString(),
				"toString() should return \"Jane ==> Bob ==> Alice\"");
	}

	@Test
	void testLinkedListIteratorRemoveInBetween() {
		Iterator<String> myIterator = myList.iterator();
		for (int i = 0; i < myList.size / 2; i++) {
			myIterator.next();
		}
		myIterator.remove();
		assertEquals("Jane ==> Alice ==> Frank", myList.toString(),
				"toString() should return \"Jane ==> Alice ==> Frank\"");
	}

	@Test
	void testLinkedListIteratorRemoveBeforeFirstNext() {
		Iterator<String> myIterator = myList.iterator();
		try {
			myIterator.remove();
			fail("Should not be able to remove before first next");
		} catch (IllegalStateException e) {
		}
	}

	@Test
	void testLinkedListIteratorRemoveRemoveAfterLastNext() {
		Iterator<String> myIterator = myList.iterator();
		while (myIterator.hasNext()) {
			myIterator.next();

		}
		try {
			myIterator.next();
			fail("Should not be able to exicute have next after tail");
		} catch (NoSuchElementException e) {
		}
	}

}