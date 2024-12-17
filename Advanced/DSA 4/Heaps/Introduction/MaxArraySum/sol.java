import java.util.PriorityQueue;

public class sol {

    public int solve(int[] A, int B) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : A)
            pq.add(val);

        for (int i = 1; i <= B; i++)
            pq.add(-1 * pq.remove());

        int sum = 0;

        while (pq.size() != 0)
            sum += pq.remove();

        return sum;
    }
}
