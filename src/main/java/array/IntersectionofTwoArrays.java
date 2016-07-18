package array;

import java.util.HashSet;
import java.util.Iterator;

public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> result = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		for (int num : nums2) {
			if (set.contains(num)) {
				result.add(num);
			}
		}
		int[] array = new int[result.size()];
		Iterator<Integer> iters = result.iterator();
		int i = 0;
		while (iters.hasNext()) {
			array[i] = iters.next();
			i++;
		}
		return array;
	}
}
