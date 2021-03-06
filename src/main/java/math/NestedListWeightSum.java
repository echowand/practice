package math;

import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation
 * */
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		return dfs(nestedList, 1);
	}

	private int dfs(List<NestedInteger> nestedList, int depth) {
		Iterator<NestedInteger> iter = nestedList.iterator();
		int sum = 0;
		while (iter.hasNext()) {
			NestedInteger curr = iter.next();
			if (curr.isInteger()) {
				sum += (curr.getInteger() * depth);
			} else {
				sum += dfs(curr.getList(), depth + 1);
			}
		}
		return sum;
	}

}