// https://jungol.co.kr/problem/1335

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1335 {
    static boolean[][] boards;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        boards = new boolean[n][n];
        for(int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < n; x++) {
                // 1이면 true(blue), 0이면 false(white)
                boards[y][x] = (Integer.parseInt(st.nextToken()) == 1);
            }
        }

        // 시작 좌표 (0, 0)과 전체 크기 n 전달
        divideAndConquer(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void divideAndConquer(int r, int c, int size) {
        boolean cur = boards[r][c];

        for(int y = r; y < r + size; y++) {
            for(int x = c; x < c + size; x++) {
                if(cur != boards[y][x]) {
                    int newSize = size / 2;
                    divideAndConquer(r, c, newSize);
                    divideAndConquer(r, c + newSize, newSize);
                    divideAndConquer(r+newSize, c, newSize);
                    divideAndConquer(r+newSize, c+ newSize, newSize);

                    // [check] 4분할 재귀 호출을 마치면 현재 함수는 종료하도록 함
                    // break
                    return;
                }
            }
        }

        if (cur) {
            blue++;
        } else {
            white++;
        }
    }
}
