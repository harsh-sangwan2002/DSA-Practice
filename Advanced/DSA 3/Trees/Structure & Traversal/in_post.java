public class in_post {

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

    private TreeNode create(int[] in, int is, int ie, int[] post, int ps, int pe) {

        if (ps > pe || is > ie)
            return null;

        TreeNode root = new TreeNode(post[pe]);
        int rootIdx = find(root.val, in, is, ie);
        int ele = rootIdx - is;

        root.left = create(in, is, rootIdx - 1, post, ps, ps + ele - 1);
        root.right = create(in, rootIdx + 1, ie, post, ps + ele, pe - 1);
        return root;
    }

    public TreeNode buildTree(int[] A, int[] B) {

        TreeNode root = create(A, 0, A.length - 1, B, 0, B.length - 1);
        return root;
    }
}
