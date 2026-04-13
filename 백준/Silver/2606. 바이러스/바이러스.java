import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean infected[];

    public static void infect(int now) {
        visited[now] = true;
        infected[now] = true;
        for(int i = 0; i < graph[now].size(); i++) {
            int next = graph[now].get(i);

            if(visited[next]) {
                continue;
            }

            infect(next);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        infected = new boolean[n + 1];
        visited = new boolean[n + 1];

        infect(1);

        int ans = 0;

        for (boolean computer: infected) {
            if(computer)
                ans++;
        }
        System.out.println(ans - 1);
    }
}
