// https://jungol.co.kr/problem/2813

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_2813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 에라토스테네스 체
        boolean[] chae = new boolean[n+1];
        Arrays.fill(chae, true);

        chae[0] = false; chae[1] = false;

        for(int i = 2; i < n; i++) {
            if (!chae[i]) continue;
            for(int j = 2; i * j <= n; j++) {
                chae[i*j] = false;
            }
        }

        int cnt = 0;

        for(int i = m; i <= n; i++) {
            if (chae[i]) cnt++;
        }

        System.out.println(cnt);
    }
}
