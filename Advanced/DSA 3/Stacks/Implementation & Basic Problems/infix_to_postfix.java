import java.util.Stack;

public class infix_to_postfix {

    private int precedence(char ch) {

        if (ch == '+' || ch == '-')
            return 0;

        else if (ch == '*' || ch == '/')
            return 1;

        else
            return 2;
    }

    public String solve(String A) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < A.length(); i++) {

            char ch = A.charAt(i);

            if (ch != '(' && ch != ')' && ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '^')
                sb.append(ch);

            else if (ch == '(')
                st.push(ch);

            else if (ch == ')') {

                while (st.size() > 0 && st.peek() != '(') {
                    char op = st.pop();
                    sb.append(op);
                }
                st.pop();
            }

            else {

                while (st.size() != 0 && st.peek() != '(' && precedence(st.peek()) >= precedence(ch)) {
                    char op = st.pop();
                    sb.append(op);
                }
                st.push(ch);
            }
        }

        while (st.size() != 0) {

            char op = st.pop();
            sb.append(op);
        }

        return sb.toString();
    }
}
