import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int buckets[] = new int[101];
        for(int it = 1; it <= n; it++) {
            buckets[it] = it;
        }

        for (int it = 0; it < m; it++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int tmp = buckets[i];
            buckets[i] = buckets[j];
            buckets[j] = tmp;
        }

        for (int it = 1; it < n; it++) {
            System.out.print(buckets[it] + " ");
        }

        System.out.println(buckets[n]);
    }
}
