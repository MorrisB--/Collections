package collections;

import collections.Queue;

public class BinarySearchTree<T> // implements BSTInterface<T>
{
	Node<Integer> root;

	public void add(Integer info) {
		Node n = new Node(info);
		if (root == null) {
			root = n;
			return;
		}
		add(n, root);
	}

	public void add(Node<Integer> n, Node<Integer> t) {
		if (n.info < t.info) {
			if (t.left == null) {
				t.left = n;
			} else {
				add(n, t.left);
			}
		} else {
			if (t.right == null) {
				t.right = n;
			} else {
				add(n, t.right);
			}
		}
	}

	public void preOrder(Node<Integer> n, Queue<Integer> que) {
		if (n == null) {
			return;
		}
		System.out.print(n.info + " ");
		que.enqueue(n.info);
		preOrder(n.left, que);
		preOrder(n.right, que);
	}

	public void inOrder(Node<Integer> n, Queue<Integer> que) {
		if (n == null) {
			return;
		}
		inOrder(n.left, que);
		System.out.print(n.info + " ");
		que.enqueue(n.info);
		inOrder(n.right, que);
	}

	public Queue<Integer> traverse(int p) {
		Queue<Integer> q = new Queue<>();
		if (p == 0) {
			inOrder(root, q);
			return q;
		} else if (p == 1) {
			preOrder(root, q);
			return q;
		} else {
			System.out.println("Not implemented!");
		}
		return null;
	}

	public boolean remove(Integer info) {
		return false;
	}

	public void balance() {
	}

	private int sizeRec(Node n) {
		if (n == null) {
			return 0;
		}
		return 1 /* ? */;
	}

	public int size() {
		return sizeRec(root);
	}

	public boolean contains(Integer info) {
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < 16; i++) {
			int d = (int) (Math.random() * 100);
			bst.add(d);
		}
		System.out.println("done!");
		System.out.print("In order: ");
		bst.traverse(0);
		System.out.println();
		System.out.print("Pre order: ");
		bst.traverse(1);
		System.out.println();
		System.out.print("Post order: ");
		bst.traverse(2);
		System.out.println();

		int s = bst.size();
		System.out.println("Size = " + s);
	}

	/*************/
	private int heightRec(Node<Integer> n) {
		if (n == null)
			return 0;
		return 1 + Math.max(heightRec(n.left), heightRec(n.right));
	}

	public int height() {
		return heightRec(root);
	}

	private T min(Node<T> n) {
		if (n.left == null)
			return n.info;
		return min(n.left);
	}

	private T max(Node<T> n) {
		if (n.right == null)
			return n.info;
		return max(n.right);
	}

	public T predecessor(Node<T> n) {
		return max(n.left);
	}

	public T sucessor(Node<T> n) {
		return min(n.right);
	}

}