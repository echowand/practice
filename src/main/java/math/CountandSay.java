package math;

import org.junit.Test;

public class CountandSay {
	public String countAndSay(int n) {
		String str = "1";
		int i = 1;
		while (i < n) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			// ***** Using temp var here will run out of heap space *****
			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j - 1) != str.charAt(j)) {
					sb.append(count).append(str.charAt(j - 1));
					count = 1;
				} else {
					count++;
				}
			}
			sb.append(count);
			sb.append(str.charAt(str.length() - 1));
			str = sb.toString();
			i++;
			// System.out.println(i + " " +str);
		}
		return str;
	}

	@Test
	public void test() {
		// System.out.println(countAndSay(25));
	}

}
