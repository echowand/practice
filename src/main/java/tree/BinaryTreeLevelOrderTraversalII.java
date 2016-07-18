package tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		LinkedList<Integer> array = new LinkedList<Integer>();
		if (root != null) {
			curr.add(root);
		}
		while (!curr.isEmpty()) {
			TreeNode temp = curr.removeFirst();
			array.add(temp.val);
			if (temp.left != null) {
				next.add(temp.left);
			}
			if (temp.right != null) {
				next.add(temp.right);
			}
			if (curr.isEmpty()) {
				result.add(0, array);
				array = new LinkedList<Integer>();
				curr = next;
				next = new LinkedList<TreeNode>();
			}
		}
		return result;
	}
}
