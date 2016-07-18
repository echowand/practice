package math;

import org.junit.Test;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		// max profit before i. (transaction 1)
		int[] left = new int[prices.length];
		int min = Integer.MAX_VALUE;
		int maxProfit1 = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			maxProfit1 = Integer.max(prices[i] - min, maxProfit1);
			left[i] = maxProfit1;
		}
		// max profit after i. (transaction 2)
		int[] right = new int[prices.length];
		int max = Integer.MIN_VALUE;
		int maxProfit2 = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (prices[i] > max) {
				max = prices[i];
			}
			maxProfit2 = Integer.max(max - prices[i], maxProfit2);
			right[i] = maxProfit2;
		}

		int result = 0;
		for (int i = 0; i < prices.length; i++) {
			if (left[i] + right[i] > result) {
				result = left[i] + right[i];
			}
			// System.out.println(left[i] + " " + right[i] + " " + result);
		}
		return result;
	}

	@Test
	public void test() {
		int[] input = { 1, 4, 5, 7, 6, 3, 2, 9 };
		maxProfit(input);
	}
}
