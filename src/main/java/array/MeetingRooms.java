package array;

import java.util.Arrays;
import java.util.Comparator;

import math.Interval;

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		Comparator<Interval> comp = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		};

		Arrays.sort(intervals, comp);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}
		return true;
	}
}
