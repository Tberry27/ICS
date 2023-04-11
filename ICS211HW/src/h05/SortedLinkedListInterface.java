/*
 * author: Tanner Berry
 * ICS 211 HW5
 */
package h05;

public interface SortedLinkedListInterface<E extends Comparable<E>> {

	/**
	 * This method returns the number of elements stored in the list.
	 * @return the int that shows the number of elements stored in the list.
	 */
	int size();

	/**
	 * This method will return the element at the specified index unless a value 
	 * of 0 or less than -1 is given
	 *
	 * 
	 * @param index that specifies the index of the element to be returned
	 * @return the element at the specified index
	 */
	E get(int index);

	/**
	 * This method adds a node with the specified value as long as the value is not 
	 * already present in the list
	 * 
	 * @param value the value to use to create the link to be added
	 * @return true if the link is added with the specified value, false otherwise
	 */
	
	/*
	 * AVG O() is O(n), this is due to the average case of the link list not starting 
	 * at size 0 and being inside the link list causing the method to perform the 
	 * while loop to loop for the correct location to insert the value. This single loop 
	 * will be some constant times n leaving it to be on average linear time.
	 * 
	 * BEST O() is O(1), this is in the case of the linked list being size 0,
	 * in which case the helper method addToFront will be executed and no loop is 
	 * performed, this single operation creates a constant time.
	 * 
	 * Worst O() O(n), this is in the case that the added value is placed at the 
	 * end of the link list (from starting at the head) in which case the entire 
	 * list would be looked through, still resulting in a linear time.
	 * 
	 */
	boolean add(E value);

	/**
	 * This method removes the node with the specified value unless the value is not 
	 * present in the list
	 * 
	 * @param value the value to search for in the list for link removal
	 * @return true if a link with the specified value is found and removed, false
	 *         otherwise
	 */
	
	/*
	 * AVG O() is O(n), this is due to the average case of the node to be removed
	 *   being inside the link list causing the method to perform the 
	 * for loop inside the indexOf method to loop to find the correct location 
	 * of the node to be removed. This single loop will be constant times n 
	 * leaving it to be on average linear time and since the operation after indexOf
	 * is less than n the time complexity is linear.
	 * 
	 * BEST O() is O(1), this is in the case of the specified value in the linked 
	 * list being index 0, in which case the helper method indexOf will be executed
	 * once and not loop  this single operation creates a constant time.
	 * 
	 * Worst O() O(n), this is in the case that the removed value is at the 
	 * end of the link list  or not in the list at all, in which case the entire 
	 * list would be looked through, still resulting in a linear time.
	 * 
	 */
	boolean remove(E value);

	/**
	 * This method will return the int of the index of the specified value unless the 
	 * specified value is not present in the list this method
	 * 
	 * @param value the value to compare the value of the list links to.
	 * @return an int representing the index of the link that holds the specified
	 *  value, or -1 if such a link is not found.
	 */
	int indexOf(E value);

	/**
	 * This method will return the values of the links in the list in order with a
	 * single space in between each value.
	 * 
	 * @return the String consisting of all the values in the list separated by a
	 * single space.
	 */
	String toString();
}