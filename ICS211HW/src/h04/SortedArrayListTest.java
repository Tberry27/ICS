/*package h04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedArrayListTest{
SortedArrayList myList = null;
	
	@BeforeEach
	void setup() throws Exception{
		myList = new SortedArrayList();
	}
	@Test
	void testInitialSizeZero() {
		assertEquals(0,myList.size(),"Size of empty list.");
	}
	@Test
	void testSizeCorrect() {
		myList.add("tanner");
		myList.add("Berry");
		assertEquals(2,myList.size(),"size of myList should be");
	}
	@Test
	void testGetCorrect() {
		myList.add("Michael");
		myList.add("Steph");
		myList.add("Mike");
		assertEquals("Michael",myList.get(1),"String that should be at index 1");
	}
	@Test
	void testAddCorrect() {
		myList.add("amy");
		myList.add("becky");
		myList.add("carole");
		assertEquals("amy becky carole", myList.toString(), "mylist.toString Should apprear {amy becky carole}");
	}
	@Test
	void testAddReturnsTrue() {
		myList.add("jane");
		assertTrue(myList.add("jane"),"Shouldbe able to add diff string");
	}
	@Test
	void testAddReturnsFalse() {
		myList.add("jane");
		assertFalse(myList.add("JaNe"),"Should'nt be able to add same string with different caps");
	}
	
	@Test
	void testRemoveCorrect() {
		myList.add("amy");
		myList.add("becky");
		myList.remove("amy");
		assertEquals("becky", myList.toString(), "mylist.toString Should apprear as only becky now");
	}
	@Test
	void testRemoveReturnsTrue() {
		myList.add("jane");
		myList.add("becky");
		assertTrue(myList.remove("jane"),"Should return true because jane is on the list");
	}
	@Test
	void testRemoveReturnsFalse() {
		myList.add("jane");
		assertFalse(myList.remove("jacob"),"Should'nt be able to remove name not on the list");
	}
	@Test
	void testIndexOfFound() {
		myList.add("amy");
		myList.add("becky");
		assertEquals(0,myList.indexOf("amy"),"Should be true that amy is index 0");
	}
}
	

*/