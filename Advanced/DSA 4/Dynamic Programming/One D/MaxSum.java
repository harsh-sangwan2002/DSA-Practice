public class MaxSum {

    public int adjacent(int[][] A) {

        int n = A[0].length;
        int[] dp = new int[n];
        dp[0] = Math.max(A[0][0], A[1][0]);

        for (int i = 1; i < n; i++) {

            int include = Math.max(A[0][i], A[1][i]);
            if (i > 1)
                include += dp[i - 2];

            int exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }
}
