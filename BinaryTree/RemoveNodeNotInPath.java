public class RemoveNodeNotInPath {
	static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
		}
	}

	public static void print(Node root) {
		if (root == null)
			return;

		print(root.left);
		System.out.println(root.key);
		print(root.right);
	}

	public static Node prune(Node node, int sum) {

		if (node == null)
			return null;

		node.left = prune(node.left, sum - node.key);
		node.right = prune(node.right, sum - node.key);

		if (node.left == null && node.right == null) {
			if (node.key < sum) {
				return null;
			}
		}

		return node;
	}

	public static void main(String args[]) {
		int k = 45;
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(12);
		root.right.right.left = new Node(10);
		root.right.right.left.right = new Node(11);
		root.left.left.right.left = new Node(13);
		root.left.left.right.right = new Node(14);
		root.left.left.right.right.left = new Node(15);

		System.out.println("Tree before truncation\n");
		print(root);

		root = prune(root, k); // k is 45

		System.out.println("\n\nTree after truncation\n");
		print(root);
	}
}