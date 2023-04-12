package h10;

public class Recur {

    /**
     * A node in a singly-linked list
     * @author         Edo Biagioni
     * @lecture        ICS 211 Jan 27 or later
     * @date           January 26, 2010
     */

    private static class LinkedNode {
        private double item;
        private LinkedNode next;


        /**
         * constructor to build a node with no successor
         * @param the value to be stored by this node
         */
        private LinkedNode(double value) {
            item = value;
            next = null;
        }


        /**
         * constructor to build a node with specified (maybe null) successor
         * @param the value to be stored by this node
         * @param the next field for this node
         */
        private LinkedNode(double value, LinkedNode reference) {
            item = value;
            next = reference;
        }
    }
    // end of the LinkedNode definition

    // all these methods MUST be recursive.  There should be no loops
    // of any kind, no for, no while, no do/while, and no foreach loops.

    public LinkedNode randomLinkedList(double threshold) {
        if (Math.random() < threshold) return null;
        return new LinkedNode(Math.random(), randomLinkedList(threshold));
    }

    // how many nodes are in the list?
    public int length(LinkedNode node) {
    	if(node== null) {
    		return 0;
    		
    	}else {
    		return 1+length(node.next);
    	}
    }

    // how many nodes in the list have a value 0.5 or more?
    public int halves(LinkedNode node) {
        if(node== null) {
        	return 0;
        }else if (node.item>= 0.5) {
        	return 1 + halves(node.next);
        }else {
        	return 0+ halves(node.next);
        }
    }

    // return the last linkedNode in the list
    public LinkedNode last(LinkedNode node) {
        if (node == null) {
            throw new RuntimeException("no last node in an empty linked list");
        }
        // to do
        else if(node.next != null) {
        	last(node.next);
        }
        return node;
        
    }

    // add the given value after the last node in the list
    public void addAtEnd(LinkedNode node, double value) {
        if (node == null)
            throw new RuntimeException("cannot add at end of an empty linked list");
        // to do
        if(node.next ==null) {
        	node.next = new LinkedNode (value,null);
        }
        else {
        	addAtEnd(node.next,value);
        }
    }

    // if the list is empty, return null
    // otherwise add node.item at the end of the reversed node.next
    public LinkedNode reverse(LinkedNode node) {
        // to do
    	return null;
    }

    // at the end of the list, just print a newline
    // otherwise, print the node's item (without a newline),
    // followed by a ", " if this is not the last node in the list
    // then print the rest of the list
    public void printList(LinkedNode node) {
        // to do
    }

    // same as printList, but return the result as a string
    public String listToString(LinkedNode node) {
        // to do
    	return "";
    }

    // runtime exponential in n
    public static void exponential(int n) {
        // to do
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
            System.out.println("length of random list is " + newLength +
                               ", " + newHalves + " half or over");
            if (i == 0) {
            //    System.out.println("last of random list is " + r.last(list).item);
                System.out.print  ("list   : ");
                r.printList(list);
                System.out.println("again  : " + r.listToString(list));
                System.out.println("reverse: " + r.listToString(r.reverse(list)));
            }
        }
        System.out.println("average length of random list is " +
                           ((double) total) / ((double) count));
        System.out.println("average halves in random list is " +
                           ((double) totalHalves) / ((double) count));
        for (int i = 20; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            exponential(i);
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("exponential(" + i + ") takes time " + totalTime);
            if (totalTime > 2000) break;
        }
    }
}