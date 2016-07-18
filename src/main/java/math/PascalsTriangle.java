package math;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return result;
		}
		List<Integer> prev = new ArrayList<Integer>();
		prev.add(1);
		result.add(prev);
		for (int i = 1; i < numRows; i++) {
			List<Integer> curr = new ArrayList<Integer>();
			curr.add(1);
			for (int j = 1; j < i; j++) {
				// row[3][1]=row[2][0]+row[2][1]
				// row[4][1]=row[3][0]+row[3][1]
				// row[4][2]=row[3][1]+row[3][2]
				curr.add(prev.get(j - 1) + prev.get(j));
			}
			curr.add(1);
			result.add(curr);
			prev = curr;
		}
		return result;
	}

	@Test
	public void test() {
		generate(3);
	}
}
