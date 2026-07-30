// https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.ArrayList;

public class PRG_42840 {
    static public int[] solution(int[] answers) {
        int[] studentA = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] studentB = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] studentC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int scores[] = new int[4];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == studentA[i % studentA.length]) {
                scores[1]++;
            }
            if (answers[i] == studentB[i % studentB.length]) {
                scores[2]++;
            }
            if (answers[i] == studentC[i % studentC.length]) {
                scores[3]++;
            }
        }

        int maxScore = Math.max(Math.max(scores[1], scores[2]), scores[3]);
        ArrayList<Integer> maxScoreStudents = new ArrayList<>();
        for (int s = 1; s <= 3; s++) {
            if (scores[s] == maxScore) maxScoreStudents.add(s);
        }

        int[] answer = new int[maxScoreStudents.size()];
        for (int s = 0; s < maxScoreStudents.size(); s++) {
            answer[s] = maxScoreStudents.get(s);
        }

        return answer;
    }
}
