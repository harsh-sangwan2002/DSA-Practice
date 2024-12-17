package BalancedBinaryTree;

public class sol {

    // Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    private int flag;

    private int helper(TreeNode root) {

        if (root == null)
            return 0;

        int lh = helper(root.left);
        int rh = helper(root.right);

        if (Math.abs(lh - rh) > 1)
            flag = 0;

        return Math.max(lh, rh) + 1;
    }

    public int isBalanced(TreeNode A) {

        flag = 1;
        helper(A);

        return flag;
    }
}
