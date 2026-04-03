import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Lecture {
        int startAt;
        int finishAt;

        public Lecture(int startAt, int finishAt) {
            this.startAt = startAt;
            this.finishAt = finishAt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Lecture[] lectures = new Lecture[n];
        for(int i= 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(s, t);
        }

        Arrays.sort(lectures, (a, b) -> {
           if(a.startAt != b.startAt) return Integer.compare(a.startAt, b.startAt);
           else return Integer.compare(a.finishAt, b.finishAt);
        });

//        List<Integer> lectureRoom = new ArrayList<>();
        PriorityQueue<Integer> lectureRoom = new PriorityQueue<>();
        lectureRoom.add(lectures[0].finishAt);

        for(int i = 1; i < n; i++) { // i = lecture
            boolean flag = false;   // 이미 있는 강의실에 배정이 가능한지 여부
            for(int j = 0; j < lectureRoom.size(); j++) { // j  = lectureRoom
//                int freeFrom = lectureRoom.get(j);
                int freeFrom = lectureRoom.peek();
                if(freeFrom <= lectures[i].startAt) {
//                    lectureRoom.set(j, lectures[i].finishAt);
                    lectureRoom.remove();
                    lectureRoom.add(lectures[i].finishAt);
                    break;
                } else {
                    lectureRoom.add(lectures[i].finishAt);
                    break;
                }
            }
        }

        System.out.println(lectureRoom.size());
    }
}