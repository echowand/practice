package string;

/*Given two strings S and T, determine if they are both one edit distance apart.*/

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		int len1 = s.length();
		int len2 = t.length();
		if (Math.abs(len1 - len2) > 1) {
			return false;
		} else if (len1 == len2) {
			return sameLength(s, t);
		} else if (len1 < len2) {
			return diffLength(s, t);
		} else {
			return diffLength(t, s);
		}
	}

	private boolean sameLength(String s1, String s2) {
		boolean isDiff = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (isDiff == true) {
					return false;
				}
				isDiff = true;
			}
		}
		return isDiff;
	}

	private boolean diffLength(String s1, String s2) {
		boolean isDiff = false;
		for (int i = 0, j = 0; i < s1.length(); i++, j++) {
			if (s1.charAt(i) != s2.charAt(j)) {
				if (isDiff == true) {
					return false;
				}
				i--;
				isDiff = true;
			}
		}
		return true;
	}
}
