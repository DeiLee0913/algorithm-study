import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int ans = 0, nth = 0;
        int cnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            int cur = Integer.parseInt(br.readLine());
            ++cnt;

            if (cur > ans) {
                ans = cur;
                nth = cnt;
            }
        }

        System.out.println(ans);
        System.out.println(nth);
    }
}
