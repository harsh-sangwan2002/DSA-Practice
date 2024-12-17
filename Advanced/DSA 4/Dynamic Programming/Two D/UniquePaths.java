public class UniquePaths {

    private int solve(int[][] A, int i, int j, int[][] dp) {

        if (i == A.length - 1 && j == A[0].length - 1 && A[i][j] == 0)
            return 1;

        if (i >= A.length || j >= A[0].length || i < 0 || j < 0 || A[i][j] == 1)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = solve(A, i + 1, j, dp) + solve(A, i, j + 1, dp);
    }

    public int uniquePathsWithObstacles(int[][] A) {

        int n = A.length, m = A[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++)
                dp[i][j] = -1;
        }

        return solve(A, 0, 0, dp);
    }
}
