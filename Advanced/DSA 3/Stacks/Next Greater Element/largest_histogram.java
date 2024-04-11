import java.util.Stack;

public class largest_histogram {

    public int largestRectangleArea(int[] A) {

        Stack<Integer> st = new Stack<>();
        int[] nsl = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            while (st.size() > 0 && A[st.peek()] >= A[i])
                st.pop();

            if (st.size() == 0)
                nsl[i] = -1;

            else
                nsl[i] = st.peek();

            st.push(i);
        }

        int[] nsr = new int[A.length];
        st = new Stack<>();

        for (int i = A.length - 1; i >= 0; i--) {

            while (st.size() > 0 && A[st.peek()] >= A[i])
                st.pop();

            if (st.size() == 0)
                nsr[i] = A.length;

            else
                nsr[i] = st.peek();

            st.push(i);
        }

        int ans = 0;

        for (int i = 0; i < A.length; i++) {

            int left = nsl[i];
            int right = nsr[i];
            int area = (right - left - 1) * A[i];

            ans = Math.max(ans, area);
        }

        return ans;
    }
}
