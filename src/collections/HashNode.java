package collections;

public class HashNode<K, V> {
	private K key;
	private V value;
	private HashNode<K, V> next;

	public HashNode(K key, V value) {
		setKey(key);
		setValue(value);
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public HashNode<K, V> getNext() {
		return next;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setNext(HashNode<K, V> next) {
		this.next = next;
	}

}