package dp;

import java.util.Arrays;

import org.junit.Test;

public class CountCat {
	// Count how many target sequences in a string.
	// cacat: 3 cat
	// cacacat: 6 cat
	public int countCat(String s, String t) {
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		Arrays.fill(dp[0], 1);
		// System.out.println("dp len " + dp.length + " dp[0] len " +
		// dp[0].length);
		for (int i = 0; i < t.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				//System.out.println((i + 1) + " " + (j + 1));
				if (t.charAt(i) == s.charAt(j)) {
					dp[i + 1][j + 1] = Integer.max(1, dp[i][j] + dp[i+1][j]);
				} else {
					dp[i + 1][j + 1] = dp[i+1][j];
				}
				//System.out.println(dp[i + 1][j + 1]);
			}
		}
		return dp[t.length()][s.length()];
	}

	@Test
	public void test() {
		System.out.println(countCat("caccaattact", "cat"));
	}
}
