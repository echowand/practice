package tree;

public class BinaryTreeLongestConsecutiveSequence {
	private int result = 1;

	public int longestConsecutive(TreeNode root) {
	    if(root==null){
	        return 0;
	    }
		dfs(root, root.val + 1, 1);
		return result;
	}

	public void dfs(TreeNode node, int prev, int sum) {
		if (node == null) {
			return;
		}
		int currSum = 1;
		if (node.val == prev + 1) {
			currSum = sum + 1;
			if (currSum > result) {
				result = currSum;
			}
		}

		dfs(node.left, node.val, currSum);
		dfs(node.right, node.val, currSum);
	}
}
