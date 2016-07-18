package tree;

import java.util.LinkedList;

import org.junit.Test;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		LinkedList<TreeLinkNode> curr = new LinkedList<TreeLinkNode>();
		LinkedList<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
		if (root != null) {
			curr.add(root);
		}
		while (!curr.isEmpty()) {
			TreeLinkNode node = curr.removeFirst();
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			if (curr.isEmpty()) {
				node.next = null;
				curr = next;
				next = new LinkedList<TreeLinkNode>();
			} else {
				// System.out.println(curr.getFirst().val);
				node.next = curr.getFirst();
			}
		}
	}

	@Test
	public void test() {
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		n1.left = n2;
		n1.right = n3;
		connect(n1);
		// System.out.println(n2.right.val);
	}
}
