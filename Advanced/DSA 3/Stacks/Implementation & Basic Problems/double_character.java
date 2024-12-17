import java.util.Stack;

public class double_character {
    
    public String solve(String A) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i=A.length()-1; i>=0; i--){

            char ch = A.charAt(i);

            if(st.size()==0 || st.peek()!=ch)
            st.push(ch);

            else 
            st.pop();
        }

        while(st.size()!=0){

            char ch = st.pop();
            sb.append(ch);
        }

        return sb.toString();
    }
}