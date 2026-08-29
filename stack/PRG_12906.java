// https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.ArrayDeque;

public class PRG_12906 {
    static int[] solution(int[] arr) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int num : arr) {
            if(!dq.isEmpty() && num == dq.peekLast()) {
                continue;
            }

            else dq.addLast(num);
        }

        int[] answer = new int[dq.size()];
        int idx = 0;

        for (int num : dq) {
            answer[idx++] = num;
        }

        return answer;
    }
}
