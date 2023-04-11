package h07;

import java.util.concurrent.ThreadLocalRandom;

public class Palindrome {

	public static void main(String[] args) {
		int choice = ThreadLocalRandom.current().nextInt(1, 4);
		StackInterface<Character> stack = null;

		// creating 3 choices for random int to select
		if (choice == 1) {
			stack = new ArrayStack<Character>();
			System.out.println("Type is Array Stack.");
		} else if (choice == 2) {
			stack = new LinkedStack<Character>();
			System.out.println("Type is Linked Stack.");
		} else if (choice == 3) {
			stack = new JavaStandardLibraryStack<Character>();
			System.out.println("Type is Java Standard Library Stack.");

		}
		if (args.length == 0) {
			runTests(stack);
		}
		// prints arg sent then the verifying boolean from isPalindrome
		// catches fullstack exceptions
		else {
			for (String arg : args) {
				try {
					System.out.println("Is \"" + arg + "\" a palindrome? " + isPalindrome(stack, arg));
				} catch (FullStackException e) {
					System.out
							.println("The String " + arg + " overflows the ArrayStack which has a max of 6 characters");
				} finally { // to clear out stack in case String is not a palindrome
					while (!stack.empty()) {
						stack.pop();
					}
				}
			}
		}
	}

	// method to verify if stack from parameter inputed meets requirements of a
	// palindrome then returns boolean value for result
	private static boolean isPalindrome(StackInterface<Character> stack, String testStr) {
		for (int i = 0; i < testStr.length(); i++) {
			char ch = testStr.charAt(i);
			if (Character.isLetter(ch)) {
				stack.push(ch);
			}
		}
		for (int i = 0; i < testStr.length(); i++) {
			char ch = testStr.charAt(i);
			if (Character.isLetter(ch)) {
				if (Character.toUpperCase(ch) != Character.toUpperCase(stack.pop())) {
					return false;
				}
			}
		}
		return true;
	}

	private static void runTests(StackInterface<Character> stack) {
		String[] testStrings = { "radar", "racecar", "Was it a car or a cat I saw?", "radars", "cat", "palindrome" };
		for (String test : testStrings) {
			try {
				System.out.println("Is \"" + test + "\" a palindrome? " + isPalindrome(stack, test));
			} catch (FullStackException e) {
				System.out.println(
						"The String \"" + test + "\" overflows the ArrayStack which has a max of 6 characters");
			} finally { // clear stack when String is not a palindrome
				while (!stack.empty()) {
					stack.pop();
				}
			}
		}
	}

}