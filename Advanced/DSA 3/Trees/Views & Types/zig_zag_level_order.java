import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class zig_zag_level_order {

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

    public int[][] zigzagLevelOrder(TreeNode A) {

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        st1.push(A);

        while (st1.size() != 0 || st2.size() != 0) {

            List<Integer> list = new ArrayList<>();
            while (st1.size() != 0) {

                TreeNode node = st1.pop();
                list.add(node.val);

                if (node.left != null)
                    st2.push(node.left);

                if (node.right != null)
                    st2.push(node.right);
            }

            if (list.size() != 0)
                res.add(list);

            list = new ArrayList<>();

            while (st2.size() != 0) {

                TreeNode node = st2.pop();
                list.add(node.val);

                if (node.right != null)
                    st1.push(node.right);

                if (node.left != null)
                    st1.push(node.left);
            }

            if (list.size() != 0)
                res.add(list);
        }

        int[][] ans = new int[res.size()][];
        int idx1 = 0;

        for (List<Integer> list : res) {

            int[] arr = new int[list.size()];
            int idx2 = 0;

            for (int val : list)
                arr[idx2++] = val;

            ans[idx1++] = arr;
        }

        return ans;
    }
}
