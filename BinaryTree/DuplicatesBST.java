public class DuplicatesBST {
	static Node root;

	static class Node {
		int key;
		int count;
		Node left, right;

		// constructor
		Node(int key) {
			this.key = key;
			this.count = 1;
			left = null;
			right = null;
		}
	}

	static void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.println(root.key + "( " + root.count + " )");
		inorder(root.right);
	}

	static Node insert(Node root, int key) {
		if (root == null)
			return new Node(key);

		if (root.key == key) {
			root.count++;
			return root;
		}

		if (key < root.key)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);

		return root;
	}

	static Node minValueNode(Node node) {
		Node current = node;
		while (current.left != null)
			current = current.left;

		return current;
	}

	static Node delete(Node root, int key) {
		if (root == null)
			return null;

		if (key < root.key)
			root.left = delete(root.left, key);
		else if (key > root.key)
			root.right = delete(root.right, key);

		else {
			if (root.count > 1) {
				root.count--;
				return root;
			}

			if (root.left == null) {
				Node temp = root.right;
				root = null;
				return temp;
			} else if (root.right == null) {
				Node temp = root.left;
				root = null;
				return temp;
			}

			Node minNode = minValueNode(root.right);
			root.key = minNode.key;
			root.right = delete(root.right, minNode.key);
		}

		return root;
	}

	public static void main(String[] args) {
		Node root = null;

		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 9);
		root = insert(root, 11);
		root = insert(root, 10);
		root = insert(root, 12);
		root = insert(root, 12);

		System.out.print("Inorder traversal of " + "the given tree " + "\n");
		inorder(root);

		System.out.print("\nDelete 20\n");
		root = delete(root, 20);
		System.out.print("Inorder traversal of " + "the modified tree \n");
		inorder(root);

		System.out.print("\nDelete 12\n");
		root = delete(root, 12);
		System.out.print("Inorder traversal of " + "the modified tree \n");
		inorder(root);

		System.out.print("\nDelete 9\n");
		root = delete(root, 9);
		System.out.print("Inorder traversal of " + "the modified tree \n");
		inorder(root);

		root = delete(root, 12);
		root = delete(root, 12);

		System.out.print("Inorder traversal of " + "the modified tree \n");
		inorder(root);
	}
}