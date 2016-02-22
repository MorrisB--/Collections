
package collections;

public class Node<T> {
	T info;
	Node<T> next;

	public String toString() {
		return "" + info;
	}

	public static void main(String[] args) {
		Node<Integer> n = new Node<Integer>();
		n.info = 92;

		Node<Integer> m = new Node<Integer>();
		m.info = 94;
		Node<Integer> o = new Node<Integer>();
		o.info = 96;
		Node<Integer> p = new Node<Integer>();
		p.info = 98;
		Node<Integer> r = new Node<Integer>();
		r.info = 100;

		n.next = m;
		deleteAddr(m);
		changeValue(m);

		n.next.next = o;
		o = null;
		n.next.next.next = p;
		p = null;
		n.next.next.next.next = r;
		r = null;
		// displayInfo(n);
		deleteAddr(n);

	}

	//This will only work with integers, figure out a way to have it generic
	public static void deleteAddr(Node<Integer> x) {
		x = null;
	}

	//This will only work with integers, figure out a way to have it generic
	public static void changeValue(Node<Integer> x) {
		x.info = 2 * x.info;
	}

	//This will only work with integers, figure out a way to have it generic
	public static void displayInfo(Node<Integer> r) {
		while (r != null) {
			System.out.print(r.info + " ");
			r = r.next;
		}
		System.out.println();
	}
}
