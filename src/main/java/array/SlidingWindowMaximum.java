package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import org.junit.Test;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0) {
			return nums;
		}
		// deque stores indices.
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int[] result = new int[nums.length - k + 1];
		int i = 0;
		while (i < nums.length) {
			// remove out-of-window numbers
			while (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
				deque.removeFirst();
			}
			// remove smaller numbers from queue last element
			while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
				deque.removeLast();
			}
			// insert to end of deque
			deque.add(i);
			if (i >= k - 1) {
				result[i - k + 1] = nums[deque.getFirst()];
			}
			print(deque);
			i++;
		}
		return result;
	}

	private void print(Deque<Integer> q) {
		Iterator<Integer> iter = q.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}

	@Test
	public void test() {
		int[] array = { 7, 2, 4 };
		int[] result = maxSlidingWindow(array, 2);
		System.out.print(result[0] + ", ");
		System.out.print(result[1]);

	}
}
