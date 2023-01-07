package medium.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        List<int[]> arr = new ArrayList<>();

        for (int[] interval: intervals) {
            if (arr.isEmpty()) {
                arr.add(interval);
                continue;
            }

            if (arr.get(arr.size() - 1)[1] >= interval[0]) {
                arr.get(arr.size() - 1)[1] = Math.max(arr.get(arr.size() - 1)[1], interval[1]);
            } else {
                arr.add(interval);
            }
        }

        int[][] res = new int[arr.size()][2];
        for (int i = 0; i <  arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
    }
}
