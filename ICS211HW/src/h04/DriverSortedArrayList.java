package h04;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

public class DriverSortedArrayList {
	public static void main(String[] args) {

		SortedArrayList list = new SortedArrayList();
		list.add("Jane");
		list.add("Bob");
		list.add("Alice");
		list.add("jane");
		System.out.println(list);
		System.out.println("number of items in list is " + list.size());
		System.out.println("index of Bob is " + list.indexOf("Bob"));
		list.remove("Frank"); // Frank does not exist
		list.remove("Alice");
		System.out.println("Now the list is " + list);
		System.out.println("The number of items in the list is " + list.size());
		System.out.println("The item at index is 1 is " + list.get(1));
	}

}