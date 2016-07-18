package math;

import java.util.HashMap;

import org.junit.Test;

public class MaxPointsonaLine {
	public int maxPoints(Point[] points) {
		// <slope, number of points that have the same slope>
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int duplicate = 1;
			int vertical = 1;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
					continue;
				}
				double k = points[i].y == points[j].y ? points[i].y : 1.0
						* (points[i].y - points[j].y)
						/ (points[i].x - points[j].x);
				//System.out.println(k);
				if (map.containsKey(k)) {
					map.put(k, map.get(k) + 1);
				} else {
					map.put(k, 2);
				}
			}
			for (Double k : map.keySet()) {
				int sum = map.get(k);
				//System.out.println(sum);
				if (sum + duplicate - 1 > max) {
					max = sum + duplicate - 1;
				}
			}
			if (vertical > max) {
				max = vertical;
			}
			if (duplicate > max) {
				max = duplicate;
			}
		}
		return max;
	}

	@Test
	public void test() {
		Point[] points = new Point[3];
		points[0] = new Point(2, 3);
		points[1] = new Point(3, 3);
		points[2] = new Point(-5, 3);
		maxPoints(points);
	}
}
