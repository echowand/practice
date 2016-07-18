package tree;

import java.util.LinkedList;

public class BST<Key extends Comparable<Key>, Count> {

	private class Node {
		private Key key;
		private Node left, right;
		private Count count; // handle duplicates
		private int N; // number of nodes in subtree

		public Node(Key key) {
			this.key = key;
		}
	}

	private Node root;

	private Node get(Key key) {
		if (root == null || root.key.equals(key)) {
			return root;
		}
		return get(root, key);
	}

	private Node get(Node node, Key key) {
		if (node == null) {
			return null;
		}
		if (node.key == key) {
			return node;
		}
		if (key.compareTo(node.key) < 0) {
			return get(node.left, key);
		} else {
			return get(node.right, key);
		}
	}

	private void put(Key key) {
		if (root == null) {
			root = new Node(key);
		} else {
			put(root, key);
		}
	}

	private void put(Node node, Key key) {
		if (key.compareTo(node.key) == 0) {
			System.out.println("Ignore duplicate");
			return;
		}
		if (key.compareTo(node.key) < 0) {
			if (node.left == null) {
				node.left = new Node(key);
			} else {
				put(node.left, key);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(key);
			} else {
				put(node.right, key);
			}
		}
	}

	private int depth() {
		return depth(root);
	}

	private int depth(Node node) {
		if (node == null) {
			return 0;
		}
		return Integer.max(depth(node.left) + 1, depth(node.right) + 1);
	}

	private boolean isBST(Key min, Key max) {
		return isBST(root, min, max);
	}
	
	private boolean isBST(Node node, Key min, Key max){
		if(node==null){
			return true;
		}
		if(node.key.compareTo(min) < 0){
			return false;
		}
		if(node.key.compareTo(max) > 0){
			return false;
		}
		return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
	}
	
	private void deleteMin(Node node){
		if(node==null){
			return;
		}
		if(node.left == null){
			
		}
	}
	
	private Iterable<Key> bfs() {
		LinkedList<Key> keys = new LinkedList<Key>();
		if (root == null) {
			return keys;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (queue.size() != 0) {
			Node child = queue.remove();
			if (child == null) {
				continue;
			}
			queue.add(child.left);
			queue.add(child.right);
			keys.add(child.key);
		}
		return keys;
	}

	private void inOrderTraversal() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);
	}

	private static void print(Object o) {
		System.out.println(o);
	}

	public static void main(String args[]) {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		System.out.println("-------------------------");
		bst.put(3);
		bst.put(2);
		bst.put(4);
		bst.put(5);
		bst.put(6);
		bst.put(7);
		bst.put(-1);
		bst.put(0);
		bst.put(1);
		bst.put(-3);

		print("BFS:");
		for (Integer key : bst.bfs()) {
			System.out.print(key + " ");
		}

		print("\nIn order traversal:");
		bst.inOrderTraversal();

		print("\nDepth:");
		print(bst.depth());
		
		print("Is BST:");
		print(bst.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		print("Key found: " + bst.get(-3).key);
	}
}
