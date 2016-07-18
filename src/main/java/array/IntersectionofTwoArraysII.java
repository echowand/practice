package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list;
		if (nums1.length < nums2.length) {
			list = findIntersection(nums1, nums2);
		} else {
			list = findIntersection(nums2, nums1);
		}
		// int[] result = new int[list.size()];
		// Iterator<Integer> iters = list.iterator();
		// int i = 0;
		// while (iters.hasNext()) {
		// result[i] = iters.next();
		// i++;
		// }
		// return result;

		Integer[] intArray = list.toArray(new Integer[list.size()]);
		// didn't find a good way to convert Integer[] to int[]
		// http://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
		int[] result = new int[list.size()];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = intArray[i];
		}
		return result;
	}

	private List<Integer> findIntersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int num : nums1) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		for (int num : nums2) {
			if (map.keySet().contains(num)) {
				if (map.get(num) <= 0) {
					map.remove(num);
				} else {
					map.put(num, map.get(num) - 1);
					list.add(num);
				}
			}
		}
		return list;
	}
}
