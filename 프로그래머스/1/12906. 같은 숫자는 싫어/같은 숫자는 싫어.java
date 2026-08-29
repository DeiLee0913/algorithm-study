import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int a: arr) {
            if(!q.isEmpty() && q.getLast() == a) continue;
            else q.add(a);
        }

        int[] answer = new int[q.size()];
        int idx = 0;
        for(int num: q) {
            answer[idx++] = num;
        }

        return answer;
    }
}