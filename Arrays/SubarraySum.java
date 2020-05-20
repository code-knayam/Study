import java.util.ArrayList;

public class SubarraySum {

	static void getSubarray(int[] arr, int sum, int n) {
		int tempSum = 0, start = 0, end = 0, i = 0, j = 0;

		while (i <= j && j < n) {
			if (tempSum + arr[j] <= sum) {
				tempSum += arr[j];

				if (tempSum == sum && (end - start) < (j - i)) {
					start = i;
					end = j;
				}
				j++;

			} else {
				tempSum -= arr[i];
				i++;
			}
		}
		System.out.println(start + " " + end);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int n = 10;
		int sum = 15;

		getSubarray(arr, sum, n);
	}
}