package easy.majorityElement;

import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums) {
            if (!numMap.containsKey(num)) {
                numMap.put(num, 0);
            } else {
                numMap.put(num, numMap.get(num) + 1);
            }
        }

        int answer = 0;
        for (var entry : numMap.entrySet()) {
            int count = entry.getValue();

            if (count >= nums.length / 2) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}
