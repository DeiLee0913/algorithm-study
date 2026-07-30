// https://school.programmers.co.kr/learn/courses/30/lessons/43162

public class PRG_43162 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;

            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    answer++;
                    dfs(i, computers, visited);
                }
            }

            return answer;
        }

        void dfs(int start, int[][] computers, boolean[] visited) {
            visited[start] = true;

            for (int i = 0; i < computers[start].length; i++) {
                if (start == i) continue;
                if (!visited[i] && computers[start][i] == 1) {
                    dfs(i, computers, visited);
                }
            }
        }
    }
}
