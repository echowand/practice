package dp;

import org.junit.Test;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.isEmpty() || s.charAt(0) == '0') {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		char[] chars = s.toCharArray();
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(chars, i - 2, i - 1)) {
				dp[i] += dp[i - 2];
			}

			if (isValid(chars, i - 1, i - 1)) {
				dp[i] += dp[i - 1];
			}
		}
		return dp[s.length()];
	}

	private boolean isValid(char[] chars, int start, int end) {
		if (start == end) {
			return chars[start] != '0';
		}
		int v = (chars[start] - '0') * 10 + chars[end] - '0';
		return v > 9 && v <= 26;
	}

	@Test
	public void test() {
		numDecodings("12");
	}
}
