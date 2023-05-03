package h10;

public class Recur {

	// @author Tanner Berry

	private static class LinkedNode {
		private double item;
		private LinkedNode next;

		/**
		 * constructor to build a node with no successor
		 * 
		 * @param the value to be stored by this node
		 */
		private LinkedNode(double value) {
			item = value;
			next = null;
		}

		/**
		 * constructor to build a node with specified (maybe null) successor
		 * 
		 * @param the value to be stored by this node
		 * @param the next field for this node
		 */
		private LinkedNode(double value, LinkedNode reference) {
			item = value;
			next = reference;
		}
	}

	public LinkedNode randomLinkedList(double threshold) {
		if (Math.random() < threshold)
			return null;
		return new LinkedNode(Math.random(), randomLinkedList(threshold));
	}

	public int length(LinkedNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + length(node.next);
		}
	}

	public int halves(LinkedNode node) {
		if (node == null) {
			return 0;
		} else if (node.item >= 0.5) {
			return 1 + halves(node.next);
		} else {
			return 0 + halves(node.next);
		}
	}

	public LinkedNode last(LinkedNode node) {
		if (node == null) {
			throw new RuntimeException("no last node in an empty linked list");
		}
		if (node.next != null) {
			return last(node.next);
		}
		return node;
	}

	public void addAtEnd(LinkedNode node, double value) {
		if (node == null)
			throw new RuntimeException("cannot add at end of an empty linked list");
		if (node.next == null) {
			node.next = new LinkedNode(value, null);
		} else {
			addAtEnd(node.next, value);
		}
	}

	public LinkedNode reverse(LinkedNode node) {
		if (node == null) {
			return null;
		} else if (node.next == null) {
			return node;
		}
		LinkedNode reversed = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return reversed;
	}

	public void printList(LinkedNode node) {
		if (node == null) {
			System.out.print("");
		} else if (node.next == null) {
			System.out.print(node.item);
		} else {
			System.out.print(node.item + ", ");
			printList(node.next);
		}
	}

	public String listToString(LinkedNode node) {
		String results = "";
		if (node == null) {
			return ("");
		} else if (node.next == null) {
			results = String.valueOf(node.item);
			return results + "\n";
		} else {
			results = String.valueOf(node.item + ", ");
			return results + String.valueOf(listToString(node.next));
		}
	}

	// runtime exponential in n
	public static int exponential(int n) {
		if (n <= 2) {
			return 1;
		}
		return exponential(n - 2) + exponential(n - 1);
	}

	public static void main(String[] a) {
		Recur r = new Recur();
		double threshold = 0.2;
		if ((a != null) && (a.length > 0))
			threshold = Double.parseDouble(a[0]);
		int total = 0;
		int totalHalves = 0;
		int count = 10;
		for (int i = 0; i < count; i++) {
			LinkedNode list = r.randomLinkedList(threshold);
			int newLength = r.length(list);
			int newHalves = r.halves(list);
			total += newLength;
			totalHalves += newHalves;
			System.out.println("length of random list is " + newLength + ", " + newHalves + " half or over");
			if (i == 0) {
				System.out.println("last of random list is " + r.last(list).item);
				System.out.print("list   : ");
				r.printList(list);
				System.out.println();
				System.out.print("again  : ");
				System.out.print(r.listToString(list));
				System.out.print("reverse: " + r.listToString(r.reverse(list)));
			}
		}
		System.out.println("average length of random list is " + ((double) total) / ((double) count));
		System.out.println("average halves in random list is " + ((double) totalHalves) / ((double) count));
		for (int i = 20; i < 100; i++) {
			long startTime = System.currentTimeMillis();
			exponential(i);
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("exponential(" + i + ") takes time " + totalTime);
			if (totalTime > 2000)
				break;
		}
	}
}