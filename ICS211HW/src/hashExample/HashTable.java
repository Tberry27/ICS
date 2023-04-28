package hashExample;

import java.util.LinkedList;

public class HashTable<K, V> {
	private LinkedList[] table;
	private int keyCollisions;
	private int size;

	public HashTable(int size) {
		table = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<HashKeyValue>();
		}
		keyCollisions = 0;
		this.size = size;
	}
	public int getTableRowSize(K key) {

		int tableIndex = key.hashCode() % size;
		return table[tableIndex].size();
	}

   @SuppressWarnings("unchecked")
	public void add(K key, V value) {
		int tableIndex = key.hashCode() % size;
		if (getTableRowSize(key) > 0) {
			keyCollisions++;
		}
		HashKeyValue<K, V> hkv = new HashKeyValue<K, V>(key, value);
		table[tableIndex].addFirst(hkv);
	}
	public V find(K key) {
		return null;
	}

	public int getKeyCollisions() {
		return keyCollisions;
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < size; i++) {
			temp += "table[" + i + "] : " + table[i] + "\n";
		}
		return temp;
	}

	public static void main(String[] args) {
		HashTable<String, Integer> table = new HashTable<String, Integer>(5);
		table.add("cat", 5);
		table.add("dog", 6);
		table.add("cat", 7);
		table.add("cow",16);
		table.add("pig", 12);
		table.add("cat", 10);
		System.out.println(table);
	}
}