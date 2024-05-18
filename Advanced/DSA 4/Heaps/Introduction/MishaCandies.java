import java.util.PriorityQueue;

public class MishaCandies {

    public int solve(int[] A, int B) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : A)
            pq.add(val);

        int total = 0;

        while (pq.size() != 0) {

            int candies = pq.remove();

            if (candies > B)
                break;

            int eat = candies / 2;
            int left = candies - eat;
            total += eat;

            if (pq.size() != 0)
                pq.add(pq.remove() + left);
        }

        return total;
    }
}