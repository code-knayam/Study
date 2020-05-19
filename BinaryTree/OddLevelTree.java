public class OddLevelTree {
	static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}

	public static void printOddNodes(Node root, boolean isOdd) {
		if (root == null) {
			return;
		}

		if (isOdd) {
			System.out.println(root.key);
		}
		printOddNodes(root.left, !isOdd);
		printOddNodes(root.right, !isOdd);
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		printOddNodes(root, true);
	}
}