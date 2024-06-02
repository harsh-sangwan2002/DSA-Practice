public class Candies {

    public static int solve(int[] A, int[] B, int[] C, int D) {

        int n = A.length;

        int[][] dp = new int[n + 1][D + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= C[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - C[i - 1]] + (A[i - 1] * B[i - 1]));

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][D];
    }

    public static void main(String[] args) {

        int[] A = { 1, 2, 3 };
        int[] B = { 2, 2, 10 };
        int[] C = { 2, 3, 9 };
        int D = 8;

        System.out.println(solve(A, B, C, D));
    }
}
