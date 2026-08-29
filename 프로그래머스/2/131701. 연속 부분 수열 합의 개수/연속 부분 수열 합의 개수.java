import java.util.HashSet;

class Solution {
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