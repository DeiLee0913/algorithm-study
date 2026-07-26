// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;

public class PRG_42748_ArraysCopyOfRange {
    class Solution {
        public int[] Solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int round = 0;

            for (int[] command : commands) {
                int[] arr = Arrays.copyOfRange(array, command[0] - 1, command[1]);

                Arrays.sort(arr);

                answer[round++] = arr[command[2] - 1];
            }

            return answer;
        }
    }
}
