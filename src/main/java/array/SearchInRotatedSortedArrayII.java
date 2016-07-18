package array;

import org.junit.Test;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] == nums[start]) {
				start++;
			} else if (nums[mid] > nums[start]) {
				if (nums[start] <= target && target <= nums[mid]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			} else {
				if (nums[mid] <= target && target <= nums[end]) {
					start = mid;
				} else {
					end = mid - 1;
				}
			}
		}
		return false;
	}

	@Test
	public void test() {
		int[] nums = { 1, 3, 5 };
		System.out.println(search(nums, 1));
	}
}
