package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 얻을 수 있는 최대 고객의 수가 1100이다.
 * 주어진 C명의 고객 수를 얻기 위한 최소 비용을 구하는 문제이기 때문에 c 값을 초과하더라도 최솟 비용을 구하면 된다.
 */
public class BOJ_1106_호텔 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int needCnt, cityCnt;

    static int[] dp;
    public static void main(String[] args)  throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        solution();
    }

    private static void solution() throws IOException  {
        st = new StringTokenizer(br.readLine().trim());

        needCnt = Integer.parseInt(st.nextToken());

        cityCnt = Integer.parseInt(st.nextToken());

        // 각 도시에서 비용으로 얻을 수 있는 고객 수는 100명 이하
        // 적어도 C명을 확보해야하므로 그보다 더 큰 고객을 들였을 때 최소 비용일 수도 있기 때문에 +100을 해준다.
        dp = new int[needCnt+100];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < cityCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            // 최소 customer 명부터 적재될 수 있으므로. customer부터 시작.
            // 한 도시에서 최대 100 값을 가지므로 needCnt+100까지 탐색하면서 가장 낮게 적재될 수 있는 값을 담는다.
            for (int j = customer; j <needCnt+100; j++) {
                // 돈에 정수배만큼 투자할 수 있으므로
                // cost(현재 비용) + dp[j-customer]으로 j명의 고객을 늘린다.
                if(dp[j-customer] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], cost+dp[j-customer]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        // 최소 c명을 확보해야 하므로 dp[c] 부터 탐색
        // 한 도시에서 최대 100의 값을 가질 수 있다. c명을 초과하더라도 비용이 더 적을 수 있으므로 아래와 같이 가장 작게 적재되어있는 값을 찾는 것이다.
        for (int i = needCnt; i < needCnt+100; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    }
}