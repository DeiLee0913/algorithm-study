import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO_1060 {
    static ArrayList<Edge> edges;

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.weight = price;
        }
    }

    static int find(int node) {
        if (node == parents[node]) return node;
        else return parents[node] = find(parents[node]);
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if(ra != rb) {
            parents[ra] = parents[rb];
        }
    }

    static int[] parents;
    static int taken_edges = 0;
    static int total_weights = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        edges = new ArrayList<>();
        parents = new int[n+1];

        // 입력 받기
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                int price = Integer.parseInt(st.nextToken());
                // [wAI] 정방향 행렬에서 i < j인 경우만 리스트에 담도록 수정하여 중복 간선 방지 효율적 연산
                if(i >= j) continue;
                Edge edge = new Edge(i, j, price);
                edges.add(edge);
            }
        }

        // 유니온 파인드 초기화 및 에지 오름차순 정렬
        Collections.sort(edges, (a, b) -> Integer.compare(a.weight, b.weight));

        for(int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < edges.size(); i++) {
            // [wAI] if(taken_edges >= n)에서 수정
            if(taken_edges == n - 1) break;

            int from = edges.get(i).from;
            int to = edges.get(i).to;
            int weight = edges.get(i).weight;

            if (find(from) == find(to)) continue;
            else {
                total_weights += weight;
                union(from, to);
                taken_edges++;
            }
        }

        System.out.println(total_weights);
    }
}
