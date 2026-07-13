import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO_1440 {
    static int[] parents;
    static ArrayList<Integer> ancestors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine().trim());

        parents = new int[n+1];
        ancestors = new ArrayList<>();

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m =  Integer.parseInt(st.nextToken());
            int d =  Integer.parseInt(st.nextToken());

            parents[d] = m;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a =  Integer.parseInt(st.nextToken());
        int b =  Integer.parseInt(st.nextToken());

        findAncestors(a);
        int ans = findLCA(b);

        System.out.println(ans);
    }

    static void findAncestors(int start) {
        ancestors.add(start);

        int parent = parents[start];
        if(parent == 0) {
            return;
        }

        findAncestors(parent);
    }

    static int findLCA(int start) {
        int next = parents[start];
        if(ancestors.contains(next)) {
            return next;
        }
        return findLCA(next);
    }
}
