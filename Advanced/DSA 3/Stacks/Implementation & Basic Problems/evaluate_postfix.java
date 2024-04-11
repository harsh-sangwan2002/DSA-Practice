import java.util.Stack;

public class evaluate_postfix {

    private int operation(int v1, int v2, String ch) {

        if (ch.equals("+"))
            return v1 + v2;

        else if (ch.equals("-"))
            return v1 - v2;

        else if (ch.equals("*"))
            return v1 * v2;

        return v1 / v2;
    }

    public int evalRPN(String[] A) {

        Stack<String> st = new Stack<>();

        for (int i = 0; i < A.length; i++) {

            String str = A[i];

            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {

                int v2 = Integer.parseInt(st.pop());
                int v1 = Integer.parseInt(st.pop());
                int val = operation(v1, v2, str);
                st.push(val + "");
            }

            else
                st.push(str);
        }

        return Integer.parseInt(st.pop());
    }
}
