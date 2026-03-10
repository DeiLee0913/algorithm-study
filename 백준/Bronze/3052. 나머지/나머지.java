import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        boolean[] cnt = new boolean[42];

        for(int i = 0; i < 10; i++) {
            int cur = Integer.parseInt(bf.readLine());
            cnt[cur % 42] = true;
        }

        int answer = 0;
        for(int i = 0; i < 42; i++) {
            if(cnt[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
