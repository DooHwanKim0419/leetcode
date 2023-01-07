package medium.nonOverlappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        List<int[]> arr = new ArrayList<>();

        for (int[] interval: intervals) {
            if (arr.isEmpty()) {
                arr.add(interval);
                continue;
            }

            if (arr.get(arr.size() - 1)[1] > interval[0]) {
                arr.get(arr.size() - 1)[1] = Math.min(arr.get(arr.size() - 1)[1], interval[1]);
            } else {
                arr.add(interval);
            }
        }

        return intervals.length - arr.size();
    }
}
