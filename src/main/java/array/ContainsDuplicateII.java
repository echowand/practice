package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> distinct = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				distinct.remove(nums[i - k - 1]);
			}
			if (distinct.contains(nums[i])) {
				return true;
			}
			distinct.add(nums[i]);
		}
		return false;
	}
}
