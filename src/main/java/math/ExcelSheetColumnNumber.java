package math;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			result = result * 26 + (c - 'A' + 1);
		}
		return result;
	}
}
