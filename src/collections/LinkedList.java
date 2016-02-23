package collections;

public class LinkedList<T> extends Node<T> implements List<T> {

	private Node<T> root;
	private int counter = 0;

	public int size() {
		/*
		 * int size =0; Node<> if(this.info == null) return size; if
		 * (this.next.info == null){ size++; return size; } if(this.next.info !=
		 * null){ size++; Node<T> temp = new Node<T>(); temp = this.next; }
		 */
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
		// should we consider if the user gives a number that is out of bounds?
		// if (pos < 0 || pos > size())
		// return null;

		// save the element currently at pos to return to the user
		T element = get(pos - 1);

		Node<T> current = this.root;
		if (root != null) {
			for (int i = 0; i < pos; i++) {
				if (current.next == null)
					return element;

				current = current.next;
			}
			current.next = current.next.next;

			// decrement the number of elements variable
			this.counter--;
			return element;

		}
		return element;
	}

	public T remove() {
		T element = get(size() - 1);

		Node<T> current = this.root;
		if (root != null)
			while (current.next.next != null) {
				current = current.next;
			}
		current.next = null;
		this.counter--;
		return element;
	}

	public void add(T info, int pos) {

		Node<T> temp = new Node<T>(info);
		Node<T> current = root;

		if (current != null)
			// crawl to the requested index or the last element in the list
			for (int i = 1; i < pos && current.getNext() != null; i++)
				current = current.getNext();

		// set the new node's next-node to this node's next-node reference
		temp.next = current.getNext();

		// now set this node's next-node reference to the new node
		current.next = temp;

		// increment the number of elements variable
		this.counter++;

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

			/*
			 * starting at the head node, crawl to the end of the list and then
			 * add element after last node
			 */
			while (current.getNext() != null) {
				current = current.getNext();
			}

			// the last node's "next" reference set to our new node
			current.next = temp;
		}

		// increment the number of elements variable
		this.counter++;
	}

	public String toString() {
		String output = "[";

		if (root != null) {
			Node<T> current = root.getNext();

			while (current != null) {
				if (current.next == null) {
					output += current.toString();
				} else
					output += current.toString() + ", ";

				current = current.getNext();
			}
		}

		return output + "]";
	}

}