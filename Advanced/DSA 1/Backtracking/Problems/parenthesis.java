import java.util.ArrayList;

public class parenthesis {

    private void helper(int n, String ans, ArrayList<String> res, int op, int cl) {

        if (ans.length() == 2 * n) {

            res.add(ans);
            return;
        }

        if (op < n)
            helper(n, ans + "(", res, op + 1, cl);

        if (cl < op)
            helper(n, ans + ")", res, op, cl + 1);
    }

    public String[] generateParenthesis(int A) {

        ArrayList<String> res = new ArrayList<>();
        helper(A, "", res, 0, 0);

        String[] arr = new String[res.size()];
        int idx = 0;

        for (String str : res)
            arr[idx++] = str;

        return arr;
    }
}
