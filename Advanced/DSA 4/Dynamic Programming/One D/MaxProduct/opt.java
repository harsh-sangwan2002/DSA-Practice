package MaxProduct;

public class opt {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {

        int[] dp1 = new int[A.length];
        int[] dp2 = new int[A.length];
        dp1[0] = A[0];
        dp2[0] = A[0];
        int ans = A[0];

        for (int i = 1; i < A.length; i++) {

            int a = A[i], b = A[i] * dp1[i - 1], c = A[i] * dp2[i - 1];

            dp1[i] = Math.min(a, Math.min(b, c));
            dp2[i] = Math.max(a, Math.max(b, c));

            ans = Math.max(ans, dp2[i]);
        }

        return ans;
    }
}
