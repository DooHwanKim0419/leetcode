package easy.pathSum;

import util.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return isTargetSum(root, targetSum, 0);
    }

    public boolean isTargetSum(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return false;
        }

        currentSum += node.val;
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }

        return isTargetSum(node.left, targetSum, currentSum) || isTargetSum(node.right, targetSum, currentSum);
    }
}
