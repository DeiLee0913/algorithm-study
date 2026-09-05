import java.util.HashMap;
import java.util.HashSet;

class Solution {
public int solution(int[] topping) {
        // 공평하게 나눌 수 있는 경우의 수
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        // map에서 나눠질 set
        HashSet<Integer> set = new HashSet<>();

        // map에 모든 topping 넣기
        for(int top: topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }

        for(int top: topping) {
            set.add(top);

            // 이번 토핑의 개수를 하나 줄이기
            int newCount = map.get(top) - 1;
            if (newCount == 0) {
                map.remove(top);
            } else map.put(top, newCount);

            if(map.size() == set.size()) {
                answer++;
            }
        }

        return answer;
    }
}