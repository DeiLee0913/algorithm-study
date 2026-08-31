import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
            int n = progresses.length;
            ArrayList<Integer> answers = new ArrayList<>();

            int maxDay = ((100- progresses[0]) % speeds[0]) == 0 ? 0 : 1;
            maxDay += (100- progresses[0]) / speeds[0];
            int cnt = 1;

            for(int i = 1; i < n; i++) {
                int day = ((100- progresses[i]) % speeds[i] == 0) ? 0 : 1;
                day += (100- progresses[i]) / speeds[i];

                if(day > maxDay) {
                    answers.add(cnt);
                    cnt = 1;
                    maxDay = day;
                }
                else cnt++;
            }

            answers.add(cnt);

            return answers.stream().mapToInt(i -> i).toArray();

    }
}