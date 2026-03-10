import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String str[] = bf.readLine().split(" ");
        int nums[] = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        sort(nums);

        System.out.println(nums[0] + " " + nums[n -1]);
    }
}