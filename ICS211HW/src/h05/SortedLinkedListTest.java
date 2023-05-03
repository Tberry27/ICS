/*
 * author: Tanner Berry
 * ICS 211 HW5
 */
package h05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedLinkedListTest {
	SortedLinkedList<Integer> intList = null;
	SortedLinkedList<Double> doubleList = null;
	SortedLinkedList<String> stringList = null;

	@BeforeEach
	void setUp() throws Exception {
		intList = new SortedLinkedList<Integer>();
		doubleList = new SortedLinkedList<Double>();
		stringList = new SortedLinkedList<String>();
	}

	@Test
	void testSize() {
		intList.add(1);
		assertEquals(1, intList.size(), "size of int list should be 1");

	}

	@Test
	void testGet() {
		doubleList.add(2.1);
		doubleList.add(1.7);
		doubleList.add(3.1);
		doubleList.add(1.1);
		assertEquals(1.1, doubleList.get(0), "index of 0 should be 1.1");
		assertEquals(1.7, doubleList.get(1), "index of 1 should be 1.7");
		assertEquals(2.1, doubleList.get(2), "index of 2 should be 2.1");
		assertEquals(3.1, doubleList.get(3), "index of 3 should be 3.1");
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> doubleList.get(-1));
		assertEquals("Invalid index to get node from", exception.getMessage());
	}

	@Test
	void removeTest() {
		intList.add(2);
		intList.add(1);
		intList.add(3);
		intList.add(4);
		intList.remove(3);
		assertEquals(4, intList.get(2), "Index of 3 should now be 4 after removal");
		assertFalse(intList.remove(5), "falure to remove value not in list");
		intList.remove(1);
		assertEquals(2, intList.get(0), "removal of index 0");
		intList.add(1);
		intList.add(3);
		intList.remove(4);
		assertEquals(3, intList.get(2), "removal of tail index");
	}

	@Test
	void addTest() {
		doubleList.add(2.1);
		doubleList.add(1.7);
		doubleList.add(3.1);
		assertFalse(doubleList.add(3.1), "should not be able to add value already in list");

	}

	@Test
	void toStringTest() {
		stringList.add("alpha");
		stringList.add("beta");
		stringList.add("gamma");
		assertEquals("alpha beta gamma", stringList.toString());
	}

}