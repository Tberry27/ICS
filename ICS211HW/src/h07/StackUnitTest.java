/*package h07;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackUnitTest {

	// creating arrays to be used to insert data to be stacked
	final static String[] strData = { "Alice", "Bob", "Dave", "Jack", "Evelyn", "Carol" };
	final static String[] strData2 = { "red", "blue", "green", "yellow", "orange", "cyan", "black" };
	final static Integer[] intData = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	ArrayStack<String> stack1;
	ArrayStack<String> stack2;
	LinkedStack<Integer> stack3;

	@BeforeEach
	void setUp() throws Exception {
	}

	// testing a valid stack is produced my arrayStack class by sending to unitTest
	@Test
	void testArrayStack1() {
		stack1 = new ArrayStack<String>();
		boolean passedTest = unitTest(stack1, strData);
		assertTrue(passedTest, "Should have passed all tests in unitTest()");
	}

	// testing a non valid stack is produced my arrayStack class by sending too many
	// values to the stack then testing with unitTest
	@Test
	void testArrayStack2() {
		stack2 = new ArrayStack<String>();
		boolean passedTest = unitTest(stack2, strData2);
		assertFalse(passedTest, "Should not passed unitTest() as stack overflow should occur");
	}

	// testing a empty stack in arrayStack cannot pop or peek
	@Test
	void testArrayEmpty() {
		stack2 = new ArrayStack<String>();
		try {
			stack2.pop();
			fail("Should not be able to pop empty stack");
		} catch (EmptyStackException e) {

		}
		try {
			stack2.peek();
			fail("Should not be able to pop empty stack");
		} catch (EmptyStackException e) {
		}
	}

	// testing a valid stack is produced my LinkedStack class by sending to unitTest
	@Test
	void testLinkedStack3() {
		stack3 = new LinkedStack<Integer>();
		boolean passedTest = unitTest(stack3, intData);
		assertTrue(passedTest, "Should have passed all tests in unitTest()");
	}

	// testing Linked stack can return null value from empty stack
	@Test
	void testLinkedStackdefault() {
		stack3 = new LinkedStack<Integer>();
		assertEquals(stack3.toString(), "Empty Stack");
	}

	// testing stack is not empty / does not have a full stack exception / can push,
	// pop, and peek correctly
	// @SuppressWarnings("hiding")
	public <E> boolean unitTest(StackInterface<E> stack, E[] data) {
		E testitem = null;
		if (!stack.empty()) {
			return false;
		}
		try {
			for (E item : data) {
				stack.push(item);
				testitem = item;
			}
		} catch (FullStackException e) {
			return false;
		}
		if (stack.peek() != testitem) {
			return false;
		}
		if (stack.toString() == "Empty Stack") {
			return false;
		}
		for (int i = data.length - 1; i >= 0; i--) {
			E item = stack.pop();
			if (item == null || !item.equals(data[i])) {
				return false;
			}
		}
		if (!stack.empty()) {
			return false;
		}
		return true;
	}
}*/