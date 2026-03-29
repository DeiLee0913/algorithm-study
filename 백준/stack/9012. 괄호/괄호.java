import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            Deque<Character> dq = new ArrayDeque<>();

            for (int j = 0; j < str.length(); j++) {
                char cur = str.charAt(j);

                if (!dq.isEmpty() && dq.peekFirst() == '(' && cur == ')') {
                    dq.removeFirst();
                } else {
                    dq.offerFirst(cur);
                }
            }

            if (dq.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
