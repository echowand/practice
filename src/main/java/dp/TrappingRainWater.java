package dp;

import org.junit.Test;

public class TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		int result = 0;
		int max = 0;
		left[0] = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i - 1] > max) {
				left[i] = height[i - 1];
				max = height[i - 1];
			} else {
				left[i] = max;
			}
		}

		max = 0;
		right[height.length - 1] = 0;
		for (int i = height.length - 2; i >= 0; i--) {
			if (height[i + 1] > max) {
				right[i] = height[i + 1];
				max = height[i + 1];
			} else {
				right[i] = max;
			}
			int maxHeight = Integer.min(left[i], right[i]);

			if (maxHeight - height[i] > 0) {
				result += maxHeight - height[i];
			}
		}
		return result;
	}

	@Test
	public void test() {
		int[] x = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		trap(x);
	}
}
