class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students  = new int[n+1];

        int answer = n - lost.length;

        for (int l : lost) {
                students[l]--;
        }

        for (int r : reserve) {
            if(students[r] == -1) answer++;
            students[r]++;
        }


        for(int i = 1; i <= n; i++) {
            if(students[i] == -1) {
                int min = Math.max(0, i - 1);
                int max = Math.min(i + 1, n);

                for(int j = min; j <= max; j++) {
                    if(students[j] == 1) {
                        students[j]++;
                        students[i]--;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}