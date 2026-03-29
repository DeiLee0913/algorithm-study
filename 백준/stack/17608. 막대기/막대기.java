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

        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());

            while(!dq.isEmpty() && dq.peekLast() <= cur) {
                // pop(x)
                dq.removeLast();
            }

            dq.offerLast(cur);
        }

        System.out.println(dq.size());
    }
}
