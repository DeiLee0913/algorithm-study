import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] counts = new int[10001];

        for(int i = 0; i < n; i++) {
            counts[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for(int i = 1; i <= 10000; i++) {
            while(counts[i]-- > 0) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
