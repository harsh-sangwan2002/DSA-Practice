import java.util.Arrays;

public class noble_integer {

    public int solve(int[] A) {

        Arrays.sort(A);

        int count = 0;

        for (int i = 0; i < A.length; i++) {

            if (i == A.length - 1) {

                if (A[i] == 0)
                    return 1;

                return -1;
            }

            if (A[i] == A[i + 1])
                continue;

            else
                count = A.length - i - 1;

            if (count == A[i])
                return 1;
        }

        return -1;
    }
}
