package medium.threeSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = i + 1;
            int last = nums.length -1 ;
            int leftSide = nums[i];

            while (curr < last) {
                List<Integer> holder = new ArrayList<>();
                int firstE = nums[curr];
                int lastE = nums[last];

                if (firstE + lastE > Math.abs(leftSide)) {
                    last--;
                } else if (firstE + lastE < Math.abs(leftSide)) {
                    curr++;
                } else {
                    holder.add(leftSide);
                    holder.add(firstE);
                    holder.add(lastE);
                    set.add(new ArrayList<>(holder));
                    curr++;
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>(set);
        return answer;
    }
}
