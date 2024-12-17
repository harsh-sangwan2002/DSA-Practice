import java.util.Arrays;

public class DecodeString {

    int mod = (int) (1e9 + 7);

    private int helper(int idx, String str, int[] dp) {

        if (idx == str.length())
            return 1;

        if (str.charAt(idx) == '0')
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int ans = helper(idx + 1, str, dp) % mod;

        if (idx + 1 < str.length()) {
            String temp = str.substring(idx, idx + 2);
            int val = Integer.parseInt(temp);

            if (val >= 10 && val <= 26)
                ans = (ans + helper(idx + 2, str, dp)) % mod;
        }

        return dp[idx] = ans;
    }

    public int numDecodings(String A) {
        if (A == null || A.length() == 0)
            return 0;

        int[] dp = new int[A.length()];
        Arrays.fill(dp, -1);

        return helper(0, A, dp);
    }
}
