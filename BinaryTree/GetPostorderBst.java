class GetPostorderBst {
	static int index = 0;

	public static void findPostOrder(int[] pre, int n, int minVal, int maxVal) {
		if (index == n)
			return;

		if (pre[index] < minVal || pre[index] > maxVal)
			return;

		int temp = pre[index];
		index++;
		findPostOrder(pre, n, minVal, temp);
		findPostOrder(pre, n, temp, maxVal);
		System.out.println(temp);
	}

	public static void main(String args[]) {
		int pre[] = { 40, 30, 35, 80, 100 };

		int n = pre.length;

		// Calling function
		findPostOrder(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}