package string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {
	public static Set<Character> v = new HashSet<>();
	{
		v.add('a');
		v.add('e');
		v.add('i');
		v.add('o');
		v.add('u');
		v.add('A');
		v.add('E');
		v.add('I');
		v.add('O');
		v.add('U');
	}

	public String reverseVowels(String s) {
		char[] result = new char[s.length()];
		for (int i = 0, j = s.length() - 1; i <= j;) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(j);
			if (v.contains(c1) && v.contains(c2)) {
				result[i] = c2;
				result[j] = c1;
			} else if (v.contains(c1) && !v.contains(c2)) {
				result[j] = c2;
				j--;
			} else if (!v.contains(c1) && v.contains(c2)) {
				result[i] = c1;
				i++;
			} else {
				result[i] = c1;
				result[j] = c2;
				i++;
				j--;
			}
		}
		return new String(result);
	}
}
