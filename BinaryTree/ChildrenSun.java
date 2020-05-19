
public class ChildrenSun {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static int isSumProperty(Node root) {
		int left = 0, right = 0;

		if (root == null || (root.left == null && root.right == null)) {
			return 1;
		} else {
			if (root.left != null) {
				left = root.left.data;
			}
			if (root.right != null) {
				right = root.right.data;
			}

			if (root.data == (left + right) && isSumProperty(root.left) != 0 && isSumProperty(root.right) != 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(2);

		if (isSumProperty(root) != 0)
			System.out.println("The given tree satisfies children" + " sum property");
		else
			System.out.println("The given tree does not satisfy children" + " sum property");
	}
}