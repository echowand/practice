package array;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int row = 0;
		int rowEnd = n - 1;
		int x = 1;
		while (row <= rowEnd) {
			if (row == rowEnd) {
				result[row][row] = x;
				return result;
			}
			for (int i = row; i < rowEnd; i++) {
				result[row][i] = x;
				x++;
			}
			for (int i = row; i < rowEnd; i++) {
				result[i][rowEnd] = x;
				x++;
			}
			for (int i = rowEnd; i > row; i--) {
				result[rowEnd][i] = x;
				x++;
			}
			for (int i = rowEnd; i > row; i--) {
				result[i][row] = x;
				x++;
			}
			row++;
			rowEnd--;
		}
		return result;
	}
}
