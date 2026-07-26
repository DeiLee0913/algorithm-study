// https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.ArrayDeque;

public class PRG_12906 {
    static int[] solution(int[] arr) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int a : arr) {
            if (!q.isEmpty() && q.getLast() == a) continue;
            else q.add(a);
        }

        int[] answer = new int[q.size()];
        int idx = 0;
        for (int num : q) {
            answer[idx++] = num;
        }

        return answer;
    }
}
