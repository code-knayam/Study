public class MaxHeight {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static int maxDepth(Node root) {
		if (root == null)
			return 0;

		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.left);

		if (lDepth > rDepth) {
			return lDepth + 1;
		} else {
			return rDepth + 1;
		}

	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Height of tree is : " + maxDepth(root));
	}
}