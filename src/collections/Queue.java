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
		incrementSize();
	}

	public void enqueue(T info, int index) {

		Node<T> temp = new Node<T>(info);
		Node<T> current = root;

		if (current != null) {
			for (int i = 1; i < index && current.getNext() != null; i++) {
				current = current.getNext();
			}
		}

		temp.setNext(current.getNext());

		current.setNext(temp);

		incrementSize();

	}

	public T dequeue() throws NullPointerException {

		T returnedInfo = root.info;

		if (root.getNext() == null)
			root = null;
		else
			root = root.getNext();

		decrementSize();
		
		return returnedInfo;
	}

	public int getSize() {
		return this.size;
	}

	private void incrementSize() {
		this.size++;
	}

	private void decrementSize() {
		this.size--;
	}

	public boolean isEmpty() {
		if (this.getSize() == 0)
			return true;
		return false;
	}

	public void clear() {

	}

}
