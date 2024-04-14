public class closest_min_max {

    private int[] find(int[] arr) {

        int max = arr[0], min = arr[0];

        for (int val : arr) {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        return new int[] { max, min };
    }

    public int solve(int[] A) {

        int[] maxMin = find(A);
        int max = maxMin[0], min = maxMin[1];

        if (max == min)
            return 1;

        int last_max = -1, last_min = -1, len = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {

            if (A[i] == max) {

                if (last_min != -1)
                    len = Math.min(len, i - last_min + 1);

                last_max = i;
            }

            else if (A[i] == min) {

                if (last_max != -1)
                    len = Math.min(len, i - last_max + 1);

                last_min = i;
            }
        }

        return len;
    }
}
