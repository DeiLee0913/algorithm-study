import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Integer.parseInt(br.readLine());
        num *= Integer.parseInt(br.readLine());
        num *= Integer.parseInt(br.readLine());

        int[] nums = new int[10];
        while(num != 0) {
            nums[(int)num % 10]++;
            num /= 10;
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(nums[i]);
        }

    }
}
