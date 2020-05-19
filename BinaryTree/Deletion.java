import java.util.LinkedList;
import java.util.Queue;

public class Deletion {
	static Node root;

	static class Node {
		int key;
		Node left, right;

		// constructor
		Node(int key) {
			this.key = key;
			left = null;
			right = null;
		}
	}

	/* Inorder traversal of a binary tree */
	static void inorder(Node temp) {
		if (temp == null)
			return;

		inorder(temp.left);
		System.out.print(temp.key + " ");
		inorder(temp.right);
	}

	static void deleteDeepestNode(Node root, Node d_node) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		Node temp;

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.key == d_node.key) {
				temp = null;
				return;
			}

			if (temp.right != null) {
				if (temp.right.key == d_node.key) {
					temp.right = null;
					return;
				} else {
					q.add(temp.right);
				}
			}

			if (temp.left != null) {
				if (temp.left.key == d_node.key) {
					temp.left = null;
					return;
				} else {
					q.add(temp.left);
				}
			}
		}

	}

	static Node delete(Node root, int key) {
		if (root == null)
			return null;

		if (root.left == null && root.right == null) {
			if (root.key == key) {
				return null;
			} else {
				return root;
			}
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		Node temp = null;
		Node keyNode = null;

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.key == key)
				keyNode = temp;

			if (temp.left != null) {
				q.add(temp.left);
			}

			if (temp.right != null) {
				q.add(temp.right);
			}
		}

		if (keyNode != null) {
			int x = temp.key;
			deleteDeepestNode(root, temp);
			keyNode.key = x;
		}

		return root;

	}

	public static void main(String ar[]) {
		root = new Node(10);
		root.left = new Node(11);
		root.left.left = new Node(7);
		root.left.right = new Node(12);
		root.right = new Node(9);
		root.right.left = new Node(15);
		root.right.right = new Node(8);

		System.out.print("Inorder traversal before insertion:");
		inorder(root);

		int key = 11;
		root = delete(root, key);

		System.out.print("\nInorder traversal after insertion:");
		inorder(root);
	}
}