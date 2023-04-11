package h04;

public interface SortedArrayListInterface {
	// List methods that are useful for a sorted array list
		int size();

		String get(int index);

		// return true if the value has been added, false if it was already present
		boolean add(String value);

		// return true if the value has been removed, false if it was not present
		boolean remove(String value);

		// return the index at which the string can be found, or -1 if not found
		int indexOf(String value);

		// return the contents with blanks (" ") in-between
		String toString();
	}