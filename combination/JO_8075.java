import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_8075 {
    static int max_joy = 0;
    static int n;
    static int[][] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        friends = new int[n][2];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            friends[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            friends[i][1] = Integer.parseInt(st.nextToken());
        }

        // 0번 친구부터 탐색 시작
        dfs(0, 100, 0);
        System.out.println(max_joy);
    }

    static void dfs(int idx, int hp, int joy) {
        // 체력이 0 이하가 되면 무효
        if (hp <= 0)
            return;

        // 모든 친구를 다 확인했으면 기쁨 갱신 후 종료
        if(idx == n) {
            max_joy = Math.max(max_joy, joy);
            return;
        }

        // 1. idx번째 친구에게 인사를 하는 경우
        dfs(idx + 1, hp-friends[idx][0], joy + friends[idx][1]);

        // 2. idx번째 친구에게 인사를 안 하고 넘어가는 경우
        dfs(idx + 1, hp, joy);
    }
}
