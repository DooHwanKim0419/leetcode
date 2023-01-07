package easy.meetingRooms;

import java.util.Arrays;

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prev = intervals[i-1];
            int[] curr = intervals[i];

            if (prev[1] > curr[0]) {
                return false;
            }
        }

        return true;
    }
}
