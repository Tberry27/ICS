package h03;

public class TestConstructors {

	public static void main(String[] args) {
		Assignment a1 = null;
		MethodCall mc1 = null;
		WhileLoop wl1 = null;
		Conditional c1 = null;
		try {
			a1 = new Assignment("x", new String[] { "5" });
		} catch (InvalidStatementException e) {
		}
		System.out.println(a1);

		try {
			mc1 = new MethodCall("simplify", new String[] { "expression" });
		} catch (InvalidStatementException e) {
		}
		System.out.println(mc1);

		try {
			String[] condition = { "infile.hasNext()" };
			Statement s1 = new Assignment("line", new String[] { "infile.next()" });
			Statement s2 = new Assignment("count", new String[] { "count", "+", "1" });
			Statement[] statements = { s1, s2 };
			wl1 = new WhileLoop(condition, statements);
		} catch (InvalidStatementException e) {
		}
		System.out.println(wl1);

		try {
			String[] exp1 = { "x", "+", "5" };
			Statement s1 = new Assignment("x", exp1);
			Statement s2 = new MethodCall("sqrt", new String[] { "x" });
			String[] condition = { "x", "<", "9" };
			Statement s3 = new Assignment("x", new String[] { "x", "-", "3" });
			Statement s4 = new MethodCall("triple", new String[] { "x" });
			Statement[] thenPart = { s1, s2 };
			Statement[] elsePart = { s3, s4 };
			c1 = new Conditional(condition, thenPart, elsePart);
		} catch (InvalidStatementException e) {
		}
		System.out.println(c1);
	}

}