package medium.binaryTreeLevelOrderTraversal;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr != null) {
                    temp.add(curr.val);

                    if (curr.left != null) {
                        q.offer(curr.left);
                    }

                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
            }

            answer.add(temp);
        }

        return answer;
    }
}