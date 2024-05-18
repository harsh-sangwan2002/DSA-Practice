import java.util.ArrayList;
import java.util.Collections;

public class tens_digit_sorting {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        Collections.sort(A, (v1, v2) -> {

            int a = v1 / 10, b = v2 / 10;
            a = a % 10;
            b = b % 10;

            if (a == b)
                return v2 - v1;

            return a - b;
        });

        return A;
    }
}
