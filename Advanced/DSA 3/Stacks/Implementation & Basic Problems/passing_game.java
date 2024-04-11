import java.util.ArrayList;
import java.util.Stack;

public class passing_game {

    public int solve(int A, int B, ArrayList<Integer> C) {

        Stack<Integer> st = new Stack<>();

        for (int val : C) {

            if (val == 0)
                st.pop();

            else
                st.push(val);
        }

        if (st.size() == 0)
            return B;

        return st.peek();
    }
}
