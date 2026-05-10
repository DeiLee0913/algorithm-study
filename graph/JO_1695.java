import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class JO_1695 {
    static int n;
    static int[][] groups;
    static int[][] points;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        points = new int[n][n];
        groups = new int[n][n];

        for(int y = 0; y < n; y++) {
            String instr = br.readLine();
            for(int x = 0; x < n; x++) {
                points[y][x] = Character.getNumericValue(instr.charAt(x));
            }
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(groups[i], -1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0;
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                if(points[y][x] == 1 && groups[y][x] == -1) {
                    result.add(bfs(y, x, cnt++));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");

        result.sort(Integer::compareTo);
        for(int count: result) {
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int cy, int cx, int group) {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        int count = 0; // 단지 내 집 개수를 세는 변수
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.add(new Point(cy, cx));
        groups[cy][cx] = group;
        count++;

        while(!dq.isEmpty()) {
            Point curr = dq.poll();
            int y = curr.r;
            int x = curr.c;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    continue;
                } else if (points[ny][nx] == 0) {
                    continue;
                }

                if(groups[ny][nx] == -1) {
                    groups[ny][nx] = group;
                    dq.add(new Point(ny, nx));
                    count++;
                }
            }
        }

        return count;
    }
}

