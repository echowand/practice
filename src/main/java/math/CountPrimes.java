package math;

import java.util.Arrays;

public class CountPrimes {
	public int countPrimes(int n) {
		if (n == 0 || n == 1) {
			return 0;
		}
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i < Math.sqrt(n); i++) {
			int mul = i;
			if (isPrime[mul] == true) {
				while (mul + i < n) {
					mul += i;
					isPrime[mul] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				count++;
			}
		}
		return count;
	}
}
