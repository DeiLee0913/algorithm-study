import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_2194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        long total_cost = 0;
        long min = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // [check] 그리디 조건: 이중 for문 -> 변수 하나 사용
            // 지난주까지의 최소 단가에 보관료(s)를 더한 값과,
            // 이번 주에 새로 사는 가격(c) 중 더 저렴한 쪽을 선택합니다.
            min = Math.min(min + s, c);
            total_cost += min * y;
        }

        System.out.println(total_cost);
    }
}
