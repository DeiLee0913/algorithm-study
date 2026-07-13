import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JO_1863_BfsAndDfs {
    static ArrayList<Integer>[] adjs;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjs = new ArrayList[n+1];

        for(int i = 0; i <= n; i++) {
            adjs[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjs[a].add(b);
            adjs[b].add(a);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
//                dfs(i);
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int start) {
        Deque<Integer> que = new ArrayDeque<>();

        que.offer(start);
        visited[start] = true;

        while(!que.isEmpty()) {
            int cur = que.pollFirst();

            for(int i = 0; i < adjs[cur].size(); i++) {
                int next = adjs[cur].get(i);

                if(!visited[next]) {
                    que.addLast(next);
                    visited[next] = true;
                }
            }
        }
    }

//    static void dfs(int cur) {
//        visited[cur] = true;
//
//        for(int i = 0; i < adjs[cur].size(); i++) {
//            int next = adjs[cur].get(i);
//
//            if(!visited[next]) {
//                dfs(next);
//            }
//        }
//
//    }
}
