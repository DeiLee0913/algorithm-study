import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Meeting {
        int startAt;
        int finishAt;

        public Meeting(int startAt, int finishAt) {
            this.startAt = startAt;
            this.finishAt = finishAt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[n];
        PriorityQueue<Meeting> pq = new PriorityQueue<>(
                Comparator.comparingInt((Meeting meeting) -> meeting.finishAt)
                        .thenComparingInt(meeting -> meeting.startAt));


        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(s, f);
            pq.add(new Meeting(s,f));
        }

        int finish = pq.peek().finishAt;
        pq.remove();
        int ans = 1;

        while(!pq.isEmpty()) {
            Meeting cur = pq.remove();
            if(finish <= cur.startAt) {
                finish = cur.finishAt;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
