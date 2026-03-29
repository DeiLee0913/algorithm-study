import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int cnt = 1;




        for(int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while(dq.isEmpty() || dq.peekLast() < target) {
                dq.offerLast(cnt++);
                sb.append("+\n");
            }

            if (dq.peekLast() == target) {
                dq.removeLast();
                sb.append("-\n");
            }

            if (!dq.isEmpty() && dq.peekLast() > target) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}