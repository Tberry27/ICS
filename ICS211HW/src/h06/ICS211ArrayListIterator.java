package h06;

import java.util.Iterator;

public class ICS211ArrayListIterator<E> implements Iterator<E> {

	private E[] data; // store data from ArrayList in this array
	private int nextIndex = 0; // used to keep track of the next index in the array

	/*
	 * This constructor constructs the array, data, so that its length is equal to
	 * the number of elements in the underlying ArrayList. So, the end of the data
	 * array would have an index of data.length - 1
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ICS211ArrayListIterator(java.util.ArrayList data) {
		this.data = (E[]) data.toArray();
	}

	/*
	 * This method will return true if the current index is less than or equal to
	 * data.length - 1 Otherwise, it will return false
	 */
	@Override
	public boolean hasNext() {
		if (nextIndex <= data.length - 1) {
			return true;
		}
		return false;
	}

	/*
	 * This method will return the element located at data[nextIndex] This method
	 * will use hasNext(). If hasNext() returns false this method will throw a
	 * java.util.NoSuchElementException
	 */
	@Override
	public E next() {
		if (hasNext()) {
			E obj = data[nextIndex];
			nextIndex++;
			return obj;
		}
		throw new java.util.NoSuchElementException();
	}

}