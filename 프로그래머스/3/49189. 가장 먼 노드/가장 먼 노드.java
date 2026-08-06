import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;


class Solution {
        int INF = 1000000;

        public int solution(int n, int[][] edge) {
            ArrayList<Integer>[] edges = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }

            for(int[] e: edge) {
                int a = e[0]; int b = e[1];
                edges[a].add(b);
                edges[b].add(a);
            }

            int[] dist = new int[n+1];
            Arrays.fill(dist, INF);
            dist[1] = 0;

            Queue<Integer> que = new ArrayDeque<>();
            que.add(1);

            while(!que.isEmpty()) {
                int cur = que.poll();

                for(int next: edges[cur]) {
                    if(dist[next] > dist[cur] + 1) {
                        dist[next] = dist[cur] + 1;
                        que.add(next);
                    }
                }
            }

            // 최댓값 찾기
            int max = 0;
            int answer = 0;

            for(int d: dist) {
                if(d != INF && d > max) max = d;
            }

            for(int d: dist) {
                if (d == max) answer++;
            }

            return answer;
        }
}
