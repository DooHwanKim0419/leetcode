package medium.pathSumII;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        isTargetSum(root, targetSum, 0, new ArrayList<>(), res);
        return res;
    }

    public void isTargetSum(TreeNode root, int targetSum, int currentSum, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        temp.add(root.val);

        if (root.left == null && root.right == null && currentSum == targetSum) {
            res.add(new ArrayList<>(temp));
        } else {
            isTargetSum(root.left, targetSum, currentSum, temp, res);
            isTargetSum(root.right, targetSum, currentSum, temp, res);
        }

        temp.remove(temp.size() - 1);
    }
}
