public class min_swaps {

    public int solve(int[] A, int B) {

        int count = 0;

        for (int val : A) {

            if (val <= B)
                count++;
        }

        if (count == A.length)
            return 0;

        int bad = 0, ans = Integer.MAX_VALUE;

        for (int i = 0; i < count; i++) {

            if (A[i] > B)
                bad++;
        }

        ans = bad;

        for (int i = count; i < A.length; i++) {

            int prev = A[i - count];

            if (prev > B)
                bad--;

            if (A[i] > B)
                bad++;

            ans = Math.min(ans, bad);
        }

        return ans;
    }
}
