package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		dfs(root, 0, sum, new ArrayList<Integer>());
		return result;
	}

	private void dfs(TreeNode node, int sum, int target, List<Integer> path) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (node.val + sum == target) {
				List<Integer> temp = new ArrayList<>();
				temp.addAll(path);
				temp.add(node.val);
				result.add(temp);
			}
			return;
		}
		// remove curr node after return from recursion.
		path.add(node.val);
		dfs(node.left, node.val + sum, target, path);
		dfs(node.right, node.val + sum, target, path);
		path.remove(path.size()-1);
	}
}
