package tree;

import java.util.LinkedList;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

// The overall run time complexity should be O(log (m+n)).

public class BSTIterator {

	private LinkedList<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new LinkedList<TreeNode>();
		insertSelfAndLeftChildren(root);
	}

	private void insertSelfAndLeftChildren(TreeNode node) {
		while (node != null) {
			stack.addFirst(node);
			node = node.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (!stack.isEmpty()) {
			TreeNode node = stack.removeFirst();
			int result = node.val;
			if (node.right != null) {
				insertSelfAndLeftChildren(node.right);
			}
			return result;
		} else {
			return -1;
		}
	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
