package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 참고 블로그 : https://st-lab.tistory.com/134
 *
 * 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
 * N이 주어졌을 때, 길이가 N인 계단수가 총 몇개 있는지 구해보자.
 * 0으로 시작하는 수는 계단수가 아니다.
 *
 * 첫째 줄에 정답을 10억으로 나눈 나머지를 출력한다.
 *
 * N번 째 자릿수가 0일 경우 올 수 있는 값은 1 밖에 없다. 또한
 * N번 째 자릿수가 9일 경우 올 수 있는 값은 8 밖에 없다.
 * 나머지 이외의 값( 2<=N<=8)은 각 값보다 -1 또는 +1인 값을 가질 수 있다.
 *
 * 자릿값은 0~9를 가질 수 있고 N개의 자릿수를 표현해야 하므로 2차원 DP 배열을 생성한다.
 * 자릿수는 배열의 경우 0부터 시작하기 떄문에 N+1로 해준다.
 * ex ) N = 1일 때
 * 01, 02, 03, 04 ... 09
 *
 * 자릿수가 1일 때 dp[1][0], dp[1][1], ..., dp[1][9]는 1로 초기화 되어 있어야 한다.
 *
 */
public class BOJ_10844_쉬운계단수 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static final int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        // dp[1][0]은 1자리 계단수를
        // dp[2][0]은 2자리 계단수를 의미하기 때문에 N+1로 선언한다.
        long[][] dp = new long[N+1][10];

        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개 밖에 없다.
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 두 번째 자릿수부터 N까지 탐색
        for(int i = 2; i <= N; i++){
            // i번째 자릿수의 자릿값을 탐색(0~9)
            for (int j = 0; j < 10; j++) {

                // j = 0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능
                if(j == 0){
                    dp[i][0] = dp[i-1][1] % mod;
                }

                // 자릿값이 9라면 이전 자릿수는 8만 가능
                else if(j == 9){
                    dp[i][9] = dp[i-1][8] % mod;
                }

                // 그 이외의 경우 이전 자릿수의 자릿값 +1, -1의 합이 된다.
                else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long answer = 0;

        // 각 자릿값마다 경우의 수를 모두 더해준다.
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }

        System.out.println(answer % mod);
    }
}
