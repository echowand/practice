package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.end < newInterval.start) {
				result.add(curr);
			} else if (curr.start > newInterval.end) {
				result.add(curr);
			} else {
				newInterval = new Interval(Integer.min(newInterval.start,
						curr.start), Integer.max(newInterval.end, curr.end));
			}
		}
		result.add(newInterval);
		Comparator<Interval> comparator = new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
			
		};
		Collections.sort(result, comparator);
		return result;
	}

}
