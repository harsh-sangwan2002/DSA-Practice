public class special_index {

    public int solve(int[] A) {

        if (A.length == 1)
            return 1;

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

        int evenSum = 0, oddSum = 0, count = 0;

        for (int i = 0; i < A.length; i++) {

            if (i == 0) {

                evenSum = odd[A.length - 1] - odd[0];
                oddSum = even[A.length - 1] - even[0];
            }

            else {

                evenSum = even[i - 1] + (odd[A.length - 1] - odd[i]);
                oddSum = odd[i - 1] + (even[A.length - 1] - even[i]);
            }

            if (evenSum == oddSum)
                count++;
        }

        return count;
    }
}
