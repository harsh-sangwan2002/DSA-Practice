import java.util.Arrays;

public class BirtdayParty {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    private int knapsack(int[] B, int[] C, int capacity, int[] dp) {
        if (capacity == 0)
            return 0; // Base case: zero cost for zero capacity
        if (dp[capacity] != Integer.MAX_VALUE)
            return dp[capacity]; // Return already computed result

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < B.length; i++) {
            if (B[i] <= capacity) {
                int currentCost = knapsack(B, C, capacity - B[i], dp);
                if (currentCost != Integer.MAX_VALUE) {
                    minCost = Math.min(minCost, currentCost + C[i]);
                }
            }
        }

        return dp[capacity] = minCost;
    }

    public int solve(final int[] A, final int[] B, final int[] C) {
        int maxCapacity = Arrays.stream(A).max().orElse(0);

        // Array to store minimum cost for each capacity
        int[] dp = new int[maxCapacity + 1];

        // Initialize dp array with a large value
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Cost of satisfying capacity 0 is 0

        int totalCost = 0;

        // Calculate the minimum cost for each friend's capacity
        for (int capacity : A) {
            int cost = knapsack(B, C, capacity, dp);
            if (cost == Integer.MAX_VALUE)
                return -1; // If a capacity cannot be satisfied, return -1
            totalCost += cost;
        }

        return totalCost;
    }
}
