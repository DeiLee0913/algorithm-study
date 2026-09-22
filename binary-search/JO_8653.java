import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JO_8653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] ms = new long[n];
        int maxIdx = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            ms[i] = Long.parseLong(st.nextToken());
            if(ms[maxIdx] < ms[i]) {
                maxIdx = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < q; i++) {
            long target = Long.parseLong(br.readLine());
            if(target == ms[maxIdx]) {
                sb.append("T\n");
            } else if (BinarySearchAsc(target, 0, maxIdx - 1, ms)) {
                sb.append("L\n");
            } else if (BinarySearchDesc(target, maxIdx + 1, n - 1, ms)) {
                sb.append("R\n");
            } else sb.append("N\n");
        }

        System.out.print(sb);
    }

    static boolean BinarySearchAsc(long target, int start, int end, long[] arr) {
        int left = start, right = end;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
    static boolean BinarySearchDesc(long target, int start, int end, long[] arr) {
            int left = start, right = end;
            while(left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == target) {
                    return true;
                } else if (arr[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return false;
        }

}
