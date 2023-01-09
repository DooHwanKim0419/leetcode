package medium.lowestCommonAncestorOfABinarySearchTree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int lower = p.val > q.val ? q.val : p.val;
        int higher = p.val > q.val ? p.val : q.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode ancestor = root;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.val > higher && curr.val > lower) {
                ancestor = curr.left;
                queue.offer(curr.left);
            } else if (curr.val < higher && curr.val < lower) {
                ancestor = curr.right;
                queue.offer(curr.right);
            } else {
                ancestor = curr;
            }
        }

        return ancestor;
    }
}
