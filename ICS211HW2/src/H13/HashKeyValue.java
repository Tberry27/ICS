package H13;

public class HashKeyValue<K, V> {
	private K key;
	private V value;

	public HashKeyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public K getKey() {
		return key;
	}

	public String toString() {
		return key + " : " + value;
	}
}