import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 방향 벡터
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static char[][] fields;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        fields = new char[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                fields[i][j] = line.charAt(j);
            }
        }

        // for normal people
        int cnt_normal = 0;
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs_normal(i,j, fields[i][j]);
                    cnt_normal++;
                }
            }
        }

        // for red&green blind
        int cnt_rgb = 0;
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs_rgb(i,j, fields[i][j] == 'B');
                    cnt_rgb++;
                }
            }
        }

        System.out.println(cnt_normal + " " + cnt_rgb);
    }

    public static void dfs_normal(int r, int c, char color) {
        visited[r][c] = true;

        for(int d = 0; d < 4; d++) {
            int nr = r + dy[d];
            int nc = c + dx[d];

            // out of field
            if(nr >= 0 && nc >= 0 && nr < fields.length && nc < fields.length) {
                if (!visited[nr][nc] && fields[nr][nc] == color) {
                    dfs_normal(nr, nc, color);
                }
            }
        }
    }

    public static void dfs_rgb(int r, int c, boolean isB) {
        visited[r][c] = true;

        for(int d = 0; d < 4; d++) {
            int nr = r + dy[d];
            int nc = c + dx[d];

            if(nr >= 0 && nc >= 0 && nr < fields.length && nc < fields.length) {
                if(!visited[nr][nc] && (isB == (fields[nr][nc] == 'B'))) {
                    dfs_rgb(nr, nc, isB);
                }
            }
        }

    }
}
