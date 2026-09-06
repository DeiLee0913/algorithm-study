import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
                        PriorityQueue<Integer> stated = new PriorityQueue<>(Comparator.reverseOrder());
            for(int c: citations) {
                stated.add(c);
            }

            int cur = 0;    // 지금 꺼낸 논문의 인용 횟수를 담는 변수
            int cnt = 0;    // 지금까지 몇 개의 논문을 꺼냈는지 담는 변수
            while(!stated.isEmpty()) {
                // priority que에서 하나 꺼내서 변수에 담기
                cur = stated.remove();
                cnt++;

                // h-index의 정의를 만족하면 바로 return
                if (cnt == cur) {
                    return cnt;
                // 현재 가진 값(최대 인용 횟수)
                } else if (cnt > cur) {
                    return cnt - 1;
                }
            }

            return cnt;
    }
}