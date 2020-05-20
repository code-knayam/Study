import java.util.Scanner;

public class KadanesAlgo {

	public static void maxSum(int[] arr, int n) {

		int sum = arr[0], tempSum = arr[0];

		for (int i = 1; i < n; i++) {
			tempSum = Math.max(arr[i], tempSum + arr[i]);
			sum = Math.max(tempSum, sum);
		}
		System.out.println(sum);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while (x-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			System.out.println();
			maxSum(arr, n);
		}
	}
}