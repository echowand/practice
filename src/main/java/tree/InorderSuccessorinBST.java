package tree;

public class InorderSuccessorinBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return root;
		}

		TreeNode succ;
		if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		} else {
			succ = root;
			TreeNode left = inorderSuccessor(root.left, p);
			return left == null ? succ : left;
		}
	}
}
