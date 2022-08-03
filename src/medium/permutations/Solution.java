package medium.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> holder = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, permutation, used);

        return holder;
    }

    void backtrack(int[] nums, List<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            holder.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation.add(nums[i]);
                backtrack(nums, permutation, used);
                used[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}