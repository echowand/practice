package math;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
		String result = "";
		while (n > 0) {
		    n--;
			int temp = n % 26;
			result = (char)(temp + 'A' ) + result;
			n = n / 26;
		}
		return result;
	}
}
