package tree;

import java.util.LinkedList;

public class KthSmallestElementinaBST {
	public int kthSmallest(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		int count = 0;
		TreeNode node = root;
		while (node != null) {
			stack.add(node);
			node = node.left;
		}
		while (!stack.isEmpty() && count <= k) {
			TreeNode curr = stack.removeLast();
			count++;
			if (count == k) {
				return curr.val;
			}
			TreeNode right = curr.right;
			while (right != null) {
				stack.add(right);
				right = right.left;
			}
		}
		return -1;
	}
}
