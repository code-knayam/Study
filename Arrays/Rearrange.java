import java.util.Arrays;

public class Rearrange {

	public static void rearrangeArray(int[] arr, int n) {

		Arrays.sort(arr);

		int[] temp = new int[n];
		int i = 0, j = n - 1, c = 0;

		while (c < n) {
			if (c < n) {

				temp[c] = arr[i];
				c++;
				i++;
			}

			if (c < n) {

				temp[c] = arr[j];
				c++;
				j--;
			}
		}

		for (i = 0; i < n; i++) {
			arr[i] = temp[i];
		}

	}

	public static void main(String args[]) {
		int arr[] = { 5, 8, 1, 4, 2, 9, 3, 7, 6 };
		int n = arr.length;
		rearrangeArray(arr, n);

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}