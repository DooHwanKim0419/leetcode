package medium.majorityElementII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int constraint = nums.length / 3;

        for (int num : nums) {
            if (!numMap.containsKey(num)) {
                numMap.put(num, 1);
            } else {
                int count = numMap.get(num) + 1;
                numMap.put(num, count);
            }
        }

        for (var entry : numMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > constraint) {
                answer.add(key);
            }
        }

        return answer;
    }
}
