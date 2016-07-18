package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		Comparator<Interval> myComparator = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		};
		Collections.sort(intervals, myComparator);
		Set<Interval> result = new HashSet<Interval>();
		Interval prev = intervals.get(0);
		Interval temp = null;
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (prev.end < curr.start) {
				result.add(prev);
				if (i == intervals.size() - 1) {
					result.add(curr);
				}
				prev = curr;
			} else {
				temp = new Interval(prev.start, Integer.max(prev.end, curr.end));
				prev = temp;
			}
		}
		if (temp != null) {
			result.add(temp);
		}
		return new ArrayList<Interval>(result);
	}

}


