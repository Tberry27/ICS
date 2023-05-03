package h02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AssignmentTest {String[] tokens1 = {"color", "=", "red", ";"};
String[] tokens2 = {"color", "=", "blue", ";"};
String[] tokens3 = {"color", "=", "red", ";"};
Assignment a1;
Assignment a2;
Assignment a3;

@BeforeEach
void setUp() throws Exception {
	a1 = new Assignment(tokens1);
	a2 = new Assignment(tokens2);
	a3 = new Assignment(tokens3);
}

@Test
void testAssignmentConstructor() {
	assertArrayEquals(tokens1, a1.tokens, "Assignment object should be constructed");
}

@Test
void testAssignmentToString() {
	assertEquals("color = red ;", a1.toString(), "String representation should " +
		" be \"color = red ;\"");
}

@Test
void testAssignmentEquals() {
	assertTrue(a1.equals(a3), "a1 should be equal to a3");
}

@Test
void testAssignmentEqualsSymmetric() {
	assertTrue(a3.equals(a1), "Since a1.equals(a3) is true, " +
		"a3.equals(a1) must be true also");
}

@Test
void testAssignmentNotEquals() {
	assertFalse(a1.equals(a2), "a1 should not be equal to a3");
}

@Test
void testAssignmentGetVariable() {
	assertEquals("color", a1.getVariable(), "a1.getVariable() should return \"color\"");
}

}
