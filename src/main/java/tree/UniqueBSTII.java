package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {
	// List of root nodes.
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}
		return subtree(1, n);
	}

	private List<TreeNode> subtree(int min, int max) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		// Critical: min>max add null to list. 
		if (min > max) {
			result.add(null);
		}
		for (int i = min; i <= max; i++) {
			List<TreeNode> left = subtree(min, i - 1);
			List<TreeNode> right = subtree(i + 1, max);
			for (TreeNode leftNode : left) {
				for (TreeNode rightNode : right) {
					TreeNode node = new TreeNode(i);
					node.left = leftNode;
					node.right = rightNode;
					result.add(node);
				}
			}
		}
		return result;
	}

}
