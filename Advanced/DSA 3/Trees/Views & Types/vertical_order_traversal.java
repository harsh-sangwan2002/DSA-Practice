import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class vertical_order_traversal {

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

    private class Pair {

        TreeNode node;
        int lvl;

        Pair(TreeNode node, int lvl) {
            this.node = node;
            this.lvl = lvl;
        }
    }

    public int[][] verticalOrderTraversal(TreeNode A) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(A, 0));

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        while (q.size() != 0) {

            Pair top = q.remove();
            TreeNode node = top.node;
            int lvl = top.lvl;

            if (!map.containsKey(lvl)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(node.val);
                map.put(lvl, temp);
            }

            else {

                List<Integer> temp = map.get(lvl);
                temp.add(node.val);
                map.put(lvl, temp);
            }

            if (node.left != null)
                q.add(new Pair(node.left, lvl - 1));

            if (node.right != null)
                q.add(new Pair(node.right, lvl + 1));

            left = Math.min(left, lvl);
            right = Math.max(right, lvl);
        }

        int[][] ans = new int[map.size()][];
        int idx1 = 0;

        for (int i = left; i <= right; i++) {

            List<Integer> list = map.get(i);
            int[] temp = new int[list.size()];
            int idx2 = 0;

            for (int val : list)
                temp[idx2++] = val;

            ans[idx1++] = temp;
        }

        return ans;
    }
}
