class Solution {
    int[] numbers;
    int answer = 0;
    
    public int solution(int[] number) {
        numbers = number;
        pick(0, 0, 0);
        
        return answer;
    }
    
    void pick(int start, int depth, int sum) {
        if (depth == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }

        for(int i = start; i < numbers.length; i++) {
            pick(i + 1, depth + 1, sum + numbers[i]);
        }
    }
}