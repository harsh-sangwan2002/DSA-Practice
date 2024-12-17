import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    private static class Pair {

        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] rows = { 0, 0, -1, 1 };
    static int[] cols = { -1, 1, 0, 0 };

    public int solve(int[][] A) {

        int n = A.length, m = A[0].length;
        int[][] time = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (A[i][j] == 2) {
                    q.add(new Pair(i, j));
                    time[i][j] = 0;
                }

                else
                    time[i][j] = Integer.MAX_VALUE;
            }
        }

        while (q.size() != 0) {

            Pair pair = q.remove();

            for (int i = 0; i < rows.length; i++) {

                int x = pair.x + rows[i];
                int y = pair.y + cols[i];

                if (x >= 0 && y >= 0 && x < n && y < m && A[x][y] == 1) {
                    A[x][y] = 2;
                    time[x][y] = time[pair.x][pair.y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }

        int ans = -1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (A[i][j] == 1 && time[i][j] == Integer.MAX_VALUE)
                    return -1;

                else if (time[i][j] != Integer.MAX_VALUE)
                    ans = Math.max(ans, time[i][j]);
            }
        }

        return ans;
    }
}