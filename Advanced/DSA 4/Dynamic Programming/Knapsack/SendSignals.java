public class SendSignals {

    public int solve(int A) {

        long mod = 1000000007;
        long[][] dp = new long[2][A + 1];
        dp[0][1] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= A; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[0][i] %= mod;
            dp[1][i] = dp[0][i - 1] % mod;
        }

        long res = (dp[0][A] + dp[1][A]) % mod;
        
        return (int) res;
    }
}