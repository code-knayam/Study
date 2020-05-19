import java.util.Arrays;

class GetPostorder {

	public static int search(int[] in, int x, int n) {
		for (int i = 0; i < n; i++) {
			if (in[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public static void printPostOrder(int[] in, int[] pre, int n) {

		// get root
		int root = search(in, pre[0], n);

		// get left
		if (root != 0) {
			printPostOrder(in, Arrays.copyOfRange(pre, 1, n), root);
		}

		if (root != n - 1) {
			printPostOrder(Arrays.copyOfRange(in, root + 1, n), Arrays.copyOfRange(pre, root + 1, n), n - root - 1);
		}

		System.out.println(pre[0]);
	}

	public static void main(String args[]) {
		int in1[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		int n = in1.length;
		System.out.println("Postorder traversal ");
		printPostOrder(in1, pre, n);
	}
}