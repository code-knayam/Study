
public class CoveredUncoveredSum {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static int sum(Node root) {
		if (root == null)
			return 0;
		return root.data + sum(root.left) + sum(root.right);
	}

	static int rightUcSum(Node root) {
		if (root.right == null && root.right == null)
			return 0;

		if (root.right != null) {
			return root.data + rightUcSum(root.right);
		} else {
			return root.data + rightUcSum(root.left);
		}
	}

	static int leftUcSum(Node root) {
		if (root.left == null && root.right == null)
			return 0;

		if (root.left != null) {
			return root.data + leftUcSum(root.left);
		} else {
			return root.data + leftUcSum(root.right);
		}
	}

	static int sumUc(Node root) {
		int lSum = 0, rSum = 0;

		if (root == null) {
			return 0;
		}

		if (root.left != null) {
			lSum = leftUcSum(root.left);
		}

		if (root.right != null) {
			rSum = rightUcSum(root.right);
		}

		return root.data + lSum + rSum;
	}

	static boolean isSumSame(Node root) {
		int sum = sum(root);

		int sumUc = sumUc(root);

		return sumUc == (sum - sumUc);
	}

	public static void main(String[] args) {

		// Making above given diagram's binary tree
		Node root = new Node(13);
		root.left = new Node(3);
		// root.left.left = new Node(1);
		// root.left.right = new Node(6);
		// root.left.right.left = new Node(4);
		// root.left.right.right = new Node(7);

		root.right = new Node(10);
		// root.right.right = new Node(14);
		// root.right.right.left = new Node(13);

		if (isSumSame(root))
			System.out.println("Sum of covered and uncovered is same");
		else
			System.out.println("Sum of covered and uncovered is not same");
	}
}