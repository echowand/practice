package dp;

import org.junit.Test;

public class Candy {
	public int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		candies[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}
		int sum = 0;
		sum += candies[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Integer.max(candies[i], candies[i + 1] + 1);
			}
			// System.out.println(candies[i]);
			sum += candies[i];
		}
		return sum;
	}

	@Test
	public void test() {
		int[] input = { 1, 2, 2 };
		candy(input);
	}
}
