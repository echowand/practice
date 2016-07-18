package math;

import org.junit.Test;

public class FirstBadVersion {
	private int total;
	private int badVersion;

	public int firstBadVersion(int n) {
		int start = 1;
		int end = n;
		while (start + 1 < end) {
			// ** (start+end) will overflow ********
			int mid = start + (end - start) / 2;
			if (isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (isBadVersion(start)) {
			return start;
		}
		return end;
	}

	private boolean isBadVersion(int v) {
		if (v >= badVersion && v <= total) {
			return true;
		}
		return false;
	}

	@Test
	public void test() {
		total = 2126753390;
		badVersion = 1702766719;
		firstBadVersion(total);
	}
}
