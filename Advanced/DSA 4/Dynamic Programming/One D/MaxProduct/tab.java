package MaxProduct;

public class tab {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {

        int min = A[0], max = A[0];
        int ans = A[0];

        for (int i = 1; i < A.length; i++) {

            int a = A[i], b = A[i] * min, c = A[i] * max;

            min = Math.min(a, Math.min(b, c));
            max = Math.max(a, Math.max(b, c));

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
