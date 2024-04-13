public class second_largest {

    public int solve(int[] A) {

        if (A.length == 1)
            return -1;

        int max = Integer.MIN_VALUE, smax = max;

        for (int val : A)
            max = Math.max(max, val);

        for (int val : A) {

            if (val > smax && val != max)
                smax = val;
        }

        return smax == Integer.MIN_VALUE ? -1 : smax;
    }
}
