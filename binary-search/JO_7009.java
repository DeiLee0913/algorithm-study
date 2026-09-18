// https://jungol.co.kr/problem/7009
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class JO_7009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ppls = new ArrayList<>();
        ArrayList<Integer> wanted = new ArrayList<>();

        ArrayList<Integer> answers = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            ppls.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < q; i++) {
            wanted.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(ppls);

        for(int want: wanted) {
//            if(!ppls.contains(want)) {
            if(!binaryFind(ppls, want)) {
                answers.add(want);
            }
        }

        if(answers.isEmpty()) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            for(int answer: answers) {
                sb.append(answer + " ");
            }
            System.out.println(sb);
        }
    }

    static boolean binaryFind(List<Integer> ppls, int want) {
        int left = 0;
        int right = ppls.size() - 1;

        while(left <= right) {
            int mid = (right + left) / 2;
            int cur = ppls.get(mid);
            if (cur == want) {
                return true;
            }
            else if (cur < want) {
                left = mid  + 1;    // mid 위치는 확인했으므로 그 다음 칸부터
            } else { // cur > want
                right = mid - 1;    // mid 위치는 확인했으므로 그 이전 칸까지
            }
        }

        return false;
    }
}
