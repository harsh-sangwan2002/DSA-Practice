import java.util.Arrays;

public class MinSquares {

    public int countMinSquares(int A) {

        int[] dp = new int[A + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {

            int ans = dp[i];

            for (int x = 1; x * x <= i; x++)
                ans = Math.min(ans, dp[i - x * x]);

            dp[i] = ans + 1;
        }

        return dp[A];
    }
}
