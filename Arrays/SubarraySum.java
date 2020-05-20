import java.util.ArrayList;
import java.util.Scanner;

public class SubarraySum {

	static void getSubarray(int[] arr, int sum, int n) {
		int tempSum = 0, start = -1, end = -1, i = 0, j = 0;

		while (i <= j && j < n) {
			if (tempSum + arr[j] <= sum) {
				tempSum += arr[j];

				if (tempSum == sum) {
					start = i;
					end = j;
					break;
				}
				j++;

			} else {
				tempSum -= arr[i];
				i++;
			}
		}
		if (start == -1 && end == -1) {
			System.out.println(-1);
		} else {
			System.out.println((start + 1) + " " + (end + 1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while (x-- > 0) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			getSubarray(arr, sum, n);
		}
	}
}