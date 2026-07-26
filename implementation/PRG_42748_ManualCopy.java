// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;

public class PRG_42748_ManualCopy {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int round = 0;

            for(int[] command: commands) {
                int from = command[0] - 1;
                int to = command[1];
                int target = command[2] - 1;

                int[] arr = new int[to - from];
                int idx = 0;

                for(int i = from; i < to; i++) {
                    arr[idx++] = array[i];
                }

                Arrays.sort(arr);

                answer[round++] = arr[target];
            }

            return answer;
        }
    }
}
