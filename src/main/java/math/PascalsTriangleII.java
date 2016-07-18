package math;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> prev = new ArrayList<Integer>();
		prev.add(1);
		List<Integer> curr = prev;
		for (int i = 1; i <= rowIndex; i++) {
			curr = new ArrayList<Integer>();
			curr.add(1);
			for (int j = 1; j < i; j++) {
				curr.add(prev.get(j - 1) + prev.get(j));
			}
			curr.add(1);
			prev = curr;
		}
		return curr;
	}
}
