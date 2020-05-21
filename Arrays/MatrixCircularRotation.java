
public class MatrixCircularRotation {

	public static boolean isPermutedMatrix(int[][] mat, int n) {
		String str = "";

		for (int i = 0; i < n; i++) {
			str += "-" + String.valueOf(mat[0][i]);
		}

		str += str;
		String tempStr = "";
		boolean isCircular = true;

		for (int i = 1; i < n; i++) {
			tempStr = "";
			for (int j = 0; j < n; j++) {
				tempStr += "-" + String.valueOf(mat[i][j]);
			}
			if (!str.contains(tempStr)) {
				isCircular = false;
				break;
			}
		}

		return isCircular;
	}

	public static void main(String[] args) {
		int n = 4;
		int mat[][] = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };
		if (isPermutedMatrix(mat, n)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}