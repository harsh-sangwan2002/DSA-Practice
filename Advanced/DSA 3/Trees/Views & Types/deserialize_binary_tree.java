import java.util.ArrayDeque;
import java.util.Queue;

public class deserialize_binary_tree {

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

    public TreeNode solve(int[] A) {

        TreeNode root = new TreeNode(A[0]);

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int idx = 1;

        while (q.size() != 0) {

            TreeNode node = q.remove();

            int val1 = A[idx];
            int val2 = A[idx + 1];

            if (val1 != -1) {
                node.left = new TreeNode(val1);
                q.add(node.left);
            }

            if (val2 != -1) {
                node.right = new TreeNode(val2);
                q.add(node.right);
            }

            idx += 2;
        }

        return root;
    }
}
