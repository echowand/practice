package string;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		char[] array = s.toCharArray();
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < s.length(); i++) {
			if (array[i - 1] == '+' && array[i] == '+') {
				list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
			}
		}
		return list;
	}
}
