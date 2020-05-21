import java.util.Iterator;
import java.util.PriorityQueue;

public class KSorted {

	public static void kSort(int[] arr, int n, int k) {

		// pirority queue -> with K+1 elements

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		for (int i = 0; i < k + 1; i++) {
			q.add(arr[i]);
		}

		int index = 0;
		for (int i = k + 1; i < n; i++) {
			arr[index++] = q.peek();
			q.poll();
			q.add(arr[i]);
		}

		Iterator<Integer> ite = q.iterator();

		while (ite.hasNext()) {
			arr[index++] = q.peek();
			q.poll();
		}
	}

	public static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		int n = arr.length;
		kSort(arr, n, k);
		System.out.println("Following is sorted array");
		printArray(arr, n);
	}
}