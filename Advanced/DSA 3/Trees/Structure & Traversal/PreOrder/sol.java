import java.util.ArrayList;
import java.util.List;

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

    private void helper(TreeNode root, List<Integer> list) {

        if (root == null)
            return;

        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

    public int[] preorderTraversal(TreeNode A) {

        List<Integer> list = new ArrayList<>();
        helper(A, list);

        int[] res = new int[list.size()];
        int idx = 0;

        for (int val : list)
            res[idx++] = val;

        return res;
    }
}
