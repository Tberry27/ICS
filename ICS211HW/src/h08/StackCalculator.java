package h08;

public class StackCalculator {

	private StackInterface<Double> stack;

	public StackCalculator(StackInterface<Double> stack) {
		this.stack = stack;
	}
	//pushes double value onto the stack
	public void push(Double value) {
		stack.push(value);
	}
	//returns top of stack
	public Double peek() {
		return stack.peek();
	}
	//determines if valid and what to execute for operators 
	public boolean enterOperator(String op) {
		if (stack.size() > 1) {
			Double op2 = stack.pop();
			Double op1 = stack.pop();
			if (op.equals("+")) {
				stack.push(op1 + op2);
			}
			else if (op.equals("-")) {
				stack.push(op1- op2);
			}else if (op.equals("*")) {
				stack.push((op1 * op2));
			}
			else if (op.equals("/")) {
				stack.push(op1 / op2);
			}
			else if (op.equals("%")) {
				stack.push((op1/op2)*100);
			}
			else if(op.equals("^")) {
				stack.push(Math.pow(op1, op2));
			}
			else {
				System.out.println("Not a valid operator");
			}
			return true;
		}
		else {
			return false;
		}
	}

	public String toString() {
		return stack.toString();
	}

	public static void main(String[] args) {
		java.util.Scanner key = new java.util.Scanner(System.in);
		StackCalculator calc = new StackCalculator(new ArrayStack<Double>());
		boolean done = false;
		while (!done) {
			System.out.print("Type in a number, or an operator, or \"=\" to end program: ");
			String entry = key.nextLine().trim();
			if (entry.equals("=")) {
				System.out.println("Program ended");
				done = true;
			}
			else if (isNumeric(entry)) {
				try {
					calc.push(Double.parseDouble(entry));
				}
				catch (FullStackException e) {
					System.out.println("Stack is full cannot enter another number");
				}
			}
			else if (entry.equals("+") || entry.equals("-") ||
				entry.equals("*") || entry.equals("/") || entry.equals("%")|| entry.equals("^")) {
				if (calc.enterOperator(entry)) {
					System.out.println("result is " + calc.peek());
				}
				else {
					System.out.println("Not enough numbers on the stack");
				}
			}
		}
		key.close();
	}
	public static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}
}