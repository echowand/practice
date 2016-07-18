package math;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
	private static Map<Character, Character> map1;

	public boolean isStrobogrammatic(String num) {
		map1 = new HashMap<Character, Character>();
		map1.put('0', '0');
		map1.put('1', '1');
		map1.put('8', '8');
		map1.put('6', '9');
		map1.put('9', '6');
		for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
			char ci = num.charAt(i);
			char cj = num.charAt(j);
			if (map1.containsKey(ci) && map1.get(ci) == cj) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
