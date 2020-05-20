public class CyclicRotation {
	static void printArray(int arr[], int size) {
		int i;
		System.out.println();
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	static void rotate(int[] arr, int n) {
		int temp = arr[n - 1];

		for (int i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(arr, 7);
		printArray(arr, 7);
	}
}