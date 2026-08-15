import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
                for(int y = triangle.length - 1; y > 0; y--) {
                for (int x = 0; x < triangle[y].length - 1; x++){
                    int max = Math.max(triangle[y][x], triangle[y][x+1]);
                    triangle[y - 1][x] += max;
                }
            }

            // 꼭대기에 누적된 최댓값 반환
            return triangle[0][0];
    }
}