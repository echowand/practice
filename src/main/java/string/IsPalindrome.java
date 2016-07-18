package string;

import java.util.HashSet;
import java.util.Set;

public class IsPalindrome {

	public static Set<Character> set = new HashSet<Character>();
	
	static {
		for (char c = 'a'; c <= 'z'; c++) {
			set.add(c);
		}
		for (char c = '0'; c <= '9'; c++) {
			set.add(c);
		}
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		s = s.toLowerCase();
		while (i <= j) {
			char chari = s.charAt(i);
			char charj = s.charAt(j);
			if (!set.contains(chari)) {
				i++;
				continue;
			}
			if (!set.contains(charj)) {
				j--;
				continue;
			}
			if (chari == charj ) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
