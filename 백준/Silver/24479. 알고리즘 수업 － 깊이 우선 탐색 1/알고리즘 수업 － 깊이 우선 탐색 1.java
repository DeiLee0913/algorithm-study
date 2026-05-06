import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] edges;
    static int[] vectors;
    static int cnt;

    public static void dfs(int cur) {
        visited[cur] = true;  // 시작 정점 R을 방문 했다고 표시한다.
        vectors[cur] = ++cnt;

        for(int i = 0; i < edges[cur].size(); i++) {
            int next = edges[cur].get(i);
            if (!visited[next]) dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        edges = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        vectors = new int[n+1];
        cnt = 0;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges[u].add(v);
            edges[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            edges[i].sort(Comparator.naturalOrder());
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(vectors[i]).append("\n");
        }
        System.out.println(sb);
    }
}
