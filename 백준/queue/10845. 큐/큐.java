import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> que = new ArrayDeque<>();

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
                push(que, num);
            } else if (or.equals("pop")) {
                System.out.println(pop(que));
            } else if (or.equals("size")) {
                System.out.println(size(que));
            } else if (or.equals("empty")) {
                System.out.println(empty(que));
            } else if (or.equals("front")) {
                System.out.println(front(que));
            } else if (or.equals("back")) {
                System.out.println(back(que));
            }
        }
    }

    public static void push(Deque<Integer> deque, Integer num) {
        deque.offerLast(num);
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

    public static int front(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            return -1;
        }

        return deque.peekFirst();
    }

    public static int back(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            return -1;
        }

        return deque.peekLast();
    }
}
