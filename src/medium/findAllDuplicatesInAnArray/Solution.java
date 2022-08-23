package medium.findAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums) {
            if (!numMap.containsKey(num)) {
                numMap.put(num, 1);
            } else {
                int count = numMap.get(num) + 1;
                numMap.put(num, count);
            }
        }

        List<Integer> answers = new ArrayList<>();

        for (var entry : numMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if (value == 2) {
                answers.add(key);
            }
        }

        return answers;
    }
}
