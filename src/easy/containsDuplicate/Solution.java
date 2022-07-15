package easy.containsDuplicate;

import java.util.HashMap;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int num: nums) {
            if (numMap.containsKey(num)) {
                return true;
            }

            numMap.put(num, 0);
        }

        return false;
    }
}
