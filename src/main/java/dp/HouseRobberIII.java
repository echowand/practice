package dp;

import tree.TreeNode;

public class HouseRobberIII {
	public int rob(TreeNode root) {
		int[] result = helper(root);
		return Integer.max(result[0], result[1]);
	}

	public int[] helper(TreeNode node) {
		if (node == null) {
			return new int[2];
		}
		int[] left = helper(node.left);
		int[] right = helper(node.right);

		// currNode contains two integers: [noRob, rob]
		int[] result = new int[2];
		result[0] = Integer.max(left[0], left[1])
				+ Integer.max(right[0], right[1]);
		result[1] = node.val + left[0] + right[0];
		return result;
	}
}
