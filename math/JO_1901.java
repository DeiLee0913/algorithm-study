// https://jungol.co.kr/problem/1901

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO_1901 {
    // 1-base array 사용
    // [check] 1,000,001까지만 다루다보면 1,000,000가 target으로 들어왔을 때 에러 남 -> 여유 있게 1,000,000으로
    static boolean[] chae = new boolean[1000100 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 에라토스테네스 체 준비

        // 0과 1은 미리 소수 아닌 걸로 처리해주기
        chae[0] = true;
        chae[1] = true;

        for(int i = 2; i < 1000100; i++) {
            if (chae[i]) continue;
            else {
                for(int j = 2; j * i < 1000100; j++) {
                    chae[i * j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            findPrime(num);
        }
    }

    static void findPrime(int num) {
        if(!chae[num]) {
            System.out.println(num);
            return;
        }

        int i = 1;
        //[check] for문을 쓰면 작은수(1) 같은 수 처리 시 어려움 있음 -> while문 사용
        while (true) {
            // 왼쪽 수(num - i)가 소수인지 확인 (2 이상인 경우만 유효)
            boolean leftPrime = (num - i >= 2) && !chae[num - i];

            // 오른쪽 수(num + i)가 소수인지 확인 (배열 범위를 넘지 않는지 확인)
            boolean rightPrime = (num + i < chae.length) && !chae[num + i];

            // 1. 둘 다 소수인 경우 (작은 수부터 차례대로 출력)
            if (leftPrime && rightPrime) {
                System.out.println((num - i) + " " + (num + i));
                return;
            }
            // 2. 왼쪽만 소수인 경우
            else if (leftPrime) {
                System.out.println(num - i);
                return;
            }
            // 3. 오른쪽만 소수인 경우
            else if (rightPrime) {
                System.out.println(num + i);
                return;
            }

            // 소수를 찾지 못했다면 거리를 늘려서 계속 탐색
            i++;
        }
    }
}
