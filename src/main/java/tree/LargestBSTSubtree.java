package tree;

public class LargestBSTSubtree {
	private class Result {
		int min;
		int max;
		int sum;

		public Result(int sum, int min, int max) {
			this.sum = sum;
			this.min = min;
			this.max = max;
		}
	}

	private int maxResult = Integer.MIN_VALUE;

	public int largestBSTSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		dfs(root);
		return maxResult;
	}

	private Result dfs(TreeNode node) {

		if (node == null) {
			return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Result left = dfs(node.left);
		Result right = dfs(node.right);

		if (left.sum < 0 || right.sum < 0 || node.val < left.max
				|| node.val > right.min) {
			return new Result(-1, node.val, node.val);
		} else {
			maxResult = Integer.max(maxResult, left.sum + right.sum + 1);
			return new Result(left.sum + right.sum + 1, Integer.min(node.val,
					left.min), Integer.max(node.val, right.max));
		}
	}
}
