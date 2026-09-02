class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

                    for(int y = n - 1; y > 0; y--) {
                        for(int x = 0; x < triangle[y].length - 1; x++) {
                            triangle[y - 1][x] += Math.max(triangle[y][x], triangle[y][x+1]);
                        }
                    }

        return triangle[0][0];
    }
}