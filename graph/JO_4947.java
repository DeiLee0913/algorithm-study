
/* Q. 시작이 될 노드, 트리 지름의 양 끝점을 맡는 노드를 어떻게 찾아낼 것인가?
A(AI). 수학적으로 증명된 트리의 지름을 구하는 알고리즘 O(V+E)
1. 임의의 노드(일반적으로 1번 노드)에서 1차 DFS 수행
    : 현재 트리에서 가장 멀리 있는 노드 A를 찾음
2. 찾은 노드 A에서 2차 DFS 수행
    : 수행 A를 시작점으로 다시 가장 멀리 있는 노드 B를 찾음
3. 이때 A와 B 사이의 거리가 트리의 지름이 됨
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO_4947 {
    static ArrayList<Integer>[] adjs;
    static int max_distant = 0;
    static int max_distant_node = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        adjs = new ArrayList[n+1];

        for(int i = 0; i <= n; i++) {
            adjs[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mot = Integer.parseInt(st.nextToken());
            int dau = Integer.parseInt(st.nextToken());

            adjs[mot].add(dau);
            adjs[dau].add(mot);
        }

//        // 가장 마지막 번호를 가진 단말(leaf) 노드를 start로 지정
//        // -> 해당 노드가 트리의 지름을 구성하는 양 끝점 중 하나라는 수학적 보장 X
//        int start = 0;
//        for(int i = 1; i <= n; i++) {
//            if (adjs[i].size() == 1)
//                start = i;
//        }
//
//        dfs(0, start, 0);

        // 1차 DFS: 임의의 노드(1번)에서 가장 멀리 있는 노드 찾기
        dfs(0, 1, 0);

        // 2차 DFS: 1차 탐색에서 찾은 노드부터 가장 멀리 있는 노드 찾기 (트리의 지름)
        max_distant = 0;
        dfs(0, max_distant_node, 0);

        System.out.println(max_distant);
    }

    static void dfs(int prev, int cur, int distant) {
        if(max_distant < distant) {
            max_distant_node = cur;
            max_distant = distant;
        }

        for(int next: adjs[cur]) {

            if(prev != next) {
                dfs(cur, next, distant + 1);
            }
        }
    }
}
