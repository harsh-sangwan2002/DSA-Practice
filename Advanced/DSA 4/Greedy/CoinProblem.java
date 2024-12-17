public class CoinProblem {

    public int solve(int A) {

        int coins = 0, pow = 1;

        while (pow * 5 <= A)
            pow *= 5;

        while (A != 0) {

            coins += A / pow;
            A %= pow;
            pow /= 5;
        }

        return coins;
    }
}
