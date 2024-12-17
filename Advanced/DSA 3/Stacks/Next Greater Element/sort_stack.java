import java.util.Stack;

public class sort_stack {

    public int[] solve(int[] A) {

        Stack<Integer> st = new Stack<>();
        Stack<Integer> help = new Stack<>();

        for (int val : A)
            st.push(val);

        while (st.size() != 0) {

            int val = st.pop();

            if (help.size() == 0 || help.peek() <= val)
                help.push(val);

            else {

                while (help.size() > 0 && help.peek() > val) {

                    int x = help.pop();
                    st.push(x);
                }

                help.push(val);
            }
        }

        int[] res = new int[A.length];
        int idx = A.length - 1;

        while (help.size() != 0) {

            int x = help.pop();
            res[idx--] = x;
        }

        return res;
    }
}
