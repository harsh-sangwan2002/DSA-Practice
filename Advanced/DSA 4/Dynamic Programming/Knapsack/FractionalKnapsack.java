import java.util.Arrays;

public class FractionalKnapsack {

    private class Pair {

        int value;
        int weight;
        double ppu;

        Pair(int value, int weight, double ppu) {
            this.value = value;
            this.weight = weight;
            this.ppu = ppu;
        }
    }

    public int solve(int[] A, int[] B, int C) {

        Pair[] pairs = new Pair[A.length];
        double ans = 0.0D;

        for (int i = 0; i < pairs.length; i++)
            pairs[i] = new Pair(A[i], B[i], A[i] * 1.0 / B[i]);

        Arrays.sort(pairs, (p1, p2) -> Double.compare(p2.ppu, p1.ppu));

        for (int i = 0; i < pairs.length; i++) {

            int value = pairs[i].value, wt = pairs[i].weight;
            double ppu = pairs[i].ppu;

            if (C >= wt) {
                C -= wt;
                ans += value;
            }

            else {
                ans += (ppu * C);
                break;
            }
        }

        ans *= 1000;
        return (int) (ans / 10);
    }
}
