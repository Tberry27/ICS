package hashExample;

public class HashKeyValue<K, V> {
	K key;
	V value;

	public HashKeyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public String toString() {
		return key + " : " + value;
	}
}