package collections;

	final class Node<T> {
		Node<T> next;
		Node<T> left;
		Node<T> right;
		T info;
 
		public Node(T infoValue) {
			next = null;
			info = infoValue;
		}
 

		public Node(T infoValue, Node<T> nextValue) {
			next = nextValue;
			info = infoValue;
		}
 
		public T getInfo() {
			return info;
		}
 
		public void setInfo(T infoValue) {
			info = infoValue;
		}
 
		public Node<T> getNext() {
			return next;
		}
 
		public void setNext(Node<T> nextValue) {
			next = nextValue;
		}
 
	}
