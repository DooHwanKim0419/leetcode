package medium.kthSmallestElementInBst;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {
    List<Integer> holder = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        Set<Integer> set = new TreeSet<>();
        holder.forEach(x -> set.add(x));

        Iterator it = set.iterator();

        while (k > 1) {
            it.next();
            k--;
        }

        return (int) it.next();
    }

    public void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr != null) {
                holder.add(curr.val);
                stack.add(curr.right);
                stack.add(curr.left);
            }
        }
    }
}
