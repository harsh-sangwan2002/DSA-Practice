import java.util.ArrayList;
import java.util.Collections;

public class factors_sort {

    private int factors(int n) {

        int count = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {

                if (i * i == n)
                    count++;

                else
                    count += 2;
            }
        }

        return count + 2;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        Collections.sort(A, (v1, v2) -> {

            if (factors(v1) == factors(v2))
                return v1 - v2;

            return factors(v1) - factors(v2);
        });

        return A;
    }
}
