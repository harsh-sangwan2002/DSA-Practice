package BalancedBinaryTree;

public class sol2 {

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

    private static class Pair {

        int ht;
        boolean flag;

        Pair(int ht, boolean flag) {
            this.ht = ht;
            this.flag = flag;
        }
    }

    private Pair helper(TreeNode root) {

        if (root == null)
            return new Pair(0, true);

        Pair lp = helper(root.left);
        Pair rp = helper(root.right);

        int myHt = Math.max(lp.ht, rp.ht) + 1;
        boolean flag = lp.flag && rp.flag && (Math.abs(lp.ht - rp.ht) <= 1);

        return new Pair(myHt, flag);
    }

    public int isBalanced(TreeNode A) {

        Pair myPair = helper(A);
        return myPair.flag ? 1 : 0;
    }
}
