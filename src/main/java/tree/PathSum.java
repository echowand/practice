package tree;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return dfs(root, 0, sum);
	}

	private boolean dfs(TreeNode node, int sum, int target) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) {
			if (node.val + sum == target) {
				return true;
			} else {
				return false;
			}
		}
		return dfs(node.left, sum + node.val, target)
				|| dfs(node.right, sum + node.val, target);
	}
}
