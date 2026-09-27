import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cities = new int[n];

        int right = 0;  // 예산 요청 충 최댓값
        int left = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
            if (right < cities[i]) {
                right = cities[i];
            }
        }

        int m = Integer.parseInt(br.readLine());
        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int city: cities) {
                if (mid < city) {
                    sum += mid;
                } else sum += city;
            }

            if (sum <= m) {
                ans = Math.max(mid, ans);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
