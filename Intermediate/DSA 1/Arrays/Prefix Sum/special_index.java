public class special_index {

    public int solve(int[] A) {

        int[] even = new int[A.length];
        int[] odd = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            if (i == 0) {
                even[i] = A[i];
                odd[i] = 0;
            }

            else if (i % 2 == 0) {
                even[i] = even[i - 1] + A[i];
                odd[i] = odd[i - 1];
            }

            else {
                even[i] = even[i - 1];
                odd[i] = odd[i - 1] + A[i];
            }
        }

        int oddSum = 0, evenSum = 0, count = 0;

        for (int i = 0; i < A.length; i++) {

            int et2 = A.length - 1;

            if (i == 0) {
                oddSum = even[et2] - even[i];
                evenSum = odd[et2] - odd[i];
            }

            else {

                oddSum = odd[i - 1] + (even[et2] - even[i]);
                evenSum = even[i - 1] + (odd[et2] - odd[i]);
            }

            if (oddSum == evenSum)
                count++;
        }

        return count;
    }
}
