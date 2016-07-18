package dp;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Test;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		LinkedList<Integer> dp = new LinkedList<Integer>();
		for (int num : nums) {
			if (dp.size() == 0 || dp.getLast() < num) {
				dp.add(num);
			} else {
				if (Collections.binarySearch(dp, num) >= 0) {
					continue;
				} else {
					int i = -Collections.binarySearch(dp, num) - 1;
					//System.out.println(i + " " + num);
					dp.set(i, num);
				}
			}
		}
		return dp.size();
	}

	@Test
	public void test() {
		int[] nums = { 2, 2 };
		System.out.println("len of LIS: " + lengthOfLIS(nums));
	}
}
