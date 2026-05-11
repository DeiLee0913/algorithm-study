import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_2497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temps = new int[n];
        int sum = 0;
        int max = -1000;

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            temps[i] = Integer.parseInt(st.nextToken());
            // [check] 놓쳤던 것 n = k인 케이스
            if (i < k) {
                sum += temps[i];
                max = sum;
            } else {
                sum += temps[i];
                sum -= temps[i - k];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
}
