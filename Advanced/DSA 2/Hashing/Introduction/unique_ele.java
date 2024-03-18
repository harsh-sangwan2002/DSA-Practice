import java.util.HashMap;

public class unique_ele {

    public int solve(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int val : A)
            map.put(val, map.getOrDefault(val, 0) + 1);

        for (int val : A) {

            int freq = map.get(val);

            if (freq == 1)
                count++;
        }

        return count;
    }
}
