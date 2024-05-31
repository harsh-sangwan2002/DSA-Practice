public class UnboundedKnapsack {

    public int solve(int A, int[] val, int[] wt) {

        int[] dp = new int[A + 1];

        for (int i = 0; i < dp.length; i++) {

            int max = 0;

            for (int j = 0; j < val.length; j++) {

                if (i >= wt[j])
                    max = Math.max(max, val[j] + dp[i - wt[j]]);
            }

            dp[i] = max;
        }

        return dp[A];
    }
}
