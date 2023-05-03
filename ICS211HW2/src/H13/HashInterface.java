package H13;

public interface HashInterface<K, V> {
	void add(K key, V value); // always succeeds as long as there is enough memory
	V find(K key);            // returns null if there is no such key
}