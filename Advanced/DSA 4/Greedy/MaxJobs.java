import java.util.Arrays;

public class MaxJobs {

    private static class Pair {

        int st;
        int et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }
    }

    public int solve(int[] A, int[] B) {

        Pair[] pairs = new Pair[A.length];

        for (int i = 0; i < A.length; i++)
            pairs[i] = new Pair(A[i], B[i]);

        Arrays.sort(pairs, (p1, p2) -> p1.et - p2.et);

        int jobs = 1, prev = pairs[0].et;

        for (int i = 1; i < pairs.length; i++) {

            Pair p = pairs[i];

            if (p.st >= prev) {
                jobs++;
                prev = p.et;
            }
        }

        return jobs;
    }
}
