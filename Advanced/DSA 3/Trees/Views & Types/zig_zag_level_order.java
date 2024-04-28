import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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

        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(A);

        int lvl = 0;

        while (q.size() != 0) {

            List<Integer> list = new ArrayList<>();
            int n = q.size();

            if (lvl % 2 == 0) {

                for (int i = 1; i <= n; i++) {

                    TreeNode node = q.remove();

                    list.add(node.val);

                    if (node.left != null)
                        q.add(node.left);

                    if (node.right != null)
                        q.add(node.right);
                }
            }

            else {

                for (int i = 1; i <= n; i++) {

                    TreeNode node = q.remove();
                    st.push(node);

                    if (node.left != null)
                        q.add(node.left);

                    if (node.right != null)
                        q.add(node.right);
                }

                while (st.size() != 0)
                    list.add(st.pop().val);
            }

            res.add(list);
            lvl++;
        }

        int[][] arr = new int[res.size()][];
        int idx1 = 0;

        for (List<Integer> l : res) {

            int[] temp = new int[l.size()];
            int idx2 = 0;

            for (int val : l)
                temp[idx2++] = val;

            arr[idx1++] = temp;
        }

        return arr;
    }
}
