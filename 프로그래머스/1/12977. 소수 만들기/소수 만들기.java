import java.util.Arrays;

class Solution {
    private int MAX_NUMBER = 3000;
    
    // 에라토스테네스 체로 소수 여부를 저장하는 booelan 배열 반환
    private boolean[] getPrimes() {
        boolean[] primes = new boolean[MAX_NUMBER];
        Arrays.fill(primes, true);
        primes[0] = false; primes[1] = false;

        for(int d = 2; d < MAX_NUMBER / 2; d++) {
            for(int m = 2; m * d < MAX_NUMBER; m++) {
                primes[m * d] = false;
            }
        }

        return primes;
    }

    public int solution(int[] nums) {
        boolean[] primes = getPrimes();

        int ans = 0;
        for(int a = 0; a < nums.length; a++) {
            for(int b = a + 1; b < nums.length; b++) {
                for(int c = b + 1; c < nums.length; c++) {
                    int num = nums[a] + nums[b] + nums[c];
                    if (primes[num]) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}