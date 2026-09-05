import java.util.HashSet;

static class Solution {
    public int solution(int[] topping) {
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();

        int answer = 0;

        for(int s = 1; s < topping.length - 1; s++) {
            for(int i = 0; i < s; i++) {
                a.add(topping[i]);
            }

            for(int j = s; j < topping.length; j++) {
                b.add(topping[j]);
                if (a.size() < b.size()) break;
            }

            if(a.size() == b.size()) {
                answer++;
            }

            a = new HashSet<>();
            b = new HashSet<>();
        }

        return answer;
    }
}
