import java.util.Stack;

class min_stack {

    Stack<Integer> st;
    Stack<Integer> min;

    min_stack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {

        if (st.size() == 0) {
            st.push(x);
            min.push(x);
        }

        else {

            if (min.size() == 0 || min.peek() > x)
                min.push(x);

            st.push(x);
        }
    }

    public void pop() {

        if (st.size() == 0)
            return;

        int val = st.pop();

        if (min.size() > 0 && val == min.peek())
            min.pop();

    }

    public int top() {

        if (st.size() == 0)
            return -1;

        return st.peek();
    }

    public int getMin() {

        if (min.size() == 0)
            return -1;

        return min.peek();
    }
}
