import java.util.Stack;

public class InorderWithoutRecursion {
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

	static void inorder(Node root) {
		Stack<Node> s = new Stack<Node>();
		Node curr = root;

		while (curr != null || s.size() > 0) {

			while (curr != null) {
				s.add(curr);
				curr = curr.left;
			}

			curr = s.pop();

			System.out.println(curr.key);

			curr = curr.right;
		}
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		Node root = new Node(1);
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		inorder(root);
	}
}