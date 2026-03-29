import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] nums = new boolean[2000001];

        for(int i = 0; i < n; i++) {
            nums[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        StringBuilder sb = new StringBuilder();
        // 입력값 -1,000,000를 처리하기 위해서는 0번째 인덱스까지 보아야 함, 등호 포함
        for(int i = 2000000; i >= 0; i--) {
            if(nums[i]) {
                sb.append(i - 1000000).append("\n");
            }
        }

        System.out.print(sb);
    }
}