package tree;

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return root;
		}
		// left most leaf is the new root
		TreeNode left = upsideDownBinaryTree(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		return left;
	}

}
