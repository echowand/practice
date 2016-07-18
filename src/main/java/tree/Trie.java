package tree;

import java.util.HashMap;

import org.junit.Test;

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode currNode = root;
		for (int i = 0; i < word.length(); i++) {
			char currKey = word.charAt(i);
			if (currNode.children.containsKey(currKey)) {
				currNode = currNode.children.get(currKey);
			} else {
				TrieNode newNode = new TrieNode();
				newNode.key = currKey;
				currNode.children.put(currKey, newNode);
				currNode = newNode;
			}
			if (i == word.length() - 1) {
				currNode.isLeaf = true;
			}
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode currNode = root;
		for (int i = 0; i < word.length(); i++) {
			char currKey = word.charAt(i);
			if (currNode.children.containsKey(currKey)) {
				currNode = currNode.children.get(currKey);
				continue;
			} else {
				return false;
			}
		}
		if (currNode.isLeaf) {
			return true;
		} else {
			return false;
		}
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode currNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			char currKey = prefix.charAt(i);
			if (currNode.children.containsKey(currKey)) {
				currNode = currNode.children.get(currKey);
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
		insert("string");
		insert("strange");
		insert("str");
		System.out.println(startsWith("str"));
		System.out.println(search("strangee"));
		System.out.println(startsWith("strange"));
		System.out.println(search("str"));
	}
}

class TrieNode {
	// Initialize your data structure here.
	public char key;
	public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	public boolean isLeaf = false;

	public TrieNode() {
	}
}
