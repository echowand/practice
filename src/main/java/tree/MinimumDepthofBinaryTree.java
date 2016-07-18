package tree;

import java.util.LinkedList;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		curr.add(root);
		int depth = 1;
		if (root == null) {
			return 0;
		}
		while (!curr.isEmpty()) {
			TreeNode node = curr.removeFirst();
			if (node.left == null && node.right == null) {
				break;
			}
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			if (curr.isEmpty() && !next.isEmpty()) {
				depth++;
				curr = next;
				next = new LinkedList<TreeNode>();
			}
		}
		return depth;
	}
}
