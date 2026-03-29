import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> candidates = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nges = new int[n];

        for(int i = 0; i < n; i++) {
            dq.offerLast(Integer.parseInt(st.nextToken()));
        }

        candidates.offerFirst(dq.removeLast());
        int cnt = n;
        nges[--cnt] = -1;

        while(!dq.isEmpty()) {
            int cur = dq.removeLast();
            while(!candidates.isEmpty() && cur >= candidates.peekFirst()) {
                candidates.removeFirst();
            }
            if(candidates.isEmpty()) {
                nges[--cnt] = -1;
            } else {
                nges[--cnt] = candidates.peekFirst();
            }

            candidates.offerFirst(cur);
        }

        StringBuilder sb = new StringBuilder();

        for(int nge: nges) {
            sb.append(nge).append(' ');
        }

        System.out.println(sb);
    }
}
