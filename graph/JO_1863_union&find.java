import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1863_UnionAndFind {
    static int[] adjs;
    static int[] parents;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjs = new int[n + 1];
        parents = new int[n + 1];
        rank = new int[n+1];

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(parents[i] == i) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    static int find(int node) {
        if(node == parents[node]) {
            return node;
        }

        return parents[node] = find(parents[node]);
    }

    static void union (int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if(ra != rb) {
            if (rank[ra] < rank[rb]) {
                parents[ra] = rb;
            } else if (rank[ra] > rank[rb]) {
                parents[rb] = ra;
            } else {
                parents[ra] = rb;
                rank[rb]++;
            }
        }
    }
}
