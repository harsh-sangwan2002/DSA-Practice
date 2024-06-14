public class PainterPartition {

    private boolean isValid(int painters, int[] boards, long time) {

        int k = 1, curr = 0;

        for (int board : boards) {

            if (board + curr <= time)
                curr += board;

            else {

                k++;

                if (k > painters || board > time)
                    return false;

                curr = board;
            }
        }

        return true;
    }

    public int paint(int A, int B, int[] C) {

        long lo = 1, hi = (long) (1e9 + 7), ans = lo, mod = (long) (1e7 + 3);

        while (lo <= hi) {

            long mid = lo + (hi - lo) / 2;

            if (isValid(A, C, mid)) {
                ans = mid % mod;
                hi = mid - 1;
            }

            else
                lo = mid + 1;
        }

        ans = (ans * B) % mod;
        return (int) ans;
    }
}
