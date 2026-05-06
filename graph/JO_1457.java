import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1457 {
    static boolean[][] boards;
    static boolean[][] visited;
    static int cnt = 0;
    static int m, n;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int bfs(Point start) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        ArrayDeque<Point> dq = new ArrayDeque<>();
        visited[start.r][start.c] = true;
        dq.add(start);

        // 시작점 포함 넓이로 카운트 1로 초기 설정
        int cnt = 1;

        while (!dq.isEmpty()) {
            Point now = dq.poll();
            int y = now.r;
            int x = now.c;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 범위 체크
                if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
                // 방무 여부 및 직사각형 체크
                if (boards[ny][nx] || visited[ny][nx]) continue;

                cnt++;
                visited[ny][nx] = true;
                dq.add(new Point(ny, nx));
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 초기화
        boards = new boolean[m][n];
        visited = new boolean[m][n];
        ArrayList<Integer> sizes = new ArrayList<>();


        // 직사각형 내부 영역 표시
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                Arrays.fill(boards[y], x1, x2, true);
            }
        }

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x] && !boards[y][x]) {
                    cnt++;
                    sizes.add(bfs(new Point(y, x)));
                }
            }
        }

        sizes.sort(Integer::compareTo);
        StringBuilder sb = new StringBuilder(cnt + "\n");
        for (int size : sizes) {
            sb.append(size).append(" ");
        }

        System.out.println(sb);
    }
}
