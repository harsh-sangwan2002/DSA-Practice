public class count_elements {

    public int solve(int[] A) {

        if (A.length == 1)
            return 0;

        int max = Integer.MIN_VALUE, count = 0;

        for (int val : A)
            max = Math.max(max, val);

        for (int val : A) {

            if (val != max)
                count++;
        }

        return count;
    }
}
