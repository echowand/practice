package string;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		char[] cs = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (char c : cs) {
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		if (set.size() == 0 || set.size() == 1) {
			return true;
		}
		return false;
	}
}
