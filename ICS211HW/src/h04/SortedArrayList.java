package h04;

import java.util.Arrays;

/**
 * This class is used to store Strings in alphabetic order. When a new String is
 * added, it starts at the end of the list and is moved left until the list is
 * back in alphabetic order. The same String cannot be added more than once. So,
 * all items in the list are unique. Items can be removed from the list by
 * specifying the value of the String to be removed. When String values are
 * compared, the case of the Strings are ignored.
 * 
 * @author Tanner Berry
 *
 */
public class SortedArrayList implements SortedArrayListInterface {

	private String[] data;
	private int count;

	/**
	 * This constructor sets the initial capacity of the list to be 1
	 */
	public SortedArrayList() {
		data = new String[1];
		count = 0;
	}

	@Override
	public int size() {
		return count;
	}

	public String get(int index) {
		if(index <= count) {
			return data[index];
		}
		return null;
	}

	private void grow() {
		data = Arrays.copyOf(data, data.length + 3);

		// set data to copy of itself with 3 extra spaces
		// Use Arrays.copyOf() for this
	}

	@Override
	public boolean add(String value) {
		if (indexOf(value) == -1) {

			if (count == data.length) {
				grow();
			}
			data[count] = value;
			int position = count;
			while (position > 0 && data[position - 1].compareToIgnoreCase(data[position]) > 0) {
				String temp = data[position];
				data[position] = data[position - 1];
				data[position - 1] = temp;
				position--;

			}
			count++;
		}
		return true;
	}

	@Override
	public boolean remove(String value) {
	//	int position =0;
		for (int i = 0; i < count; i++) {
			if (data[i].equalsIgnoreCase(value)) { 
				 
			int position = i;
		
				//while (position < count -1 && data[position - 1].compareToIgnoreCase(data[position]) > 0) {
					for (int j = position; j >= count; j++ ) {
				//	String temp = data[position];
					data[position] = data[position +1 ];
					
					position++;
				
			}
			count --;		
			}
		}
		return false;
	}

	@Override
	public int indexOf(String value) {
		int index = -1;
		for (int i = 0; i < count; i++) {
			if (data[i].equalsIgnoreCase(value)) { // possibly sway data and value
				index = i;
				break;
			}
		}

		// .equalsIgnoreCase
		// implement a for loop to iterate through all Strings in the list
		// if there is a match, store the index and break the for loop
		return index;
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < count; i++) {
			temp += data[i];
			if (i < count - 1) {
				temp += " ";
			}
		}

		// Use a for loop to iterate over all Strings in the list
		// If the String is not the last item in the list, add a space
		return temp;
	}

}