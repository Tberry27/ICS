package h03;

import java.util.Random;

public class RandomProgrammer implements Programmer {

	Random random = new Random();

	// setting array of possible choices for the make choice method depending on
	// what parameter is required
	final static String[] variables = { "a", "b", "c", "d", "i", "j", "k", "m", "n", "x", "y", "count", "size" };
	final static String[] methodNames = { "print", "trim", "sort", "cut", "replace", "retrieve", "insert", "copy",
			"remove", "add", "reverse" };
	final static String[] mathOperators = { "+", "-", "*", "/", "%" };
	final static String[] relationalOperators = { "<", ">", "<=", ">=", "==", "!=" };

	// method to select at random one of the variables for needed parameter
	private String makeChoice(String[] choices) {
		int choice = random.nextInt(choices.length);
		return choices[choice];
	}

	// creates random int that determines if "makechoice" method gets called or
	// creates a random int to return
	private String getIntOrVariable() {
		int option = random.nextInt(2);
		if (option == 1) {
			return makeChoice(variables);
		} else {
			return "" + random.nextInt();
		}
	}

	// creates an expression at random to either make one parameter of an int or
	// var, or a 3 part math operation parameter input
	private String[] makeExpression() {
		String[] exp;
		int choice = random.nextInt(2);
		if (choice == 0) {
			exp = new String[1];
			exp[0] = getIntOrVariable();
		} else {
			exp = new String[3];
			exp[0] = getIntOrVariable();
			exp[1] = makeChoice(mathOperators);
			exp[2] = getIntOrVariable();
		}
		return exp;
	}

	// creates an array of strings used as args thats number of parameters is
	// created at random
	private String[] makeArguments() {
		int numParameters = random.nextInt(4);
		String[] args = null;
		if (numParameters == 0) {
			args = new String[] {};
		} else if (numParameters == 1) {
			String[] exp = makeExpression();
			args = new String[exp.length];
			for (int i = 0; i < exp.length; i++) {
				args[i] = exp[i];
			}
		} else if (numParameters == 2) {
			String[] exp1 = makeExpression();
			String[] exp2 = makeExpression();
			args = new String[exp1.length + exp2.length + 1];
			for (int i = 0; i < exp1.length; i++) {
				args[i] = exp1[i];
			}
			args[exp1.length] = ",";
			for (int i = 0; i < exp2.length; i++) {
				args[i + exp1.length + 1] = exp2[i];
			}
		} else if (numParameters == 3) {
			String[] exp1 = makeExpression();
			String[] exp2 = makeExpression();
			String[] exp3 = makeExpression();
			args = new String[exp1.length + exp2.length + exp3.length + 2];
			for (int i = 0; i < exp1.length; i++) {
				args[i] = exp1[i];
			}
			args[exp1.length] = ",";
			for (int i = 0; i < exp2.length; i++) {
				args[i + exp1.length + 1] = exp2[i];
			}
			args[exp1.length + exp2.length + 1] = ",";
			for (int i = 0; i < exp3.length; i++) {
				args[i + exp1.length + exp2.length + 2] = exp3[i];
			}
		}
		return args;
	}

	// creates a new instance of Assignment by utilizing makeChoice method of
	// "variables" variable and make expression as parameters

	public Assignment makeAssignment() {
		Assignment a1 = null;
		try {
			a1 = new Assignment(makeChoice(variables), makeExpression());
		} catch (InvalidStatementException e) {
			System.out.println("could not construct Assignment object");
			a1 = null;
		}
		return a1;
	}

// creates methodCall instance by utilizing make choice method of "methodNames" variable and make arguments as the parameter
	public MethodCall makeMethodCall() {
		MethodCall mc = null;
		try {
			mc = new MethodCall(makeChoice(methodNames), makeArguments());
		} catch (InvalidStatementException e) {
			System.out.println("could not construct MethodCall object");
			mc = null;
		}
		return mc;
	}

// creates conditional instance by utilizing testCond, then part, and else part as the parameters
	public Conditional makeConditional() {
		Conditional cond = null;
		try {
			String[] testCond = makeTestCondition();
			Statement[] thenPart = makeBody();
			Statement[] elsePart = makeBody();
			cond = new Conditional(testCond, thenPart, elsePart);
		} catch (InvalidStatementException e) {
			System.out.println("Could not construct Conditional object");
			cond = null;
		}
		return cond;
	}

//creates while loop instance by utilizing the "contitionparts" method and statements
	public WhileLoop makeWhileLoop() {
		WhileLoop wl = null;
		try {
			String[] conditionParts = makeTestCondition();
			Statement[] statements = makeBody();
			wl = new WhileLoop(conditionParts, statements);
		} catch (InvalidStatementException e) {
			System.out.println("Could not construct WhileLoop object");
			wl = null;
		}
		return wl;
	}

//creates a body for statement setting the array to either a string of make assignment method or make method call method
	private Statement[] makeBody() {
		int size = random.nextInt(10);
		Statement[] statements = new Statement[size];
		// limit Statements to Assignments and MethodCalls
		for (int i = 0; i < size; i++) {
			int option = random.nextInt(2);
			if (option == 0) {
				statements[i] = makeAssignment();
			} else {
				statements[i] = makeMethodCall();
			}
		}
		return statements;
	}

//makes test condition by combining an int or variable using the relational operator variable selected by make choice method
	private String[] makeTestCondition() {
		String[] conditionParts = new String[3];
		conditionParts[0] = getIntOrVariable();
		conditionParts[1] = makeChoice(relationalOperators);
		conditionParts[2] = getIntOrVariable();
		return conditionParts;
	}

//creates at random a statement and assignment it to one of the "make" methods
	public Statement makeStatement() {
		int choice = random.nextInt(4);
		Statement statement = null;
		if (choice == 0) {
			statement = makeAssignment();
		} else if (choice == 1) {
			statement = makeMethodCall();
		} else if (choice == 2) {
			statement = makeWhileLoop();
		} else if (choice == 3) {
			statement = makeConditional();
		}
		return statement;
	}

//main method that calls to each part of code for testing
	public static void main(String[] args) {
		Assignment a2 = null;
		RandomProgrammer rp = new RandomProgrammer();
		a2 = rp.makeAssignment();
		System.out.println(a2);
		MethodCall mc1 = rp.makeMethodCall();
		System.out.println(mc1);
		WhileLoop wl1 = rp.makeWhileLoop();
		System.out.println(wl1);
		Conditional cond1 = rp.makeConditional();
		System.out.println(cond1);
		RandomProgrammer rp2 = new RandomProgrammer();
		Statement statement = rp2.makeStatement();
		System.out.println(statement);
	}
}