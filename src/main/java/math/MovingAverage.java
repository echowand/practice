package math;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {

	/** Initialize your data structure here. */
	Deque<Integer> dq;
	double sum;
	int count;
	int maxSize;

	public MovingAverage(int size) {
		dq = new ArrayDeque<Integer>();
		count = 0;
		maxSize = size;
		sum = 0;
	}

	public double next(int val) {
		if (dq.size() >= maxSize) {
			int temp = dq.remove();
			sum -= temp;
			count = maxSize;
		} else {
			count++;
		}
		dq.add(val);
		sum += val;
		return sum / count;
	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size); double param_1 = obj.next(val);
 */
