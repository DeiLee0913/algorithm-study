import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO_9659 {
    static int target;
    static ArrayList<Integer>[] adjs;
    static int n;

    static int[] parents;
    static int[] depths;

    static int num_of_offsprings = 0;
    static int max_distant = 0;

    static int max_distant_to_anywhere = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adjs = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            adjs[i] = new ArrayList<>();
        }

        parents = new int[n+1];
        depths = new int[n+1];

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cid = Integer.parseInt(st.nextToken());
            int pid = Integer.parseInt(st.nextToken());

            adjs[pid].add(cid);
            adjs[cid].add(pid);
        }

        target = Integer.parseInt(br.readLine());

        fromRoot(1, 0);
        System.out.println(depths[target]);

        fromTarget(target, 0);
        System.out.println(num_of_offsprings);
        System.out.println(max_distant);

//        fromTargetToAnywhere(target);
        fromTargetToAnywhere(0, target, 0);
        System.out.println(max_distant_to_anywhere);
    }

    // (1)
    static void fromRoot(int current, int depth) {
        depths[current] = depth;

        for(int next: adjs[current]) {
            // 부모로 거슬러 올라가지 않게 함
            if(parents[current] != next) {
                parents[next] = current;
                fromRoot(next, depth + 1);
            }
        }
    }


    // (2), (3)
    static void fromTarget(int current, int distant) {
        max_distant = Math.max(distant, max_distant);
        num_of_offsprings++;

        for(int next: adjs[current]) {
            if(parents[current] != next) {
                fromTarget(next, distant + 1);
            }
        }
    }

//    // (4) BFS
//    static void fromTargetToAnywhere(int start) {
//        int[] dist = new int[n + 1];
//        boolean[] visited = new boolean[n+1];
//        ArrayDeque<Integer> que = new ArrayDeque<>();
//
//        que.add(start);
//        visited[start] = true;
//
//        while(!que.isEmpty()) {
//             int curr = que.pollFirst();
//             max_distant_to_anywhere = Math.max(max_distant_to_anywhere, dist[curr]);
//
//             for(int next: adjs[curr]) {
//                 if (!visited[next]) {
//                     visited[next] = true;
//                     dist[next] = dist[curr] + 1;
//                     que.add(next);
//                 }
//         }
//        }
//    }

    // (4) DFS
    static void fromTargetToAnywhere(int prev, int current, int distant) {
        max_distant_to_anywhere = Math.max(distant, max_distant_to_anywhere);

        for(int next: adjs[current]) {
            if(prev != next) {
                fromTargetToAnywhere(current, next, distant + 1);
            }
        }
    }
}

