package easy.searchInABinarySearchTree;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode leftSide = searchBST(root.left, val);

        if (leftSide != null) {
            return leftSide;
        }

        return searchBST(root.right, val);
    }
}
