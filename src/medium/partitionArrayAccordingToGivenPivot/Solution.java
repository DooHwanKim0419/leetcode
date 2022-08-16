package medium.partitionArrayAccordingToGivenPivot;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                left.add(num);
            } else if (num == pivot) {
                mid.add(num);
            } else {
                right.add(num);
            }
        }

        left.addAll(mid);
        left.addAll(right);

        for (int i = 0; i < left.size(); i++) {
            answer[i] = left.get(i);
        }

        return answer;
    }
}
