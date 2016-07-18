package array;

import java.util.TreeSet;

import org.junit.Test;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1) {
			return false;
		}
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			int curr = nums[i];
			// System.out.println("i " + i + " curr " + curr);
			// System.out.println(set.ceiling(curr) + " " + set.floor(curr));
			// curr- set.floor(curr) overflows
			if ((set.ceiling(curr) != null && set.ceiling(curr) - curr <= t)
					|| (set.floor(curr) != null && (long) curr- set.floor(curr) <= t)) {
				return true;
			}
			set.add(curr);
		}
		return false;
	}

	@Test
	public void test() {
		int[] nums = { -1, -1 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 1, -1));
	}
}
