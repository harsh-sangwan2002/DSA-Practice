import java.util.Stack;

public class MaxRectangle {

    private int[] leftSmaller(int[] A) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            while (st.size() != 0 && A[st.peek()] >= A[i])
                st.pop();

            if (st.size() == 0)
                res[i] = -1;

            else
                res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    private int[] rightSmaller(int[] A) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {

            while (st.size() != 0 && A[st.peek()] >= A[i])
                st.pop();

            if (st.size() == 0)
                res[i] = A.length;

            else
                res[i] = st.peek();

            st.push(i);
        }

        return res;
    }

    private int histogram(int[] A) {

        int ans = A[0];
        int[] left = leftSmaller(A);
        int[] right = rightSmaller(A);

        for (int i = 0; i < A.length; i++) {

            int width = right[i] - left[i] - 1;
            int area = A[i] * width;
            ans = Math.max(ans, area);
        }

        return ans;
    }

    public int maximalRectangle(int[][] A) {

        int[] heights = new int[A[0].length];

        for (int i = 0; i < A[0].length; i++)
            heights[i] = A[0][i];

        int area = histogram(heights);

        for (int i = 1; i < A.length; i++) {

            for (int j = 0; j < A[0].length; j++) {

                if (A[i][j] == 0)
                    heights[j] = 0;

                else
                    heights[j]++;
            }

            area = Math.max(area, histogram(heights));
        }

        return area;
    }
}
