package medium.singleNumberII;

import java.util.HashSet;

public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> answerSet = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();

        for (int number : nums) {
            if (temp.contains(number)) {
                answerSet.remove(number);
            } else {
                temp.add(number);
                answerSet.add(number);
            }
        }

        return answerSet.iterator().next();
    }
}
