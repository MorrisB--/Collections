
package collections;

public class Node<T> {
	T info;
	Node<T> next;

	public String toString() {
		return "" + info;
	}

	public static void main(String[] args) {
		Node n = new Node();
		n.info = 92;

		Node m = new Node();
		m.info = 94;
		Node o = new Node();
		o.info = 96;
		Node p = new Node();
		p.info = 98;
		Node r = new Node();
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

	public static void deleteAddr(Node x) {
		x = null;
	}

	public static void changeValue(Node<Integer> x) {
		x.info = 2 * x.info;
	}

	public static void displayInfo(Node r) {
		while (r != null) {
			System.out.print(r.info + " ");
			r = r.next;
		}
		System.out.println();
	}
}
