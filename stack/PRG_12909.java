// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.Stack;

public class PRG_12909 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.solution(")()(");
    }

    static class Solution {
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
}
