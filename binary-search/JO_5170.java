import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_5170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        int ans = 0;

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (right < trees[i]) {
                right = trees[i];
            }
        }

        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for(int tree: trees) {
                if (mid <= tree) {
                    sum += (tree - mid);
                }
            }

//            if (sum != m && ans != 0) {
//                break;
//            }
            if(sum == m) {
                ans = mid;
                break;
            }

            if(sum >= m) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
