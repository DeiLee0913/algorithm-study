class Solution {
        int answer;

        public int solution(String begin, String target, String[] words) {
            answer = 100;     // words에 3개 이상, 50개 이하의 단어만 있으므로
            boolean[] visited = new boolean[words.length];
            
            dfs(begin, 0, target, words, visited);

            if(answer == 100) return 0;
            else return answer;
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