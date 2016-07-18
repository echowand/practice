package tree;

public class LCAofBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		int val1 = Integer.min(p.val, q.val);
		int val2 = Integer.max(p.val, q.val);
		if (val1 < root.val && root.val < val2) {
			return root;
		} else if (val2 < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}

}
