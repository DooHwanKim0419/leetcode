package medium.kthSmallestElementInABST;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new LinkedList<>();
        inOrderTraversal(root, k, queue);

        int lowest = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            lowest = queue.poll();
        }

        return lowest;
    }

    public void inOrderTraversal(TreeNode node, int k, Queue<Integer> queue) {
        if (node == null || k == 0) {
            return;
        }

        inOrderTraversal(node.left, k, queue);
        queue.offer(node.val);
        k--;
        inOrderTraversal(node.right, k, queue);
    }
}
