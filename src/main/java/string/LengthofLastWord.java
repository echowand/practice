package string;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		int i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}
		int start = i;
		while (i >= 0 && s.charAt(i) != ' ') {
			i--;
		}
		if (start == 0) {
			return 0;
		}
		if (i == 0 && s.charAt(0) != ' ') {
			return start + 1;
		}

		return start - i;
	}
}
