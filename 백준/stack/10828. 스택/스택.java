import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> s = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        String or;
        int num = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            or = st.nextToken();

            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            if (or.equals("push")) {
                push(s, num);
            } else if (or.equals("pop")) {
                System.out.println(pop(s));
            } else if (or.equals("size")) {
                System.out.println(size(s));
            } else if (or.equals("empty")) {
                System.out.println(empty(s));
            } else if (or.equals("top")) {
                System.out.println(top(s));
            }
        }
    }

    public static void push(Deque<Integer> deque, Integer num) {
        deque.push(num);
    }

    public static int pop(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            return -1;
        }

        int cur = deque.peek();
        deque.pop();

        return cur;
    }

    public static int size(Deque<Integer> deque) {
        return deque.size();
    }

    public static int empty(Deque<Integer> deque) {
        return deque.size() == 0 ? 1 : 0;
    }

    public static int top(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            return -1;
        }

        return deque.peek();
    }
}