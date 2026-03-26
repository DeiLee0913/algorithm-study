import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Document {
        int idx;
        int pri;

        Document(int idx, int pri) {
            this.idx = idx;
            this.pri = pri;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Deque<Document> docs = new ArrayDeque<>();
            PriorityQueue<Integer> pris = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int pri = Integer.parseInt(st.nextToken());
                docs.offerLast(new Document(j, pri));
                pris.offer(pri);
            }

            int cnt = 0;
            while(!docs.isEmpty()) {
                Document cur = docs.removeFirst();
                if (cur.pri >= pris.peek()) {
                    pris.remove();
                    cnt++;

                    if(cur.idx == m) {
                        System.out.println(cnt);
                        break;
                    }
                } else {
                    docs.offerLast(cur);
                }
            }
        }
    }
}
