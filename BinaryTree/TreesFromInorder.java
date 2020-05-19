import java.util.Vector;

public class TreesFromInorder {
	static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
		}
	}

	Node root;

	static Vector<Node> getTrees(int[] in, int start, int end) {
		Vector<Node> trees = new Vector<Node>();

		if (start > end) {
			trees.add(null);
			return trees;
		}

		for (int i = start; i <= end; i++) {
			Vector<Node> ltrees = getTrees(in, start, i - 1);

			Vector<Node> rtrees = getTrees(in, i + 1, end);

			for (int j = 0; j < ltrees.size(); j++) {
				for (int k = 0; k < rtrees.size(); k++) {
					Node root = new Node(in[i]);

					root.left = ltrees.get(j);
					root.right = rtrees.get(k);

					trees.add(root);

				}
			}
		}

		return trees;

	}

	static void preorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.key + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void main(String[] args) {
		int in[] = { 4, 5, 7 };
		int n = in.length;

		Vector<Node> trees = getTrees(in, 0, n - 1);

		for (int i = 0; i < trees.size(); i++) {
			System.out.println();
			preorder(trees.get(i));
		}

	}

}