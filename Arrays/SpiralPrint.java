
public class SpiralPrint {

	public static void spiralPrint(int row, int col, int[][] mat) {

		int m = 0, n = 0;

		while (m < row && n < col) {

			for (int i = n; i < col; i++)
				System.out.println(mat[m][i]);

			m++;

			for (int i = m; i < row; i++)
				System.out.println(mat[i][col - 1]);

			col--;

			if (m < row) {
				for (int i = col - 1; i >= n; i--)
					System.out.println(mat[row - 1][i]);
				row--;
			}

			if (n < col) {
				for (int i = row - 1; i >= m; i--)
					System.out.println(mat[i][n]);
				n++;
			}
		}

	}

	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		spiralPrint(R, C, a);
	}
}