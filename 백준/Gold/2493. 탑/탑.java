import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Tower {
        int idx;
        int height;

        Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        int last_idx = 0;

        Deque<Tower> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.peekLast().height < cur) {
                dq.removeLast();
            } if (!dq.isEmpty() && dq.peekLast().height > cur) {
                System.out.print(dq.peekLast().idx + " ");
            } else {
                System.out.print("0 ");
            }

            dq.offerLast(new Tower(++cnt, cur));
        }
    }
}
