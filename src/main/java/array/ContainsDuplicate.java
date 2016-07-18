package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> distinc = new HashSet<Integer>();
		for (int num : nums) {
			if (distinc.contains(num)) {
				return true;
			}
			distinc.add(num);
		}
		return false;
	}
}
