public class next_permutation {

    private void reverse(int[] arr, int lo, int hi) {

        while (lo <= hi) {

            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;

            lo++;
            hi--;
        }
    }

    public int[] nextPermutation(int[] A) {

        int k = A.length - 2;

        for (int i = A.length - 2; i >= 0; i--) {

            if (A[i] >= A[i + 1])
                k--;

            else
                break;
        }

        if (k < 0) {
            reverse(A, 0, A.length - 1);
            return A;
        }

        int idx = A.length - 1;
        while (idx > k && A[idx] <= A[k])
            idx--;

        int temp = A[k];
        A[k] = A[idx];
        A[idx] = temp;

        reverse(A, k + 1, A.length - 1);
        return A;
    }
}
