package tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {

		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) {
			return result;
		}
		curr.add(root);
		List<Integer> level = new LinkedList<Integer>();

		while (!curr.isEmpty()) {
			TreeNode currNode = curr.pollFirst();
			level.add(currNode.val);
			if (currNode.left != null) {
				next.add(currNode.left);
			}
			if (currNode.right != null) {
				next.add(currNode.right);
			}
			if (curr.isEmpty()) {
				curr = next;
				next = new LinkedList<TreeNode>();
				result.add(level);
				level = new LinkedList<Integer>();
			}
		}
		return result;
	}
}
