package easy.findTargetIndicesAfterSortingArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int baseIndex = 0;
        int countOfTarget = 0;

        for (int num : nums) {
            if (num < target) {
                baseIndex++;
            } else if (num == target) {
                countOfTarget++;
            }
        }

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < countOfTarget; i++) {
            indices.add(baseIndex);
            baseIndex++;
        }

        return indices;
    }
}
