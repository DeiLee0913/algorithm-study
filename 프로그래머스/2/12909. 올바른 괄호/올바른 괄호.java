import java.util.Stack;

class Solution {
    boolean solution(String s) {
            Stack<Character> st = new Stack<>();
        
            boolean answer = true;

        
            for(int i = 0; i < s.length(); i++) { 
                char c = s.charAt(i);
                
                if(c == ')' && st.isEmpty()) {
                    answer = false;
                    break;
                }
                
                if(!st.isEmpty() && st.peek() != c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }


            if(!st.isEmpty()) {
                answer = false;
            }

            return answer;

    }
}