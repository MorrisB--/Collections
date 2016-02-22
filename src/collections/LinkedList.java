package collections;

public class LinkedList<T> extends Node<T> implements List<T>{
	
	private Node<T> root;
	private int counter = 0;
	
	public int size() {
		return 0;
	}

	public boolean contains(T val) {
		return false;
	}

	public void clear() {
	}

	public T get(int pos) {
		return null;
	}

	public T get() {
		return null;
	}

	public T remove(int pos) {
		return null;
	}

	public T remove() {
		return null;
	}

	public void add(T info, int pos) {
	}

	public void add(T info) {
		// Initialize Node only incase of 1st element 
				if (root == null) {
					root = new Node<T>(info);
				}
		 
				Node<T> temp = new Node<T>(info);
				Node<T> current = root;
		 
				// Let's check for NPE before iterate over current
				if (current != null) {
		 
					// starting at the head node, crawl to the end of the list and then add element after last node
					while (current.getNext() != null) {
						current = current.getNext();
					}
		 
					// the last node's "next" reference set to our new node
					current.next=temp;
				}
		 
				// increment the number of elements variable
				this.counter++;
	}

	
}