package math;

import org.junit.Test;

public class Sqrt {
	
	// interesting: http://www.cnblogs.com/pkuoliver/archive/2010/10/06/sotry-about-sqrt.html
	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int start = 1;
		int end = x;
		int mid = 0;
		while (start + 1 < end) {
			mid = (start + end) / 2;
			if (mid * mid == x) {
				return mid;
			} else if (x / mid < mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return start;
	}

	@Test
	public void test() {
		System.out.println(mySqrt(3));
		double d = 1.0/0;
		System.out.println(d);
	}
}
