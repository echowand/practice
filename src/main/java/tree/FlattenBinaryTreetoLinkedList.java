package tree;

public class FlattenBinaryTreetoLinkedList {
	
	// *** very tricky! 
	// prev: treenode linked list
	public void flatten(TreeNode root) {
		dfs(root);
	}

	private TreeNode prev = null;

	private void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		dfs(node.right);
		dfs(node.left);
		node.right = prev;
		node.left = null;
		prev = node;
	}
}
