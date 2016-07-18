package array;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		// p0: first 0
		// p1: non 0
		int p0 = 0;
		int p1 = 0;

		while (p1 < nums.length && p0 < nums.length) {
			if (nums[p1] == 0) {
				p1++;
				continue;
			}
			if (nums[p0] != 0) {
				p0++;
				p1 = p0;
				continue;
			}
			int temp = nums[p1];
			nums[p1] = nums[p0];
			nums[p0] = temp;
			p0++;
			p1++;
		}
	}
}
