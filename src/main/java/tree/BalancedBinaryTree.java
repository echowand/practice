package tree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		int depth = helper(root);
		if (depth == -1) {
			return false;
		}
		return true;
	}

	public int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = helper(node.left);
		int right = helper(node.right);

		if (left == -1 || right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
