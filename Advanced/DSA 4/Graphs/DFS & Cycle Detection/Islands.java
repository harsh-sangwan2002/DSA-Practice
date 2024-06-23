public class Islands {

    static int[] rows = { -1, 0, 1, 0, -1, 1, -1, 1 };
    static int[] cols = { 0, -1, 0, 1, -1, 1, 1, -1 };

    private void dfs(int[][] A, int i, int j) {

        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 0 || A[i][j] == 2)
            return;

        A[i][j] = 2;

        for (int r = 0; r < rows.length; r++) {

            int x = i + rows[r];
            int y = j + cols[r];
            dfs(A, x, y);
        }
    }

    public int solve(int[][] A) {

        int count = 0;

        for (int i = 0; i < A.length; i++) {

            for (int j = 0; j < A[0].length; j++) {

                if (A[i][j] == 1) {

                    count++;
                    dfs(A, i, j);
                }
            }
        }

        return count;
    }
}
