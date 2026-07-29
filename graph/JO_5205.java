// https://jungol.co.kr/problem/5205

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO_5205 {
    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] degrees = new int[n+1];
        int[] needed = new int[n+1];
        boolean[] isMiddle = new boolean[n+1];

        needed[n] = 1;

        ArrayList<Edge>[] edges = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, weight));

            degrees[to]++;
            isMiddle[from] = true;
        }

        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if (degrees[i] == 0) {
                que.add(i);
            }
        }

        while(!que.isEmpty()) {
            int curNode = que.poll();

            for(int i = 0; i < edges[curNode].size(); i++) {
                Edge curEdge = edges[curNode].get(i);
                int next = curEdge.dest;
                int weight = curEdge.weight;

                needed[next] += weight * needed[curNode];
                degrees[next]--;

                if(degrees[next] == 0) {
                    que.add(next);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(!isMiddle[i]) {
                System.out.println(i + " " + needed[i]);
            }
        }
    }
}
