package tree;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		helper(root);
		return root;
	}

	public void helper(TreeNode node) {
		if (node == null) {
			return;
		}
		TreeNode right = node.right;
		node.right = node.left;
		node.left = right;
		helper(node.left);
		helper(node.right);
	}

}
