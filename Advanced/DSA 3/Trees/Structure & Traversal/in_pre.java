public class in_pre {

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

    private int find(int tar, int[] arr, int st, int et) {

        for (int i = st; i <= et; i++) {

            if (arr[i] == tar)
                return i;
        }

        return -1;
    }

    private TreeNode create(int[] pre, int ps, int pe, int[] in, int is, int ie) {

        if (is > ie || ps > pe)
            return null;

        TreeNode root = new TreeNode(pre[ps]);
        int rootIdx = find(root.val, in, is, ie);
        int ele = rootIdx - is;

        root.left = create(pre, ps + 1, ps + ele, in, is, rootIdx - 1);
        root.right = create(pre, ps + ele + 1, pe, in, rootIdx + 1, ie);
        return root;
    }

    public TreeNode buildTree(int[] A, int[] B) {

        return create(A, 0, A.length - 1, B, 0, B.length - 1);
    }
}
