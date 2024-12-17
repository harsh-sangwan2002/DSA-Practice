public class max_area_react {

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public int maximalRectangle(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        // Initialize the first row of dp
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate dp for subsequent rows
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j] == 1 ? dp[i - 1][j] + 1 : 0;
            }
        }

        int maxArea = 0;

        // Calculate the largest rectangle in each row using dp
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(dp[i]));
        }

        return maxArea;
    }
}
