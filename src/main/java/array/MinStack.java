package array;

import java.util.LinkedList;

public class MinStack {
	LinkedList<Integer> stack = new LinkedList<Integer>();
	LinkedList<Integer> minStack = new LinkedList<Integer>();

	public void push(int x) {
		stack.push(x);
		if (minStack.size() == 0) {
			minStack.push(x);
			return;
		}
		Integer integer = minStack.getFirst();
		if (integer > x) {
			minStack.push(x);
		} else {
			minStack.push(integer);
		}
	}

	public void pop() {
		if (stack.size() == 0) {
			return;
		}
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.getFirst();
	}

	public int getMin() {
		return minStack.getFirst();
	}
}
