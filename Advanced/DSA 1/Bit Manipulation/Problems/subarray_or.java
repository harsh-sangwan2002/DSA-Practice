public class subarray_or {

    private boolean check(int n, int pos) {

        if ((n & (1 << pos)) != 0)
            return true;

        return false;
    }

    public int solve(int[] A) {

        long sum = 0, mod = (long) (1e9 + 7);

        for (int i = 0; i < 32; i++) {

            int bit = 0;
            for (int j = 0; j < A.length; j++) {

                if (check(A[j], i))
                    bit = j + 1;

                long contri = (bit) * 1L * (1 << i);
                sum = (sum + contri) % mod;
            }
        }

        return (int) sum;
    }
}
