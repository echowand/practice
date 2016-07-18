package array;

import org.junit.Test;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		return searchHelper(nums, 0, nums.length - 1, target);
	}

	public int searchHelper(int[] nums, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return mid;
		}

		if (nums[mid] >= nums[start]) {
			if (target >= nums[start] && target <= nums[mid]) {
				return searchHelper(nums, start, mid, target);
			} else {
				return searchHelper(nums, mid + 1, end, target);
			}
		} else {
			if (target >= nums[mid] && target <= nums[end]) {
				return searchHelper(nums, mid, end, target);
			} else {
				return searchHelper(nums, start, mid - 1, target);
			}
		}
	}

	@Test
	public void test() {
		int[] nums = { 1,3 };
		System.out.println(search(nums, 2));
	}
}
