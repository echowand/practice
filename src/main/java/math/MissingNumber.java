package math;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		long sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return (int) ((1 + nums.length) * nums.length / 2 - sum);
	}
}
