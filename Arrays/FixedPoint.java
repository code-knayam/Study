public class FixedPoint {

	public static int binarySearch(int[] arr, int start, int end) {
		if (start <= end) {

			int mid = (start + end) / 2;

			if (arr[mid] == mid) {
				return mid;
			} else if (arr[mid] < mid) {
				return binarySearch(arr, mid + 1, end);
			} else {
				return binarySearch(arr, start, mid - 1);
			}

		}
		return -1;

	}

	public static void main(String args[]) {
		int arr[] = { -10, -1, 0, 3, 10, 11, 30, 50, 100 };
		int n = arr.length;
		System.out.println("Fixed Point is " + binarySearch(arr, 0, n - 1));
	}
}