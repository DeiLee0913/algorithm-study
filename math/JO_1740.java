// https://jungol.co.kr/problem/1740

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JO_1740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

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

        int sum = 0; int min = 0;

        for(int i = m; i <= n; i++) {
            if(chae[i]) {
                if(sum == 0) min = i;
                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min);
    }
}
