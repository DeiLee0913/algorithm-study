import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class JO_1082_wAI {
    static int r, c;
    static boolean[][] visited;
    static char[][] boards;

    static ArrayDeque<Point> moves = new ArrayDeque<>();
    static ArrayDeque<Point> fires = new ArrayDeque<>();

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int bfs() {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        int mins = 0;

        while(!moves.isEmpty()) {
            // [check] 이동 시작 전에 mins를 키우면 return 시에 mins+1로 리턴할 필요 없음
            mins++;

            // 불 번짐
            // [check] 불 확산 시 현재 큐에 쌓인 불의 개수만큼만 반복
            int fireSize = fires.size();
            for(int i = 0; i < fireSize; i++) {
                Point fire = fires.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = fire.r + dy[d];
                    int nx = fire.c + dx[d];

                    if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                    if (boards[ny][nx] == '.' ) {
                        boards[ny][nx] = '*';
                        fires.add(new Point(ny, nx));
                    }
                }
            }

            // 재우 이동
            // [check] 재우 이동 시에도 현재 큐에 쌓인 불의 개수만큼만 반복
            int moveSize = moves.size();
            for(int i = 0; i < moveSize; i++) {
                Point nowAt = moves.poll();

                for (int d = 0; d < 4; d++) {
                    int ny = nowAt.r + dy[d];
                    int nx = nowAt.c + dx[d];

                    if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                    if (visited[ny][nx]) continue;

                    if (boards[ny][nx] == 'D') return mins;

                    if (boards[ny][nx] == '.') {
                        visited[ny][nx] = true;
                        moves.add(new Point(ny, nx));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        boards = new char[r][c];
        visited = new boolean[r][c];

        for(int y = 0; y < r; y++) {
            boards[y]= br.readLine().toCharArray();
        }

        for(int y = 0; y < r; y++) {
            for(int x = 0; x < c; x++) {
                if(boards[y][x] == 'S') {
                    moves.add(new Point(y, x));
                    //[check] 시작점 방문 처리 놓침
                    visited[y][x] = true;
                } else if(boards[y][x] == '*') {
                    fires.add(new Point(y, x));
                }
            }
        }

        int ans = bfs();
        if (ans == -1) {
            System.out.println("impossible");
        } else System.out.println(ans);
    }
}
