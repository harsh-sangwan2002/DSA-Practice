import java.util.Stack;

public class next_greater {

    public int[] nextGreater(int[] A) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {

            while (st.size() > 0 && st.peek() <= A[i])
                st.pop();

            if (st.size() == 0)
                res[i] = -1;

            else
                res[i] = st.peek();

            st.push(A[i]);
        }

        return res;
    }
}
