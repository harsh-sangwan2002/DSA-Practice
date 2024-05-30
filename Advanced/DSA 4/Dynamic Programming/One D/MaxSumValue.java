public class MaxSumValue {

    public int solve(int[] A, int B, int C, int D) {

        int[] max = new int[A.length];
        max[0] = A[0] * B;

        for (int i = 1; i < A.length; i++)
            max[i] = Math.max(max[i - 1], A[i] * B);

        max[0] += A[0] * C;
        for (int i = 1; i < A.length; i++)
            max[i] = Math.max(max[i - 1], A[i] * C + max[i]);

        max[0] += A[0] * D;
        for (int i = 1; i < A.length; i++)
            max[i] = Math.max(max[i - 1], A[i] * D + max[i]);

        int ans = max[0];
        for (int val : max)
            ans = Math.max(val, ans);

        return ans;
    }
}
