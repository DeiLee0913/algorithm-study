import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (sa, sb) -> {
                char ca = sa.charAt(n);
                char cb = sb.charAt(n);

                if(ca != cb) return Character.compare(ca, cb);
                else return sa.compareTo(sb);
            });

            return strings;
    }
}