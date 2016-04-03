package collections;

public class LinkedList<T> implements List<T> {

	private static int counter;
	private Node<T> root;

	public LinkedList() {

	}

	public void add(T info) {

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

	private static int getCounter() {
		return counter;
	}

	private static void incrementCounter() {
		counter++;
	}

	private void decrementCounter() {
		counter--;
	}

	public void add(T info, int index) {
		Node<T> temp = new Node<T>(info);
		Node<T> current = root;

		if (current != null) {
			for (int i = 1; i < index && current.getNext() != null; i++) {
				current = current.getNext();
			}
		}

		temp.setNext(current.getNext());

		current.setNext(temp);

		incrementCounter();
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		if (index < 0)
			return null;
		Node<T> current = null;
		if (root != null) {
			current = root;
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return null;

				current = current.getNext();
			}
			return current.getInfo();
		}

		// This may break something, not sure why it works
		return (T) current;

	}

	/*public T remove(int index) throws NullPointerException {

		if (index < 1 || index > size())
			return null;
	//	if (index > 0)
	//		index--;
	////	else
	//		index = 0;
		Node<T> current = root;
		Node<T> returnRemoved = new Node<T>(current.getInfo());
		if (root != null) {

			if (index == 0) {
				root.setInfo(null);
				root = root.getNext();
				return returnRemoved.getInfo();
			}

			for (int i = 0; i < index-1; i++) {
				if (current.getNext() == null) {
					return null;// false;
				}
				System.out.println("Entered " + i);
				current = current.getNext();
			}
			// save the info being removed to return at the end
			returnRemoved.setInfo(current.getInfo());
			current.setNext(current.getNext().getNext());

			decrementCounter();
			return returnRemoved.getInfo();

		}
		return null;
	}*/
	
	public T remove(int index){
		Node<T> current = root;

		if (index == 0)
			root=root.getNext();
		else{
			for (int i = 0; i<index-1;i++){
				current = current.next;
			}
			current.setNext(current.getNext().getNext());
		}
		return null;
	}


	public int size() {
		return getCounter();
	}

	public String toString() throws NullPointerException{
		String output = "";

		try{

		if (root != null) {
			Node<T> current = root;
		//	output += root.getInfo().toString();
			while (current != null) {
				output += "[" + current.getInfo().toString() + "]";
				current = current.getNext();
			}

		} else
			output = "[]";
		}
		catch(Exception e){
			System.out.println("[]");
		}

		return output;
	}

	public T remove() throws NullPointerException {
		return remove(getCounter() - 1);
	}

	public void clear() {
		Node<T> temp = new Node<T>(null);
		root = temp;
	}

	public T get() {
		return get(size() - 1);
	}

	public boolean contains(T val) throws NullPointerException {
		Node<T> current = root;
		try {
			int i = 0;

			while (current != null) {
				if (this.get(i).equals(val)) {
					return true;
				} else {
					current = current.getNext();
					i++;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}

	}

}