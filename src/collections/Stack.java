package collections;

public class Stack<T> {

	private Node<T> root;
	private int size = 0;

	public void push(T info) {

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

	public T pop() {

		Node<T> current = root;
		T returnedInfo;

		if (this.size() == 1)
			returnedInfo = current.getInfo();

		for (int i = 0; i < this.size() - 2; i++) {
			current = current.getNext();
		}

		returnedInfo = current.getNext().getInfo();
		current.setNext(null);
		decrementCounter();
		return returnedInfo;
	}

	public T peek() {
		Node<T> current = root;
		T returnedInfo;

		if (this.size() == 1)
			returnedInfo = current.getInfo();

		for (int i = 0; i < this.size() - 2; i++) {
			current = current.getNext();
		}

		returnedInfo = current.getNext().getInfo();
		return returnedInfo;
	}

	public int size() {
		return this.size;
	}

	private void incrementCounter() {
		this.size++;
	}

	private void decrementCounter() {
		this.size--;
	}

	public boolean isEmpty() {
		return false;
	}

}
