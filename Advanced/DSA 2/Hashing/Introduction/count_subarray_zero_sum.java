import java.util.HashMap;

public class count_subarray_zero_sum {

    public int solve(int[] A) {

        HashMap<Long, Integer> map = new HashMap<>();
        long count = 0L;
        long[] pre = new long[A.length];
        int mod = (int) (1e9) + 7;
        map.put(0L, 1);

        for (int i = 0; i < A.length; i++) {

            if (i == 0)
                pre[i] = A[i] * 1L;

            else
                pre[i] = A[i] + pre[i - 1];
        }

        for (int i = 0; i < pre.length; i++) {

            if (map.containsKey(pre[i])) {

                int freq = map.get(pre[i]);
                count = (count + freq) % mod;
                map.put(pre[i], freq + 1);
            }

            else {

                map.put(pre[i], 1);
            }
        }

        return (int) (count);
    }
}
