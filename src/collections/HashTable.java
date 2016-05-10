package collections;

public class HashTable<K, V> {
	private final int startingTableSize = 256;
	@SuppressWarnings("rawtypes")
	private HashNode[] hashTable;
	private int tableSize = startingTableSize, size = 0;
	private static int totalCollisions = 0, totalResizes = 0;

	public HashTable() {
		hashTable = new HashNode[startingTableSize];
	}

	private int hashFunction(K key) {
		int hash = Math.abs(key.hashCode());
		return hash % tableSize;
	}

	public float loadFactor() {
		return size / (float) tableSize;
	}

	@SuppressWarnings("unchecked")
	public void put(K key, V value) {
		int hash = hashFunction(key);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);

		if (loadFactor() > 0.40f) {
			totalResizes++;
			@SuppressWarnings("rawtypes")
			HashNode[] oldHashTable = this.hashTable;
			this.hashTable = new HashNode[tableSize * 2];
			tableSize = tableSize * 2;

			for (int i = 0; i < oldHashTable.length; i++) {
				HashNode<K, V> node = oldHashTable[i];
				while (node != null) {
					put(node.getKey(), node.getValue());
					node = node.getNext();
				}
			}
		}

		if (hashTable[hash] != null) {
			System.out.println("Collision occured.");
			totalCollisions++;
			// add to end of linked list
			 hashTable[hash].setNext(newNode);
		} else
			hashTable[hash] = newNode;
	
		size++;
	}

	public V get(K key) {
		int hash = hashFunction(key);
		@SuppressWarnings("unchecked")
		HashNode<K, V> hashNode = hashTable[hash];
		while (hashNode != null) {
			if (hashNode.getKey().equals(key))
				break;
			else
				hashNode = hashNode.getNext();
		}

		if (hashNode == null)
			return null;
		else
			return hashNode.getValue();
	}

	public void delete(K key) {
		int hash = hashFunction(key);
		hashTable[hash] = null;
	}

	public int getSize() {
		return size;
	}

	public int getNumCollisions() {
		return totalCollisions;
	}

	public int getNumResizes() {
		return totalResizes;
	}
}