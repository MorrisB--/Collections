package collections;

public class Queue<T> {

	private Node<T> root;
	private int size = 0;

	public Queue() {

	}

	public void enqueue(T info) {
		
		if (root == null) {
			root = new Node<T>(info);
		} else {

			Node<T> temp = new Node<T>(info);
			Node<T> current = root;

			if (current != null) {

				while (current.getNext() != null) {
					current = current.getNext();
				}

				// the last node's "next" reference set to our new node
				current.setNext(temp);
			}
		}
		incrementCounter();
	}

	public void enqueue(T info, int location) {

	}

	public T dequeue() {
		return null;
	}

	// change to getSize()
	public int size() {
		return this.size;
	}

	private void incrementCounter() {
		this.size++;
	}

	private void decrementCounter() {
		this.size--;
	}

	public void clear() {

	}

}
