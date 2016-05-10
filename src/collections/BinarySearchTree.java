package collections;

public class BinarySearchTree {

	Node<Integer> root;

	public void addNode(int info) {

		Node<Integer> temp = new Node<Integer>(info);

		if (root == null)
			root = temp;
		else {

			Node<Integer> current = root;
			Node<Integer> parent;

			while (true) {

				parent = current;

				if (info < current.info) {

					current = current.left;

					if (current == null) {
						parent.left = temp;
						break;
					}
				} else {

					current = current.right;
					if (current == null) {
						parent.right = temp;
						break;
					}
				}
			}
		}
	}

	public void inOrder(Node<Integer> current) {

		if (current != null) {

			inOrder(current.left);
			System.out.println(current.info);
			inOrder(current.right);
		}
	}

	public void preOrder(Node<Integer> focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode.info);
			preOrder(focusNode.left);
			preOrder(focusNode.right);
		}

	}

	public void postOrder(Node<Integer> temp) {

		if (temp != null) {

			postOrder(temp.left);
			postOrder(temp.right);
			System.out.println(temp.info);
		}
	}

	public Node<Integer> findNode(int info) {

		Node<Integer> current = root;

		while (current.info != info) {

			if (info < current.info)
				current = current.left;
			else
				current = current.right;
			if (current == null)
				return null;
		}
		return current;
	}

	public boolean remove(int info) {

		Node<Integer> current = root;
		Node<Integer> parent = root;

		boolean isLeftChild = true;

		while (current.info != info) {

			parent = current;

			if (info < current.info) {

				isLeftChild = true;
				current = current.left;

			} else {
				isLeftChild = false;
				current = current.right;
			}

			if (current == null)
				return false;

		}

		if (current.left == null && current.right == null) {
			if (current == root)
				root = null;

			else if (isLeftChild)
				parent.left = null;
			else
				parent.right = null;

		} else if (current.right == null) {

			if (current == root)
				root = current.left;
			else if (isLeftChild)
				parent.left = current.left;
			else
				parent.right = current.left;

		} else if (current.left == null) {

			if (current == root)
				root = current.right;
			else if (isLeftChild)
				parent.left = current.right;
			else
				parent.right = current.right;

		} else {

			Node<Integer> replacement = getReplacementNode(current);

			if (current == root)
				root = replacement;
			else if (isLeftChild)
				parent.left = replacement;
			else
				parent.right = replacement;
			replacement.left = current.left;

		}

		return true;

	}

	public Node<Integer> getReplacementNode(Node<Integer> replacedNode) {

		Node<Integer> replacementParent = replacedNode;
		Node<Integer> replacement = replacedNode;

		Node<Integer> current = replacedNode.right;

		while (current != null) {

			replacementParent = replacement;

			replacement = current;

			current = current.left;

		}

		if (replacement != replacedNode.right) {

			replacementParent.left = replacement.right;
			replacement.right = replacedNode.right;

		}

		return replacement;

	}
}