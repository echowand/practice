package math;

import java.util.HashSet;

public class HappyNumber {
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		int sum = getSum(n);
		while(!set.contains(sum)){
			if(sum==1){
				return true;
			}
			set.add(sum);
			sum = getSum(sum);
		}
		return false;
	}

	private int getSum(int n) {
		int sum = 0;
		while (n > 0) {
			int temp = n % 10;
			sum = sum + temp * temp;
			n = n / 10;
		}
		return sum;
	}
}
