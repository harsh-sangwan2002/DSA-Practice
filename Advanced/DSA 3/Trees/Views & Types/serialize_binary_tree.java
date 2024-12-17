import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class serialize_binary_tree {

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

    public int[] solve(TreeNode A) {

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(A);

        while (q.size() != 0) {

            TreeNode node = q.remove();
            res.add(node.val);

            if (node.val != -1) {

                if (node.left == null)
                    q.add(new TreeNode(-1));

                else
                    q.add(node.left);

                if (node.right == null)
                    q.add(new TreeNode(-1));

                else
                    q.add(node.right);
            }
        }

        int[] arr = new int[res.size()];
        int idx = 0;

        for (int val : res)
            arr[idx++] = val;

        return arr;
    }
}
