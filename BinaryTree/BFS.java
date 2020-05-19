import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

	static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		Node temp;

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			System.out.println(temp.key);
			if (temp.left != null) {
				q.add(temp.left);
			}

			if (temp.right != null) {
				q.add(temp.right);
			}
		}

	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(10);

		System.out.print("Level order traversal before insertion:");
		levelOrder(root);
	}
}