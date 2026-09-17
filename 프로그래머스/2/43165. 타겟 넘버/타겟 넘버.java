class Solution {
        int answer = 0;
        int tar;

        public int solution(int[] numbers, int target) {
            tar = target;

            dfs(numbers, 0, 0);
            
            return answer;
        }

        void dfs(int[] numbers, int cur, int idx) {
            if(numbers.length == idx && cur == tar) {
                answer++;
            }

            if(idx < numbers.length) {
                dfs(numbers, cur + numbers[idx], idx + 1);
                dfs(numbers, cur - numbers[idx], idx + 1);
            }
        }
    }