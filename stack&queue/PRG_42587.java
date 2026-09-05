```java
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

  class Solution {
      class Process {
          int idx;
          int pri;

          public Process(int idx, int pri) {
              this.idx = idx;
              this.pri = pri;
          }
      }

      public int solution(int[] priorities, int location) {
          Queue<Process> q = new ArrayDeque<>();
          PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

          // index 번호와 priority를 지정해서 큐에 넣기
          for(int i = 0; i < priorities.length; i++) {
              q.add(new Process(i, priorities[i]));
              pq.add(priorities[i]);
          }

          int cnt = 0;
          int priority = pq.poll();

          while(!q.isEmpty()) {
              Process cur = q.poll();

              // 현재 process의 중요도가 가장 높은 priority라면 실행
              if(priority == cur.pri) {
                  cnt++;
                  // 지정된 location의 process인지 확인
                  if(location == cur.idx) {
                      break;
                  }

                  // 새로운 가장 큰 priority의 값 받아오기
                  priority = pq.poll();
              } else {
                  q.add(cur);
              }
          }

          return cnt;
      }

  }
```