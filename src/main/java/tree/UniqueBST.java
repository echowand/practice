package tree;

public class UniqueBST {
	/*
	 * i=3, 
	 * count[3]=count[0]*count[2] // 1 is root
              + count[1]*count[1] // 2 is root
              + count[2]*count[0] // 3 is root
	 * */
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1; // empty tree is tree
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - 1 - j];
			}
		}
		return dp[n];
	}
}
