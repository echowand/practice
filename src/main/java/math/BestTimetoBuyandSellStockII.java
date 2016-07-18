package math;

public class BestTimetoBuyandSellStockII {
	// sum of increasing sequence.
	public int maxProfit(int[] prices) {
		int sum = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				sum += diff;
			}
		}
		return sum;
	}
}
