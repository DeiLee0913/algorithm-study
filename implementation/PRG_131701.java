// https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.HashSet;

public class PRG_131701 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] elements = {7, 9, 1, 1, 4};
//        int[] elements = {1, 1, 1};     // 3
//        int[] elements = {1, 2, 3};     // 6
        int[] elements = {2, 2, 4};     // 4


        System.out.println(sol.solution(elements));
    }

    static class Solution {
        public int solution(int[] elements) {
            int n = elements.length;
            HashSet<Integer> sums = new HashSet<>();

            for(int start = 0; start < n; start++) {
                int sum = elements[start];
                sums.add(sum);

                for(int end = (start + 1) % n; end != start; end = (end + 1) % n) {
                    sum += elements[end];
                    sums.add(sum);
                }
            }

            return sums.size();
        }
    }
}
