public class RotateMatrix {

	public static void rotatematrix(int n, int m, int[][] arr) {
		int row = 0, col = 0, prev, curr;

		while (row < n && col < m) {
			if (row + 1 == n || col + 1 == m) {
				break;
			}

			prev = arr[row + 1][col];

			// first row
			for (int i = col; i < n; i++) {
				curr = arr[row][i];
				arr[row][i] = prev;
				prev = curr;
			}
			row++;

			// last col
			for (int i = row; i < m; i++) {
				curr = arr[i][n - 1];
				arr[i][n - 1] = prev;
				prev = curr;
			}
			n--;

			// last row
			if (row < n) {

				for (int i = m - 1; i >= col; i--) {
					curr = arr[m - 1][i];
					arr[m - 1][i] = prev;
					prev = curr;
				}
			}
			m--;

			// first col
			if (col < n) {

				for (int i = m - 1; i >= row; i--) {
					curr = arr[i][col];
					arr[i][col] = prev;
					prev = curr;
				}
			}

			col++;
		}

	}

	public static void main(String[] args) {
		// Test Case 1
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int R = 4;
		int C = 4;

		// Tese Case 2
		/*
		 * int a[][] = new int {{1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		 */
		rotatematrix(R, C, a);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.println(a[i][j] + " ");
			}
			System.out.println();
		}

	}
}