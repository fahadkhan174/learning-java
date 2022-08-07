package ds.hashmap;

import java.util.Arrays;

public class HashMapImpl<K, V> {

	private Node<K, V>[] buckets;
	private static final int INITIAL_CAPACITY = 1 << 4; // 16

	private int size = 0;

	public HashMapImpl() {
		this(INITIAL_CAPACITY);
	}

	public HashMapImpl(int capacity) {
		this.buckets = new Node[capacity];
	}

	public int getHash(K key) {
		return key.hashCode() % this.buckets.length;
	}

	public void put(K key, V value) {
		Node<K, V> Node = new Node<>(key, value, null);

		int bucket = this.getHash(key);

		Node<K, V> existing = buckets[bucket];
		if (existing == null) {
			buckets[bucket] = Node;
			size++;
		} else {
			// compare the keys see if key already exists
			while (existing.next != null) {
				if (existing.key.equals(key)) {
					existing.value = value;
					return;
				}
				existing = existing.next;
			}

			if (existing.key.equals(key)) {
				existing.value = value;
			} else {
				existing.next = Node;
				size++;
			}
		}
	}

	@Override
	public String toString() {
		return "HashMapImpl [buckets=" + Arrays.toString(buckets) + ", size=" + size + "]";
	}	

}
