// Bottom-up
static class Solution {
    static public int solution(int[][] triangle) {
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

// Top-down
static class Top_down_Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;

        int[][] sums = new int[len][];
        for(int i = 0; i < triangle.length; i++) {
            sums[i] = new int[triangle[i].length];
        }

        sums[0][0] = triangle[0][0];

        // [check] 마지막 행 직전까지 수행
        for(int y = 0; y < len - 1; y++) {
            for(int x = 0; x < sums[y].length; x++) {
                // 바로 아래로 내려가는 경우의 최댓값 갱신
                sums[y + 1][x] = Math.max(sums[y+1][x], sums[y][x] + triangle[y+1][x]);
                // 대각선 아래로 내려가는 경우의 최댓값 갱신
                sums[y + 1][x + 1] = Math.max(sums[y + 1][x + 1], sums[y][x] + triangle[y + 1][x + 1]);
            }
        }

        // 마지막 행에서 최대값 추출
        int max = -1;
        for(int sum: sums[len - 1]) {
            max = Math.max(max, sum);
        }

        return max;
    }
}