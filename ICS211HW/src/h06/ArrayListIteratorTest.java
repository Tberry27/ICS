package h06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListIteratorTest {

	ICS211ArrayListIterator<String> sArrayIterator;
	ICS211ArrayListIterator<Integer> iArrayIterator;
	final static Integer[] integerArray = { 15, 17, 5, 16, 28 };
	final static String[] stringArray = { "Alice", "Bob", "carol", "Janice", "Eddie" };

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testStringList() {
		java.util.ArrayList<String> sList = new java.util.ArrayList<String>();
		for (int i = 0; i < stringArray.length; i++) {
			sList.add(stringArray[i]);
		}
		sArrayIterator = new ICS211ArrayListIterator<String>(sList);
		int i = 0;
		while (sArrayIterator.hasNext()) {
			assert (sArrayIterator.next().equals(stringArray[i]));
			i++;
		}
	}

	@Test
	void testArrayList() {
		java.util.ArrayList<Integer> iList = new java.util.ArrayList<Integer>();
		for (int i = 0; i < integerArray.length; i++) {
			iList.add(integerArray[i]);
		}
		iArrayIterator = new ICS211ArrayListIterator<Integer>(iList);
		int i = 0;
		while (iArrayIterator.hasNext()) {
			assert (iArrayIterator.next().equals(integerArray[i]));
			i++;
		}
	}
}