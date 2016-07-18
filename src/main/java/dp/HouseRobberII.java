package dp;

public class HouseRobberII {
	public int rob(int[] nums) {
		int len = nums.length;
		if (len < 1) {
			return 0;
		}
		if (len == 1) {
			return nums[0];
		}
		// Equivalent to: max([0,len-2], [1,len-1])
		return Integer.max(helper(nums, 0), helper(nums, 1));
	}

	public int helper(int nums[], int start) {
		int dp[] = new int[nums.length];
		dp[0] = 0;
		dp[1] = nums[start];
		int i = 2;
		while (i < nums.length) {
			dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[start + i - 1]);
			i++;
		}
		return dp[nums.length - 1];
	}
}
