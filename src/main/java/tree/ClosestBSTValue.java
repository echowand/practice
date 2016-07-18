package tree;

public class ClosestBSTValue {
	public int closestValue(TreeNode root, double target) {
		TreeNode node = root;
		double diff = Double.MAX_VALUE;
		int result = 0;
		while (node != null) {
			double temp = target - node.val;
			if (Math.abs(temp) < diff) {
				diff = Math.abs(temp);
				result = node.val;
			}
			if (target >= node.val) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return result;
	}
}
