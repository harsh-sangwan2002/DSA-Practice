import java.util.ArrayList;
import java.util.Collections;

public class b_closest_points {

    private static int dist(int x, int y) {

        return x * x + y * y;
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> list, int B) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Collections.sort(list, (p1, p2) -> dist(p1.get(0), p1.get(1)) - dist(p2.get(0), p2.get(1)));

        for (int i = 0; i < B; i++)
            res.add(list.get(i));

        return res;
    }
}
