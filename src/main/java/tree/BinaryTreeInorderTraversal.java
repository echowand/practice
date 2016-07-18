package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode node = root;
		List<Integer> result = new ArrayList<Integer>();
		while (node != null) {
			stack.add(node);
			node = node.left;
		}

		while (!stack.isEmpty()) {
			TreeNode curr = stack.removeLast();
			result.add(curr.val);
			TreeNode right = curr.right;
			while (right != null) {
				stack.add(right);
				right = right.left;
			}
		}
		return result;
	}
}
