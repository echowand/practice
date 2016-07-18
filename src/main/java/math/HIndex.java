package math;

import java.util.Arrays;

public class HIndex {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int len = citations.length;
		int result = 0;
		for (int i = len - 1; i >= 0; i--) {
			int h = Integer.min(len - i, citations[i]);
			if (h > result) {
				result = h;
			}
		}
		return result;
	}
}
