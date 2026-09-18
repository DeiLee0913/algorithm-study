// https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class PRG_43163 {
    static class Solution {
        int answer;

        public static void main(String[] args) {
            String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

            Solution sol = new Solution();
            sol.solution("hit", "cog", words);


        }

        public int solution(String begin, String target, String[] words) {
            answer = 100;     // words에 3개 이상, 50개 이하의 단어만 있으므로
            boolean[] visited = new boolean[words.length];

            dfs(begin, 0, target, words, visited);

            return answer;
        }

        void dfs(String now, int cnt, String target, String[] words, boolean[] visited) {
            if (now.equals(target)) {
                answer = Math.min(answer, cnt);
                return;
            }

            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && oneChar(now, words[i])) {
                    visited[i] = true;
                    dfs(words[i], cnt + 1, target, words, visited);
                    visited[i] = false;
                }
            }
        }

        boolean oneChar(String a, String b) {
            int cnt = 0;
            for(int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    cnt++;
                }
            }

            if(cnt == 1) return true;
            else return false;
        }
    }
}
