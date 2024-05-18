public class divisor_game {

    private int GCD(int a, int b) {

        if (a == 0)
            return b;
        if (b == 0)
            return a;

        return GCD(b, a % b);
    }

    public int solve(int A, int B, int C) {

        int gcd = GCD(B, C);
        int lcm = B * C / gcd;

        return A / lcm;
    }
}