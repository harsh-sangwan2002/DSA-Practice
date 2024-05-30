public class ChordCircle {

    public int chordCnt(int A) {

        long mod = (long) (1e9 + 7);
        long[] C = new long[A + 1];
        C[0] = 1;
        C[1] = 1;

        for (int i = 2; i <= A; i++) {

            for (int j = 0; j < i; j++)
                C[i] = (C[i] + C[j] * C[i - j - 1]) % mod;
        }

        return (int) C[A];
    }
}
