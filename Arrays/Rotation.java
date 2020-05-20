public class Rotation {

	static void printArray(int arr[], int size) {
		int i;
		System.out.println();
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	static void leftRotate(int[] arr, int d, int n) {
		d = d % n;
		int gcd = gcd(n, d);
		// 3
		int j, temp, k;
		for (int i = 0; i < gcd; i++) {
			temp = arr[i];
			j = i;

			while (true) {
				k = j + d;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}
				arr[j] = arr[k];
				j = k;
			}

			arr[j] = temp;
		}

	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		leftRotate(arr, 2, 7);
		printArray(arr, 7);

	}
}