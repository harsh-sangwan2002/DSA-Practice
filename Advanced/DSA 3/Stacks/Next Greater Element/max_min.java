import java.util.Stack;

public class max_min {

    private int[] smallLeft(int[] arr) {

        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (st.size() > 0 && arr[st.peek()] >= arr[i])
                st.pop();

            if (st.size() == 0)
                res[i] = -1;

            else
                res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    private int[] bigLeft(int[] arr) {

        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (st.size() > 0 && arr[st.peek()] <= arr[i])
                st.pop();

            if (st.size() == 0)
                res[i] = -1;

            else
                res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    private int[] smallRight(int[] arr) {

        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (st.size() > 0 && arr[st.peek()] >= arr[i])
                st.pop();

            if (st.size() == 0)
                res[i] = arr.length;

            else
                res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    private int[] bigRight(int[] arr) {

        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (st.size() > 0 && arr[st.peek()] <= arr[i])
                st.pop();

            if (st.size() == 0)
                res[i] = arr.length;

            else
                res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    public int solve(int[] A) {

        int[] nsl = smallLeft(A);
        int[] nsr = smallRight(A);
        int[] ngl = bigLeft(A);
        int[] ngr = bigRight(A);

        long ans = 0, mod = (long) (1e9 + 7);

        for (int i = 0; i < A.length; i++) {
            long right = ngr[i] - i;
            long left = i - ngl[i];
            ans += (((left * right) % mod) * A[i]) % mod;
            ans %= mod;
            left = i - nsl[i];
            right = nsr[i] - i;
            ans -= (((left * right) % mod) * A[i]) % mod;
            ans += mod;
            ans %= mod;
        }

        if (ans < 0) {
            ans += mod;
        }

        return (int) (ans % mod);
    }
}
