package math;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int sum = (D - B) * (C - A) + (H - F) * (G - E);
		if (G < A || C < E || H < B || D < F) {
			return sum;
		}
		int width = Integer.min(C, G) - Integer.max(A, E);
		int height = Integer.min(D, H) - Integer.max(B, F);

		return sum - width * height;

	}
}
