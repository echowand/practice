package math;

import java.util.Arrays;

import org.junit.Test;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();
		int[] sum = new int[n2.length() + n1.length()];
		Arrays.fill(sum, 0);

		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				sum[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sum.length; i++) {
			int num = (sum[i] + carry) % 10;
			sb.insert(0, num);
			carry = (sum[i] + carry) / 10;
		}
		// remove leading '0's.
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	@Test
	public void test() {
		System.out.println(multiply("9133", "0"));
	}
}
