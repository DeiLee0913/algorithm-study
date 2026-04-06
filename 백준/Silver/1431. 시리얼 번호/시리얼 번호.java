import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static int getSum(String str) {
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                sum += ch - '0';
            }
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] strs = new String[n];

        for(int i = 0; i < n; i++) {
            strs[i] = br.readLine();
        }

//        Arrays.sort(strs, (String a, String b) -> {
//            if(a.length() != b.length()) {
//                return Integer.compare(a.length(), b.length());
//            } else if(getSum(a) != getSum(b)) {
//                return getSum(a) - getSum(b);
//            } else {
//                return a.compareTo(b);
//            }
//        });

        Arrays.sort(strs,
                Comparator.comparingInt(String::length)
                        .thenComparingInt(s -> getSum(s))
                        .thenComparing(Comparator.naturalOrder())
        );

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(strs[i]).append("\n");
        }

        System.out.println(sb);
    }
}
