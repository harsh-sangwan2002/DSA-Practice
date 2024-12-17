import java.util.HashMap;

public class lucky_numbers {

    public int solve(int A) {

        int[] spf = new int[A + 1];

        for (int i = 0; i < spf.length; i++)
            spf[i] = i;

        for (int i = 2; i <= Math.sqrt(A); i++) {

            if (spf[i] == i) {

                for (int j = i * i; j <= A; j += i) {

                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }

        int lucky = 0;

        for (int i = 2; i <= A; i++) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int val = i;

            while (val != 1) {
                map.put(spf[val], map.getOrDefault(spf[val], 0) + 1);
                val /= spf[val];
            }

            if (map.size() == 2)
                lucky++;
        }

        return lucky;
    }
}
