public class Party {
    
    public int solve(int A) {

        int[] dp = new int[A + 1];
        int mod = 10003;
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {

            dp[i] = dp[i - 1] % mod;
            dp[i] = (dp[i] + (i - 1) * dp[i - 2] % mod) % mod;
        }

        return dp[A];
    }
}
