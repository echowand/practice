package array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix.length == 0) {
			return result;
		}
		// starting from top left
		int rowEnd = matrix.length - 1;
		int colEnd = matrix[0].length - 1;
		int row = 0;
		int col = 0;

		while (row <= rowEnd && col <= colEnd) {
			if (row == rowEnd) {
				for (int i = col; i <= colEnd; i++) {
					result.add(matrix[row][i]);
				}
				return result;
			}
			if (col == colEnd) {
				for (int i = row; i <= rowEnd; i++) {
					result.add(matrix[i][col]);
				}
				return result;
			}

			for (int i = row; i < colEnd; i++) {
				result.add(matrix[row][i]);
			}
			for (int i = col; i < rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}
			for (int i = colEnd; i > col; i--) {
				result.add(matrix[rowEnd][i]);
			}
			for (int i = rowEnd; i > row; i--) {
				result.add(matrix[i][col]);
			}
			row++;
			col++;
			rowEnd--;
			colEnd--;
		}
		return result;
	}

	@Test
	public void test() {
		int[][] x = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		List<Integer> l = spiralOrder(x);
		System.out.println(l.toString());
	}
}
