
public class FullBT {
	static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}

	public static boolean isFullTree(Node root) {
		if (root == null || (root.left == null && root.right == null))
			return true;

		return isFullTree(root.left) && isFullTree(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.right = new Node(40);
		root.left.left = new Node(50);
		root.right.left = new Node(60);
		root.left.left.left = new Node(80);
		root.right.right = new Node(70);
		root.left.left.right = new Node(90);
		root.left.right.left = new Node(80);
		root.left.right.right = new Node(90);
		root.right.left.left = new Node(80);
		root.right.left.right = new Node(90);
		root.right.right.left = new Node(80);
		root.right.right.right = new Node(90);

		if (isFullTree(root))
			System.out.print("The binary tree is full");
		else
			System.out.print("The binary tree is not full");
	}
}